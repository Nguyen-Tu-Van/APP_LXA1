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


class tracuu : AppCompatActivity() {
    var listView: ListView? = null
    var mcontent = arrayOf(
        "Không nhường quyền cho người ưu tiên 60.000-80.000 vnđ",
        "Chuyển hướng không nhường đường 60.000-80.000 vnđ",
        "Lùi xe không có tín hiệu 60.000-80.000 vnđ",
        "Không nhường đường tại nơi giao nhau 60.000-80.000 vnđ",
        "Chuyển làn đường trái phép 80.000-100.000 vnđ",
        "Không nhường đường cho xe xin vượt 80.000-100.000 vnđ",
        "Không nhường đường cho xe ngược chiều 80.000-100.000 vnđ",
        "Quay đầu xe tại nơi cấm 80,000-100.000 vnđ",
        "Chở hàng vượt trọng tải , thiết kế 300.000-400.000 vnđ",
        "Không chấp hành hiệu lệnh 300.000-400.000 vnđ",
        "Không sử dụng đèn khi chạy trong hầm đường bộ 500.000-1.000.000 vnđ",
        "Dùng chân chống quệt xuống đường 2.000.000-3.000.000 vnđ",
        "Gây tai nạn không dừng lại , bỏ trốn 2.000.000-3.000.000 vnđ",
        "Điều khiển xe bằng chân , buông tay , ngồi một bên , nằm trên xe 5.000.000-7.000.000 hoặc 10.000.000 - 14.000.000 ( nếu gây tai nan ) vnđ",
        "Lạng lách , đánh võng 5.000.000-7.000.000 hoặc 10.000.000 - 14.000.000 ( nếu gây tai nạn ) vnđ",
        "Điều khiển xe bằng một bánh 5.000.000-7.000.000 hoặc 10.000.000 - 14.000.000 ( nếu gây tại nạn ) vnđ",
        "Không nhường đường , gây cản trở xe ưu tiên 500.000-1.000.000 vnđ",
        "Trong máu , hơi thở có nồng độ cồn 1.000.000-2.000.000 vnđ",
        "Không chấp hành yêu cầu kiểm tra ma túy , nồng độ cồn 3.000.000-4.000.000 vnđ",
        "Điều khiển xe mà trong cơ thể có chất ma túy 3.000.000-4.000.000 ( trong trường hợp không có giấy phép lái xe hoặc có nhưng đang bị tước quyền sử dụng Giấy phép lái xe ) vnđ",
        "Sử dụng đèn sai 60.000-80.000 vnđ",
        "Chở người ngồi trên xe sử dụng ô ( dù ) 60.000-80.000 vnđ",
        "Chạy xe dàn hàng ngang 80.000-100.000 vnđ",
        "Điều khiển xe đi không đúng chiều , phần đường , làn đường 300.000-400.000 vnđ",
        "Dừng , đỗ xe trong hầm đường bộ sai quy định 500.000-1.000.000 vnđ",
        "Không chấp hành biển báo , vạch kẻ đường 60.000-80.000 vnđ",
        "Không chấp hành hiệu lệnh đèn giao thông 300.000-400.000 vnđ",
        "Đi vào đường cấm , đi ngược chiều 300.000-400.000 vnđ",
        "Điều khiển xe máy vào cao tốc 500.000-1.000.000 vnđ",
        "Vượt xe trong trường hợp cấm vượt 500.000-1.000.000 vnđ",
        "Dừng , đỗ xe trong hầm đường bộ sai quy định 500.000-1.000.000 vnđ",
        "Chở người quá số lượng quy định 100.000-200.000 vnđ",
        "Người ngồi sau điều khiển xe 100.000-200.000 vnđ",
        "Đang lái xe dùng ô ( dù ) , điện thoại 100.000-200.000 vnđ",
        "Chở ba người trở lên 300.000-400.000 vnđ",
        "Điều khiển xe thành đoàn gây cản trở 300.000-400.000 vnđ",
        "Điều khiển xe liên quan trực tiếp đến tai nạn mà không dừng lại , tham gia cấp cứu 300.000-400.000 vnđ",
        "Bám kéo đẩy xe khác 300.000-400.000 vnđ",
        "Chở hàng vượt trọng tải , thiết kế 300.000-400.000 vnđ",
        "Đi chậm nhưng không đi về bên phải 100.000-200.000 vnđ",
        "Chạy dưới tốc độ tối thiểu 100.000-200.000 vnđ",
        "Chạy quá tốc độ 500.000-1.000.000 vnđ",
        "Điều khiển xe chạy quá tốc độ gây tai nạn 2.000.000-3.000.000 vnđ",
        "Chạy quá tốc độ trên 20 km / h 3.000.000-4.000.000 vnđ",
        "Điều khiển xe thành nhóm chạy quá tốc độ 5.000.000-7.000.000 hoặc 10.000.000 - 14.000.000 ( nếu gây tai nạn ) vnđ",
        "Dừng , đỗ trên phần đường xe chạy 100.000-200.000 vnđ",
        "Dừng , đỗ ở lòng đường đô thị 100.000-200.000 vnđ"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracuu)

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

        listView = findViewById(R.id.listViewTraCuu)
        val adapter: tracuu.MyAdapter = MyAdapter(this, mcontent)
        listView!!.adapter = adapter
    }

    internal inner class MyAdapter(
        context1: Context,
        var rContent: Array<String>
    ) :
        ArrayAdapter<String?>(context1, R.layout.row_tracuu, R.id.textViewTracuu,rContent) {
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            val layoutInflater =
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row_tracuu, parent, false)
            val myContent = row.findViewById<TextView>(R.id.textViewTracuu)
            myContent.text = rContent[position]

            return row
        }
    }
}