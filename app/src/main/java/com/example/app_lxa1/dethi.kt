package com.example.app_lxa1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar

class dethi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dethi)

        val toolbar: Toolbar = findViewById<View>(R.id.toolbarMeo) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        toolbar.setNavigationOnClickListener(
            View.OnClickListener
        { var intent = Intent(this,MainActivity::class.java)
            startActivity(intent) }
        )
        val dethi1 = findViewById<Button>(R.id.bt_de1)
        val dethi2 = findViewById<Button>(R.id.bt_de2)

        dethi1.setOnClickListener{
            var intent = Intent(this,thisathach::class.java)
            startActivity(intent)
        }
        dethi2.setOnClickListener{
            var intent = Intent(this,thisathach::class.java)
            startActivity(intent)
        }
    }
}