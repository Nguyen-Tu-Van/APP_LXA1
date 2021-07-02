package com.example.app_lxa1

//import android.support.v7.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val obj: FirebaseDatabase = FirebaseDatabase.getInstance()
//        val mDatabase: DatabaseReference = obj.getReference()
//        for (i in 0..9) {
//            val id = i.toString() + ""
//            mDatabase.child("users").child(id).setValue("TEST")
//        }
//        val database = Firebase.database
//        val myRef = database.getReference("bro")
//
//        myRef.setValue("Hello, World!")

        val bienbao = findViewById<ImageButton>(R.id.bt_bienBao)
        val meo = findViewById<ImageButton>(R.id.bt_meo)
        val thi = findViewById<ImageButton>(R.id.bt_thiSatHach)
        val lyth = findViewById<ImageButton>(R.id.bt_lyThuyet)
        val tra = findViewById<ImageButton>(R.id.bt_traCuu)

        thi.setOnClickListener{
            var intent = Intent(this,dethi::class.java)
            startActivity(intent)
        }
        bienbao.setOnClickListener{
            var intent = Intent(this,bienbaogt::class.java)
            startActivity(intent)
        }
        meo.setOnClickListener{
            var intent = Intent(this,meoghinho::class.java)
            startActivity(intent)
        }
        lyth.setOnClickListener{
            var intent = Intent(this,lythuyet::class.java)
            startActivity(intent)
        }
        tra.setOnClickListener{
            var intent = Intent(this,tracuu::class.java)
            startActivity(intent)

        }
    }
}