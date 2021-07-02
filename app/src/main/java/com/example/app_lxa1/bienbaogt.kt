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
        "Cấm ô tô rẽ trái",
        "Cấm ô tô rẽ phải"
    )
    var mDescription = arrayOf(
        "Báo đường cấm tất cả loại phương tiện(cơ giới và thô sơ)đi lại cả hai hướng,trừ các xe được ưu tiên theo qui định",
        "Báo đường cấm tất cả các loại xe(cơ giới và thô sơ) đi vào theo chiều đặt biển,trừ các xe được ưu tiên theo quy định",
        "Báo đường cấm tất cả loại xe mô giới cả mô tô 3 bánh có thùng đi qua,trừ mô tô 2 bánh,xe gắn máy và các xe được ưu tiên theo qui định",
        "Báo đường cấm tất cả loại xe mô giới cả mô tô 3 bánh có thùng rẽ trái,trừ mô tô 2 bánh,xe gắn máy và các xe được ưu tiên theo qui định",
        "Báo đường cấm tất cả loại xe mô giới cả mô tô 3 bánh có thùng rẽ phải,trừ mô tô 2 bánh,xe gắn máy và các xe được ưu tiên theo qui định"
    )
    var images = intArrayOf(
        R.drawable.duongcam,
        R.drawable.dinguocchieu,
        R.drawable.camoto,
        R.drawable.camotoretrai,
        R.drawable.camotorephai
    )
    var mTitle_BBnguyhiem = arrayOf(
        "Chỗ ngoặt nguy hiểm vòng bên trái",
        "Chỗ ngoặt nguy hiểm vòng bên phải",
        "Nhiều chỗ ngoặt nguy hiểm liên tiếp",
        "Nhiều chỗ ngoặt nguy hiểm liên tiếp",
        "Đường bị hẹp cả hai bên"
    )
    var mDescription_BBnguyhiem = arrayOf(
        "Báo trước sắp đến một chỗ ngoặt nguy hiểm phía bên trái",
        "Báo trước sắp đến một chỗ ngoặt nguy hiểm phía bên phải",
        "Báo trước sắp đến nhiều chỗ ngoặt nguy hiểm liên tiếp trong đó chỗ ngoặt đầu tiên hướng vòng bên trái",
        "Báo trước sắp đến nhiều chỗ ngoặt nguy hiểm liên tiếp trong đó chỗ ngoặt đầu tiên hướng vòng bên phải",
        "Báo trước sắp đến một đoạn đường bị hẹp đột ngột cả hai bên"
    )
    var images_BBnguyhiem = intArrayOf(
        R.drawable.nh_trai,
        R.drawable.nh_phai,
        R.drawable.nh_ngnh_trai,
        R.drawable.nh_ngnh_phai,
        R.drawable.nh_hephb


    )

    var mTitle_BBhieulenh = arrayOf(
        "Hướng đi phải theo",
        "Hướng đi phải theo",
        "Hướng đi phải theo",
        "Hướng đi phải theo",
        "Hướng đi phải theo"
    )
    var mDescription_BBhieulenh = arrayOf(
        "Các xe chỉ được đi thẳng (trừ xe được quyền ưu tiên theo quy định)",
        "Các xe chỉ được rẽ trái (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở sau nơi đường giao nhau",
        "Các xe chỉ được rẽ phải (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở sau nơi đường giao nhau",
        "Các xe chỉ được rẽ trái (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở trước nơi đường giao nhau, có tác dụng tại nơi giao nhau đằng sau mặt biển",
        "Hướng đi phải theo Các xe chỉ được rẽ phải (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở trước nơi đường giao nhau, có tác dụng tại nơi giao nhau đằng sau mặt biển"
    )
    var images_BBhieulenh = intArrayOf(
        R.drawable.hl_dithang,
        R.drawable.hl_retrai,
        R.drawable.hl_rephai,
        R.drawable.hl_retrai1,
        R.drawable.hl_rephai1
    )

    var mTitle_BBchidan = arrayOf(
        "Bắt đầu đường ưu tiên",
        "Hết đoạn đường ưu tiên",
        "Đường dành cho ô tô",
        "Hết đường dành cho ô tô",
        "Đường dành cho ô tô, xe máy",
        "Hết đường dành cho ô tô, xe máy"
    )
    var mDescription_BBchidan = arrayOf(
        "Để biểu thị ưu tiên cho các phương tiện trên đường có đặt biển này được đi trước. Biển đặt tại vị trí thích hợp trước khi đường nhánh sắp nhập vào trục đường chính",
        "Báo hiệu hết đoạn đường được ưu tiên",
        "Để chỉ dẫn bắt đầu đường dành cho các loại ôtô đi lại, các loại phương tiện giao thông khác không được phép đi vào đoạn đường có dặt biển này",
        "Để chỉ dẫn hết đoạn đường dành cho ô tô đi lại",
        "Để chỉ dẫn bắt đầu đường dành cho các loại ôtô, xe máy (kể cả xe gắn máy) đi lại, các loại phương tiện giao thông khác không được phép đi vào đoạn đường có đặt biển này",
        "Để chỉ dẫn hết đoạn đường dành cho ôtô, xe máy đi lại"
    )
    var images_BBchidan = intArrayOf(
        R.drawable.cd_bdddut,
        R.drawable.cd_hddut,
        R.drawable.cd_ddot,
        R.drawable.cd_hdot,
        R.drawable.cd_dotxm,
        R.drawable.cd_hdotxm
    )

    var mTitle_BBbbphu = arrayOf(
        "Biển phụ chỉ phạm vi hiệu lực của biển",
        "Biển phụ khoảng cách đến nơi được cảnh báo) ",
        "Biển phụ chỉ hiệu lực của biển là ở làn đường nào",
        "Biển phụ 505a (chỉ loại xe chịu hiệu lực của biển chính)",
        "Biển phụ 505b (chỉ loại xe bị hạn chế qua cầu) "
    )
    var mDescription_BBphu = arrayOf(
        "Để thông báo chiều dài đoạn đường nguy hiểm hoặc cấm hoặc hạn chế bên dưới một số biển báo nguy hiểm, biển báo cấm hoặc hạn chế, chẳng hạn như: Nhiều chỗ ngoặt nguy hiểm liên\n" +
                "tiếp; Dốc xuống nguy hiểm...",
        "Khoảng cách đến đối tượng báo hiệu Bên dưới các loại biển báo nguy hiểm, biển báo cấm biển hiệu lệnh và chỉ dẫn, thông báo khoảng cách thực tế từ vị trí đặt biển đến đối tượng báo hiệu ở phía trước",
        "Biển phụ 504 thường được đặt phía trên làn đường được quy định để lái xe có thể biết được biển chính có hiệu lực đối với làn đường nào.",
        "Biển này thường đặt dưới biển báo cấm và biển hiệu lệnh dùng để chỉ biển chính có tác dụng với loại xe nào, hình vẽ có thể khác nhau tùy theo loại xe.",
        "Biển này thường đi kèm với biển cấm xe tải 106a dùng để chỉ loại xe bị hạn chế qua cầu và trọng lượng tối đa của xe tải khi qua cầu, biển này không giới hạn số lượng trục xe."
    )
    var images_BBphu = intArrayOf(
        R.drawable.bbp_pvhlcb,
        R.drawable.bbp_kcdndcb,
        R.drawable.bbp_chlcb,
        R.drawable.bbp_chlcbc,
        R.drawable.bbp_clxbhcqc


    )

    var mTitle_vcd = arrayOf(
        "Vạch số 1.1",
        "Vạch số 1.2",
        "Vạch số 1.3",
        "Vạch số 1.4",

    )
    var mDescription_vcd = arrayOf(
        "Vạch liền nét màu trắng, rộng 10cm, Phân chia 2 dòng phương tiện giao thông đi ngược chiều nhau, xe không được đè lên vạch",
        "Vạch liền nét màu trắng, rộng 20cm, Xác định mép phần xe cơ giới với phần xe thô sơ, người đi bộ hoặc lề đường trên các trục đường, xe chạy được phép đè lên vạch khi cần thiết",
        "Hai vạch liên tục màu trắng (vạch kép) có chiều rộng bằng nhau và bằng 10cm cách nhau là 10cm tính từ 2 mép vạch kề nhau, phân chia 2 dòng phương tiện giao thông đi ngược chiều nhau trên những đường có từ 4 làn xe trở lên, xe không được đè lên vạch",
        "Vạch liên tục màu vàng có chiều rộng 10cm, xác định nơi cấm dừng và cấm đỗ xe, áp dụng độc lập hoặc có thể kết hợp với biển báo cấm số 130 \"Cấm dừng xe và đỗ xe\" và kẻ ở mép đường hay ở trên hàng vỉa nơi có vỉa hè.\n"


    )
    var images_vcd = intArrayOf(
        R.drawable.vkd_1,
        R.drawable.vkd_2,
        R.drawable.vkd_3,
        R.drawable.vkd_4
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
            adapter = MyAdapter(this, mTitle_BBnguyhiem , mDescription_BBnguyhiem , images_BBnguyhiem )
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo nguy hiểm", Toast.LENGTH_SHORT).show()
        }
        bt_hieulenh.setOnClickListener {
            adapter = MyAdapter(this, mTitle_BBhieulenh, mDescription_BBhieulenh, images_BBhieulenh)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo hiệu lệnh", Toast.LENGTH_SHORT).show()
        }
        bt_chidan.setOnClickListener {
            adapter = MyAdapter(this, mTitle_BBchidan, mDescription_BBchidan, images_BBchidan)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển bảo chỉ dẫn", Toast.LENGTH_SHORT).show()
        }
        bt_phu.setOnClickListener {
            adapter = MyAdapter(this, mTitle_BBbbphu, mDescription_BBphu, images_BBphu)
            listView!!.adapter = adapter
            Toast.makeText(this, "Biển báo phụ", Toast.LENGTH_SHORT).show()
        }
        bt_vachke.setOnClickListener {
            adapter = MyAdapter(this, mTitle_vcd, mDescription_vcd, images_vcd)
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