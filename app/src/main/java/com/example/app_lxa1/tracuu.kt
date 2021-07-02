package com.example.app_lxa1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class tracuu : AppCompatActivity() {
    private var list: ArrayList<String>? = null
    private var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracuu)

        val bt_xemay = findViewById<Button>(R.id.bt_traCuu1)
        val bt_oto = findViewById<Button>(R.id.bt_traCuu2)
        val bt_maykeo = findViewById<Button>(R.id.bt_traCuu3)
        val bt_xethoso = findViewById<Button>(R.id.bt_traCuu4)
        val bt_dibo = findViewById<Button>(R.id.bt_traCuu5)
        val bt_dv = findViewById<Button>(R.id.bt_traCuu6)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarTracuu) as Toolbar
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
        val listView = findViewById<ListView>(R.id.listViewTraCuu)
        adapter = ArrayAdapter(this,R.layout.row_tracuu,list!!)
        listView!!.adapter = adapter
        view_tracuu("Tracuuluat/Xe máy")
        bt_xemay.setOnClickListener{
            val path:String = "Tracuuluat/Xe máy"
            view_tracuu(path)
            Toast.makeText(this, "Luật giao thông về xe máy", Toast.LENGTH_SHORT).show()
        }
        bt_oto.setOnClickListener{
            val path:String = "Tracuuluat/Ô tô"
            view_tracuu(path)
            Toast.makeText(this, "Luật giao thông về ô tô", Toast.LENGTH_SHORT).show()
        }
        bt_maykeo.setOnClickListener{
            val path:String = "Tracuuluat/Máy kéo"
            view_tracuu(path)
            Toast.makeText(this, "Luật giao thông về máy kéo", Toast.LENGTH_SHORT).show()
        }
        bt_xethoso.setOnClickListener{
            val path:String = "Tracuuluat/Xe thô sơ"
            view_tracuu(path)
            Toast.makeText(this, "Luật giao thông về xe thô sơ", Toast.LENGTH_SHORT).show()
        }
        bt_dibo.setOnClickListener{
            val path:String = "Tracuuluat/Người đi bộ"
            view_tracuu(path)
            Toast.makeText(this, "Luật giao thông về  người đi bộ", Toast.LENGTH_SHORT).show()
        }
        bt_dv.setOnClickListener{
            val path:String = "Tracuuluat/Động vật"
            view_tracuu(path)
            Toast.makeText(this, "Luật giao thông có liên quan đến động vật", Toast.LENGTH_SHORT).show()
        }
    }
    fun view_tracuu(path:String)
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