package com.example.app_lxa1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class meoghinho : AppCompatActivity() {
    private var list: ArrayList<String>? = null
    private var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meoghinho)

        val bt_lythuyet = findViewById<Button>(R.id.bt_meo1)
        val bt_thuchanh = findViewById<Button>(R.id.bt_meo2)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarMeo) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        toolbar.setNavigationOnClickListener(View.OnClickListener
        { var intent = Intent(this,MainActivity::class.java)
            startActivity(intent) }
        )

        list = ArrayList()
        val listView = findViewById<ListView>(R.id.listViewMeoGhiNho)
        adapter = ArrayAdapter(this,R.layout.row_meoghinho,list!!)
        listView!!.adapter = adapter
        view_meo("Meoghinho/lythuyet")
        bt_lythuyet.setOnClickListener{
            val path:String = "Meoghinho/lythuyet"
            view_meo(path)
            Toast.makeText(this, "Mẹo lý thuyết", Toast.LENGTH_SHORT).show()
        }
        bt_thuchanh.setOnClickListener{
            val path:String = "Meoghinho/thuchanh"
            view_meo(path)
            Toast.makeText(this, "Mẹo thực hành", Toast.LENGTH_SHORT).show()
        }
    }
    fun view_meo(path:String)
    {
        val reference = FirebaseDatabase.getInstance().reference.child(path)
        reference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(data: DataSnapshot) {
                list!!.clear()
                for (snapshot in data.children) {
                    list!!.add(snapshot.getValue().toString())
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}