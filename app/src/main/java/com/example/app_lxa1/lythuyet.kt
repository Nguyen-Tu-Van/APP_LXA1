package com.example.app_lxa1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class lythuyet : AppCompatActivity() {
    var listView: ListView? = null
    var mquestion = arrayOf(
        "Câu 1",
        "Câu 2",
        "Câu 3"
    )
    var mcontent = arrayOf(
        "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì ?",
        "“Phương tiện tham gia giao thông đường bộ” gồm những loại nào ?",
        "Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào ?"
    )
    var manswer = arrayOf(
        "Phần đường xe chạy.",
        "Phương tiện giao thông cơ giới đường bộ & Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.",
        "Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm."
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lythuyet)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarLyThuet) as Toolbar
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
        listView = findViewById(R.id.listViewLyThuyet)
        val adapter: lythuyet.MyAdapter = MyAdapter(this, mcontent,mquestion,manswer)
        listView!!.adapter = adapter
    }
    internal inner class MyAdapter(
        context1: Context,
        var rContent: Array<String>,
        var rQuestion: Array<String>,
        var rAnswer: Array<String>
    ) :
        ArrayAdapter<String?>(context1, R.layout.row_lythuyet, R.id.textViewLyThuyet,rContent) {
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            val layoutInflater =
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row_lythuyet, parent, false)
            val myContent = row.findViewById<TextView>(R.id.textViewLyThuyet)
            val myQuestion = row.findViewById<TextView>(R.id.textViewCauHoi)
            val myAnswer = row.findViewById<TextView>(R.id.textViewDapan)
            myContent.text = rContent[position]
            myQuestion.text = rQuestion[position]
            myAnswer.text = rAnswer[position]

            return row
        }
    }
}