package com.example.app_lxa1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import com.example.app_lxa1.models.Answer
import com.example.app_lxa1.models.Question

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
            intent.putExtra("mListQuestion", getListQuestionDaThi1())
            startActivity(intent)
        }
        dethi2.setOnClickListener{
//            var intent = Intent(this,thisathach::class.java)
//            startActivity(intent)
        }
    }

    private fun getListQuestionDaThi1(): ArrayList<Question>? {
        val list: ArrayList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(Answer("Phần mặt đường và lề đường.", false))
        answerList1.add(Answer("Phần đường xe chạy.", true))
        answerList1.add(Answer("Phần đường xe cơ giới.", false))
        answerList1.add(Answer("", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(Answer("Phương tiện giao thông cơ giới đường bộ.", false))
        answerList2.add(Answer("Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.", false))
        answerList2.add(Answer("Cả ý 1 và ý 2.", true))
        answerList2.add(Answer("", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Chỉ bị nhắc nhở.", false))
        answerList3.add(Answer("Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.", true))
        answerList3.add(Answer("Không bị xử lý hình sự.", false))
        answerList3.add(Answer("", false))
        val answerList4: MutableList<Answer> = ArrayList<Answer>()
        answerList4.add(Answer("Được vượt khi đang đi trên cầu.", false))
        answerList4.add(Answer("Không được vượt.", true))
        answerList4.add(Answer("Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.", false))
        answerList4.add(Answer("Được vượt khi đảm bảo an toàn.", false))
        val answerList5: MutableList<Answer> = ArrayList<Answer>()
        answerList5.add(Answer("Chỉ được kéo nếu đã nhìn thấy trạm xăng.", false))
        answerList5.add(Answer("Chỉ được thực hiện trên đường vắng phương tiện cùng tham gia giao thông.", false))
        answerList5.add(Answer("Không được phép.", true))
        answerList5.add(Answer("", false))
        val answerList6: MutableList<Answer> = ArrayList<Answer>()
        answerList6.add(Answer("Biển báo nguy hiểm.", false))
        answerList6.add(Answer("Biển báo cấm.", false))
        answerList6.add(Answer("Biển báo hiệu lệnh phải thi hành.", true))
        answerList6.add(Answer("Biển báo chỉ dẫn.", false))
        val answerList7: MutableList<Answer> = ArrayList<Answer>()
        answerList7.add(Answer("Phải báo hiệu bằng đèn hoặc còi;", false))
        answerList7.add(Answer("Chỉ được báo hiệu bằng còi.", false))
        answerList7.add(Answer("Chỉ được báo hiệu bằng đèn.", true))
        answerList7.add(Answer("Phải báo hiệu bằng cả còi và đèn.", false))
        val answerList8: MutableList<Answer> = ArrayList<Answer>()
        answerList8.add(Answer("Xe cơ giới, xe máy chuyên dùng phải bật đèn; xe thô sơ phải bật đèn hoặc có vật phát sáng báo hiệu; chỉ được dừng xe, đỗ xe ở nơi quy định.", true))
        answerList8.add(Answer(" Xe cơ giới phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.", false))
        answerList8.add(Answer("Xe máy chuyên dùng phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.", false))
        answerList8.add(Answer("", false))
        val answerList9: MutableList<Answer> = ArrayList<Answer>()
        answerList9.add(Answer("Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.", false))
        answerList9.add(Answer("Xe bị vượt giảm tốc độ và nhường đường.", false))
        answerList9.add(Answer("Phát hiện có xe đi ngược chiều.", false))
        answerList9.add(Answer("Cả ý 1 và ý 3.", true))
        val answerList10: MutableList<Answer> = ArrayList<Answer>()
        answerList10.add(Answer("Chủ động giữ khoảng cách an toàn phù hợp với xe chạy liền trước xe của mình.", false))
        answerList10.add(Answer("Đảm bảo khoảng cách an toàn theo mật độ phương tiện, tình hình giao thông thực tế.", false))
        answerList10.add(Answer("Cả ý 1 và ý 2.", true))
        answerList10.add(Answer("", false))
        val answerList11: MutableList<Answer> = ArrayList<Answer>()
        answerList11.add(Answer("Ra tín hiệu bằng tay rồi cho xe vượt qua.", false))
        answerList11.add(Answer("Tăng ga mạnh để gây sự chú ý rồi cho xe vượt qua.", false))
        answerList11.add(Answer("Bạn phải có tín hiệu bằng đèn hoặc còi.", true))
        answerList11.add(Answer("", false))
        val answerList12: MutableList<Answer> = ArrayList<Answer>()
        answerList12.add(Answer("Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.", true))
        answerList12.add(Answer("Nhả hết tay ga, tắt động cơ, sử dụng phanh trước và phanh sau để giảm tốc độ.", false))
        answerList12.add(Answer("Sử dụng phanh trước để giảm tốc độ kết hợp với tắt chìa khóa điện của xe.", false))
        answerList12.add(Answer("", false))
        val answerList13: MutableList<Answer> = ArrayList<Answer>()
        answerList13.add(Answer("Để điều khiển xe chạy về phía trước.", false))
        answerList13.add(Answer("Để điều tiết công suất động cơ qua đó điều khiển tốc độ của xe.", false))
        answerList13.add(Answer("Để điều khiển xe chạy lùi.", false))
        answerList13.add(Answer("Cả ý 1 và ý 2.", true))
        val answerList14: MutableList<Answer> = ArrayList<Answer>()
        answerList14.add(Answer("Biển 1.", true))
        answerList14.add(Answer("Biển 2.", false))
        answerList14.add(Answer("Cả hai biển.", false))
        answerList14.add(Answer("", false))
        val answerList15: MutableList<Answer> = ArrayList<Answer>()
        answerList15.add(Answer("Biển 1.", false))
        answerList15.add(Answer("Biển 2.", false))
        answerList15.add(Answer("Biển 1 và 2.", true))
        answerList15.add(Answer("", false))
        val answerList16: MutableList<Answer> = ArrayList<Answer>()
        answerList16.add(Answer("Biển 1.", false))
        answerList16.add(Answer("Biển 2.", true))
        answerList16.add(Answer("Biển 3.", false))
        answerList16.add(Answer("", false))
        val answerList17: MutableList<Answer> = ArrayList<Answer>()
        answerList17.add(Answer("Biển 1 và 2.", false))
        answerList17.add(Answer("Biển 1 và 3.", true))
        answerList17.add(Answer("Biển 2 và 3.", false))
        answerList17.add(Answer("Cả ba biển.", false))
        val answerList18: MutableList<Answer> = ArrayList<Answer>()
        answerList18.add(Answer("Biển 1.", true))
        answerList18.add(Answer("Biển 2.", false))
        answerList18.add(Answer("Biển 3.", false))
        answerList18.add(Answer("", false))
        val answerList19: MutableList<Answer> = ArrayList<Answer>()
        answerList19.add(Answer("Biển 1.", false))
        answerList19.add(Answer("Biển 2.", true))
        answerList19.add(Answer("Biển 3.", false))
        answerList19.add(Answer("", false))
        val answerList20: MutableList<Answer> = ArrayList<Answer>()
        answerList20.add(Answer("Biển 1.", false))
        answerList20.add(Answer("Biển 2.", false))
        answerList20.add(Answer("Biển 3.", false))
        answerList20.add(Answer("Biển 2 và 3.", true))

        list.add(Question(1, "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì ?", answerList1,0))
        list.add(Question(2, "“Phương tiện tham gia giao thông đường bộ” gồm những loại nào ?", answerList2,0))
        list.add(Question(3, "Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào ?", answerList3,R.drawable.img1))
        list.add(Question(4, "Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?", answerList4,0))
        list.add(Question(5, "Hành vi sử dụng xe mô tô để kéo, đẩy xe mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không ?", answerList5,R.drawable.img2))
        list.add(Question(6, "Biển báo hiệu hình tròn có nền xanh lam có hình vẽ màu trắng là loại biển gì dưới đây?", answerList6,R.drawable.img3))
        list.add(Question(7, "Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?", answerList7,0))
        list.add(Question(8, "Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây ?", answerList8,0))
        list.add(Question(9, "Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?", answerList9,0))
        list.add(Question(10, "Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào ?", answerList10,0))
        list.add(Question(11, "Để báo hiệu cho xe phía trước biết xe mô tô của bạn muốn vượt, bạn phải có tín hiệu như thế nào dưới đây ?", answerList11,0))
        list.add(Question(12, "Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để đảm bảo an toàn ?", answerList12,R.drawable.img4))
        list.add(Question(13, "Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây ?", answerList13,0))
        list.add(Question(14, "Biển nào cấm xe rẽ trái ?", answerList14,R.drawable.img5))
        list.add(Question(15, "Biển nào dưới đây các phương tiện không được phép đi vào ?", answerList15,R.drawable.img6))
        list.add(Question(16, "Biển nào xe mô tô hai bánh không được đi vào ?", answerList16,R.drawable.img7))
        list.add(Question(17, "Biển nào báo hiệu nguy hiểm giao nhau với đường sắt ?", answerList17,R.drawable.img8))
        list.add(Question(18, "Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp ?", answerList18,R.drawable.img9))
        list.add(Question(19, "Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ ?", answerList19,R.drawable.img10))
        list.add(Question(20, "Biển nào dưới đây báo hiệu hết cấm vượt ?", answerList20,R.drawable.img11))

        return list
    }
}