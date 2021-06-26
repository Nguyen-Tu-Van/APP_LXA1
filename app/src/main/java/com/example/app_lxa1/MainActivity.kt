package com.example.app_lxa1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bienbao = findViewById<ImageButton>(R.id.bt_bienBao)
        val meo = findViewById<ImageButton>(R.id.bt_meo)

        bienbao.setOnClickListener{
            var intent = Intent(this,bienbaogt::class.java)
            startActivity(intent)
        }
        meo.setOnClickListener{
            var intent = Intent(this,meoghinho::class.java)
            startActivity(intent)
        }

    }
}