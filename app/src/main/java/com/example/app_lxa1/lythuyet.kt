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
    var mcontent = arrayOf(
        "Với những câu hỏi có 3 đáp án và có đáp án dài + đáp án ngắn thì kinh nghiệm là đáp án nào ngắn đọc trước. Nếu đáp án đó sai thì chọn 2 đáp án dài còn lại. Và ngược lại…",
        "Hỏi ở “trên cầu”, “trong đường hầm” có được quay đầu xe hay không? –>> Chọn đáp án “Không được quay đầu xe”, nhớ kỹ bất cứ trường hợp nào trong hầm hay trên cầu vượt cũng “không được phép quay đầu xe",
        "Câu hỏi về VÒNG XUYẾN: Nếu “có báo hiệu đi theo vòng xuyến” nhường bên tay trái, “không có dấu hiệu đi theo vòng xuyến” nhường bên tay phải.",
        "Các câu hỏi về CON SỐ: Các đáp án đúng 5m, 5 năm, 18 tuổi, 40 km/h, nhỏ hơn 70 km/h.",
        "Câu hỏi về ĐÔNG DÂN CƯ: Đề bài không có số: chọn đáp án 2, đề bài có số: chọn đáp án có từ “xe gắn máy” ở cuối đáp án.",
        "XE ưu tiên - thứ tự Hoả - Sự - Công - Thương",
        "Nhất lộ: xe nào vào giao lộ được quyền đi trước",
        "Câu hỏi về NỒNG ĐỘ CỒN: Mô tô: thì chọn đáp án 1. Ô tô: thì chọn đáp án 2.",
        "Những câu hỏi có đáp án chứa các từ: “bị nghiêm cấm”, “không được”, “UBND cấp tỉnh”, “Cơ quan, tổ chức, cá nhân” thì mình chọn luôn đáp án đó.",
        "Những câu hỏi liên quan đến khuân vác, vận chuyển chất gây hại, vật nặng: Chọn ngay đáp án “bị nghiêm cấm”."
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
        val adapter: lythuyet.MyAdapter = MyAdapter(this, mcontent)
        listView!!.adapter = adapter
    }
    internal inner class MyAdapter(
        context1: Context,
        var rContent: Array<String>
    ) :
        ArrayAdapter<String?>(context1, R.layout.row_lythuyet, R.id.texViewLyThuyet,rContent) {
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            val layoutInflater =
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row_lythuyet, parent, false)
            val myContent = row.findViewById<TextView>(R.id.texViewLyThuyet)
            myContent.text = rContent[position]
            return row
        }
    }
}