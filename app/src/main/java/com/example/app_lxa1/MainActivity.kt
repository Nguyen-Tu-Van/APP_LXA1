package com.example.app_lxa1

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("message")
//
//        myRef.setValue("Hello, World!")

        val bienbao = findViewById<ImageButton>(R.id.bt_bienBao)
        val meo = findViewById<ImageButton>(R.id.bt_meo)
        val thi = findViewById<ImageButton>(R.id.bt_thiSatHach)
        val lythuyet = findViewById<ImageButton>(R.id.bt_lyThuyet)

        thi.setOnClickListener{
            var intent = Intent(this,thisathach::class.java)
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
        lythuyet.setOnClickListener{
            var intent = Intent(this,thisathach2::class.java)
            startActivity(intent)
        }

    }
}