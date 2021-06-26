package com.example.app_lxa1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class meoghinho : AppCompatActivity() {
    var listView: ListView? = null
    var mcontent = arrayOf(
        "Câu hỏi nhường phương tiện nào đi trước: Ưu tiên chọn đáp án “nhường cho phương tiện đường sắt”, “người đi bộ đang đi trên phần đường ưu tiên người đi bộ” và “xe đang đi trên đường chính”",
        "Câu hỏi tuân theo hiệu lệnh của ai: Chọn đáp án “hiệu lệnh của người điều khiển giao thông” và \"biển báo giao thông\".",
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
        setContentView(R.layout.activity_meoghinho)

        listView = findViewById(R.id.listViewMeoGhiNho)
        val adapter: meoghinho.MyAdapter = MyAdapter(this, mcontent)
        listView!!.adapter = adapter
    }
    internal inner class MyAdapter(
        context1: Context,
        var rContent: Array<String>
    ) :
        ArrayAdapter<String?>(context1, R.layout.row_meoghinho, R.id.textViewMeoGhiNho,rContent) {
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            val layoutInflater =
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row_meoghinho, parent, false)
            val myContent = row.findViewById<TextView>(R.id.textViewMeoGhiNho)
            myContent.text = rContent[position]

            return row
        }
    }
}