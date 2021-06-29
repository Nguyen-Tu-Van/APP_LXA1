package com.example.app_lxa1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.app_lxa1.models.Question


class ketquathi : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ketquathi)
        var img_ketqua = findViewById<ImageView>(R.id.image_ketqua)
        var intent = intent
        var score = intent.getStringExtra("score")
        var tvTime = intent.getStringExtra("tvTime")
        var ketqua = findViewById<TextView>(R.id.textviewSoCauDung)
        var thilai = findViewById<Button>(R.id.bt_thilai)
        var quayve = findViewById<Button>(R.id.bt_quayve)
        var xemlaikq = findViewById<Button>(R.id.bt_xemlaiketqua)

        if(score.toString().toInt() >=16) img_ketqua.setImageDrawable(getDrawable(R.drawable.dado))
        else img_ketqua.setImageDrawable(getDrawable(R.drawable.datruot))
        ketqua.text = score+"/20"

        thilai.setOnClickListener {
            var intent = Intent(this,thisathach::class.java)
            startActivity(intent)
        }
        quayve.setOnClickListener {
            var intent = Intent(this,dethi::class.java)
            startActivity(intent)
        }
        xemlaikq.setOnClickListener {
            var intent = Intent(this,xemlaiketqua::class.java)
            var list = getIntent().getIntegerArrayListExtra("list")
            var ListQuestion: ArrayList<Question> = ArrayList()
            ListQuestion = getIntent().getSerializableExtra("mListQuestion") as ArrayList<Question>
            intent.putIntegerArrayListExtra("list",list)
            intent.putExtra("mListQuestion", ListQuestion)
            intent.putExtra("score",score)
            intent.putExtra("tvTime",tvTime)
            startActivity(intent)
        }


    }
}