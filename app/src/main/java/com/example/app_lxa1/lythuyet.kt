package com.example.app_lxa1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class lythuyet : AppCompatActivity() {
    var listView: ListView? = null
    var mquestion = arrayOf(
        "Câu 1",
        "Câu 2",
        "Câu 3",
        "Câu 4",
        "Câu 5",
        "Câu 6",
        "Câu 7",
        "Câu 8",
        "Câu 9",
        "Câu 10",
        "Câu 11",
        "Câu 12",
        "Câu 13",
        "Câu 14",
        "Câu 15",
        "Câu 16",
        "Câu 17",
        "Câu 18",
        "Câu 19",
        "Câu 20",
    )
    var mcontent = arrayOf(
        "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì ?",
        "“Phương tiện tham gia giao thông đường bộ” gồm những loại nào ?",
        "Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào ?",
        "Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không ?",
        "Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm ?",
        "Biển báo hiệu hình tròn có nền xanh lam có hình vẽ màu trắng là loại biển gì dưới đây ?",
        "Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông ?",
        "Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây ?",
        "Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây ?",
        "Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào ?",
        "Để báo hiệu cho xe phía trước biết xe mô tô của bạn muốn vượt, bạn phải có tín hiệu như thế nào dưới đây ?\n",
        "Trong trường hợp đặc biệt, để được lắp đặt, sử dụng còi, đèn không đúng với thiết kế của nhà sản xuất đối với từng loại xe cơ giới bạn phải đảm bảo yêu cầu nào dưới đây?",
        "Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây ?",
        "Biển nào cấm xe rẽ trái ?",
        "Biển nào dưới đây các phương tiện không được phép đi vào ?",
        "Biển nào xe mô tô hai bánh không được đi vào ?",
        "Biển nào báo hiệu nguy hiểm giao nhau với đường sắt ?",
        "Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp ?",
        "Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ ?",
        "Biển nào dưới đây báo hiệu hết cấm vượt ?",


    )
    var manswer = arrayOf(
        "Phần đường xe chạy.",
        "Phương tiện giao thông cơ giới đường bộ & Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.",
        "Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
        " Không được vượt.",
        "Đèn chiếu gần (đèn cốt).",
        "Biển báo hiệu lệnh phải thi hành",
        " Chỉ được báo hiệu bằng đèn",
        " Xe cơ giới, xe máy chuyên dùng phải bật đèn; xe thô sơ phải bật đèn hoặc có vật phát sáng báo hiệu; chỉ được dừng xe, đỗ xe ở nơi quy định.",
        " Cả ý 1 và ý 3.",
        "Cả ý 1 và ý 2.",
        " Bạn phải có tín hiệu bằng đèn hoặc còi.",
        "Phải được chấp thuận của cơ quan có thẩm quyền.",
        "Cả ý 1 và ý 2.",
        "Biển 1.",
        "Biển 1 và 2.",
        "Biển 2.",
        "Biển 1 và 3.",
        "Biển 1.",
        "Biển 2.",
        " Biển 2 và 3.",




    )
    var imglyth = intArrayOf(
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.gone,
        R.drawable.duongcam,
        R.drawable.dinguocchieu,
        R.drawable.camoto,
        R.drawable.camotoretrai,
        R.drawable.lythuyet120
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
        val adapter: lythuyet.MyAdapter = MyAdapter(this, mcontent,mquestion,manswer,imglyth)
        listView!!.adapter = adapter
    }
    internal inner class MyAdapter(
        context1: Context,
        var rContent: Array<String>,
        var rQuestion: Array<String>,
        var rAnswer: Array<String>,
        var rImgs: IntArray
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
            val images = row.findViewById<ImageView>(R.id.imglythuyet)
            images.setImageResource(rImgs[position])
            myContent.text = rContent[position]
            myQuestion.text = rQuestion[position]
            myAnswer.text = rAnswer[position]

            return row
        }
    }
}