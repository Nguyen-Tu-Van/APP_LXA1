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

class bienbaogt : AppCompatActivity() {
    var listView: ListView? = null
    var mTitle = arrayOf(
        "Đường cấm",
        "Cấm đi ngược chiều",
        "Cấm ô tô",
        "Cấm ô tô rẽ phải",
        "Cấm ô tô rẽ trái"
    )
    var mDescription = arrayOf(
        "Báo đường cấm tất cả loại phương tiện(cơ giới và thô sơ)đi lại cả hai hướng,trừ các xe được ưu tiên theo qui định",
        "Báo đường cấm tất cả các loại xe(cơ giới và thô sơ) đi vào theo chiều đặt biển,trừ các xe được ưu tiên theo quy định",
        "Báo đường cấm tất cả loại xe mô giới cả mô tô 3 bánh có thùng đi qua,trừ mô tô 2 bánh,xe gắn máy và các xe được ưu tiên theo qui định",
        "Báo đường cấm tất cả loại xe mô giới cả mô tô 3 bánh có thùng rẽ phải,trừ mô tô 2 bánh,xe gắn máy và các xe được ưu tiên theo qui định",
        "Báo đường cấm tất cả loại xe mô giới cả mô tô 3 bánh có thùng rẽ trái,trừ mô tô 2 bánh,xe gắn máy và các xe được ưu tiên theo qui định"
    )
    var images = intArrayOf(
        R.drawable.duongcam,
        R.drawable.dinguocchieu,
        R.drawable.camoto,
        R.drawable.camotoretrai,
        R.drawable.camotorephai
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienbaogt)

        val bt_cam = findViewById<Button>(R.id.bt_bienbao1)
        val bt_nguyhiem = findViewById<Button>(R.id.bt_bienbao2)
        val bt_hieulenh = findViewById<Button>(R.id.bt_bienbao3)
        val bt_chidan = findViewById<Button>(R.id.bt_bienbao4)
        val bt_phu = findViewById<Button>(R.id.bt_bienbao5)
        val bt_vachke = findViewById<Button>(R.id.bt_bienbao6)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarBienBao) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        toolbar.setNavigationOnClickListener(View.OnClickListener
        { var intent = Intent(this,MainActivity::class.java)
            startActivity(intent) }
        )

        listView = findViewById(R.id.listView2)
        var adapter: MyAdapter = MyAdapter(this, mTitle, mDescription, images)
        listView!!.adapter = adapter

        bt_cam.setOnClickListener {
            adapter = MyAdapter(this, mTitle, mDescription, images)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo cấm", Toast.LENGTH_SHORT).show()
        }
        bt_nguyhiem.setOnClickListener {
            adapter = MyAdapter(this, mTitle, mDescription, images)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo nguy hiểm", Toast.LENGTH_SHORT).show()
        }
        bt_hieulenh.setOnClickListener {
            adapter = MyAdapter(this, mTitle, mDescription, images)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo hiệu lệnh", Toast.LENGTH_SHORT).show()
        }
        bt_chidan.setOnClickListener {
            adapter = MyAdapter(this, mTitle, mDescription, images)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển bảo chỉ dẫn", Toast.LENGTH_SHORT).show()
        }
        bt_phu.setOnClickListener {
            adapter = MyAdapter(this, mTitle, mDescription, images)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo phụ", Toast.LENGTH_SHORT).show()
        }
        bt_vachke.setOnClickListener {
            adapter = MyAdapter(this, mTitle, mDescription, images)
            listView!!.adapter = adapter
            Toast.makeText(this, "Vạch kẻ đường", Toast.LENGTH_SHORT).show()
        }
//        listView!!.onItemClickListener =
//            AdapterView.OnItemClickListener { parent, view, position, id ->
//                if (position == 0) {
//                    Toast.makeText(this, "Ad", Toast.LENGTH_SHORT).show()
//                }
//                if (position == 1) {
//                    Toast.makeText(this, "Bd", Toast.LENGTH_SHORT).show()
//                }
//                if (position == 2) {
//                    Toast.makeText(this, "Cd", Toast.LENGTH_SHORT).show()
//                }
//                if (position == 3) {
//                    Toast.makeText(this, "Ed", Toast.LENGTH_SHORT).show()
//                }
//                if (position == 4) {
//                    Toast.makeText(this, "Fd", Toast.LENGTH_SHORT).show()
//                }
//            }
    }
        internal inner class MyAdapter(
            context1: Context,
            var rTitle: Array<String>,
            var rDescription: Array<String>,
            var rImgs: IntArray
    ) :
        ArrayAdapter<String?>(context1, R.layout.row_bienbao, R.id.textView1, rTitle) {
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            val layoutInflater =
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row_bienbao, parent, false)
            val images = row.findViewById<ImageView>(R.id.image)
            val myTitle = row.findViewById<TextView>(R.id.textView1)
            val myDescription = row.findViewById<TextView>(R.id.textView2)
            images.setImageResource(rImgs[position])
            myTitle.text = rTitle[position]
            myDescription.text = rDescription[position]
            return row
        }
    }
}