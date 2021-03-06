package com.example.app_lxa1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
            {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        )
        val dethi1 = findViewById<Button>(R.id.bt_de1)
        val dethi2 = findViewById<Button>(R.id.bt_de2)
        val dethi3 = findViewById<Button>(R.id.bt_de3)
        val dethi4 = findViewById<Button>(R.id.bt_de4)
        val dethi5 = findViewById<Button>(R.id.bt_de5)
        val dethi6 = findViewById<Button>(R.id.bt_de6)
        val dethi7 = findViewById<Button>(R.id.bt_de7)
        val dethi8 = findViewById<Button>(R.id.bt_de8)

        dethi1.setOnClickListener {
            var intent = Intent(this, thisathach::class.java)
            intent.putExtra("mListQuestion", getListQuestionDaThi1())
            startActivity(intent)
        }
        dethi2.setOnClickListener {
            var intent = Intent(this, thisathach::class.java)
            intent.putExtra("mListQuestion", getListQuestionDaThi2())
            startActivity(intent)
        }
        dethi3.setOnClickListener {
            var intent = Intent(this, thisathach::class.java)
            intent.putExtra("mListQuestion", getListQuestionDaThi3())
            startActivity(intent)
        }
        dethi4.setOnClickListener {
            var intent = Intent(this, thisathach::class.java)
            intent.putExtra("mListQuestion", getListQuestionDaThi4())
            startActivity(intent)
        }
        dethi5.setOnClickListener {
            Toast.makeText(
                this,
                "Đề thi đang được thiết lập.\nVui lòng chọn bộ đề khác",
                Toast.LENGTH_SHORT
            ).show()
        }
        dethi6.setOnClickListener {
            Toast.makeText(
                this,
                "Đề thi đang được thiết lập.\nVui lòng chọn bộ đề khác",
                Toast.LENGTH_SHORT
            ).show()
        }
        dethi7.setOnClickListener {
            Toast.makeText(
                this,
                "Đề thi đang được thiết lập.\nVui lòng chọn bộ đề khác",
                Toast.LENGTH_SHORT
            ).show()
        }
        dethi8.setOnClickListener {
            Toast.makeText(
                this,
                "Đề thi đang được thiết lập.\nVui lòng chọn bộ đề khác",
                Toast.LENGTH_SHORT
            ).show()
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
        answerList2.add(
            Answer(
                "Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.",
                false
            )
        )
        answerList2.add(Answer("Cả ý 1 và ý 2.", true))
        answerList2.add(Answer("", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Chỉ bị nhắc nhở.", false))
        answerList3.add(
            Answer(
                "Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                true
            )
        )
        answerList3.add(Answer("Không bị xử lý hình sự.", false))
        answerList3.add(Answer("", false))
        val answerList4: MutableList<Answer> = ArrayList<Answer>()
        answerList4.add(Answer("Được vượt khi đang đi trên cầu.", false))
        answerList4.add(Answer("Không được vượt.", true))
        answerList4.add(
            Answer(
                "Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.",
                false
            )
        )
        answerList4.add(Answer("Được vượt khi đảm bảo an toàn.", false))
        val answerList5: MutableList<Answer> = ArrayList<Answer>()
        answerList5.add(Answer("Chỉ được kéo nếu đã nhìn thấy trạm xăng.", false))
        answerList5.add(
            Answer(
                "Chỉ được thực hiện trên đường vắng phương tiện cùng tham gia giao thông.",
                false
            )
        )
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
        answerList8.add(
            Answer(
                "Xe cơ giới, xe máy chuyên dùng phải bật đèn; xe thô sơ phải bật đèn hoặc có vật phát sáng báo hiệu; chỉ được dừng xe, đỗ xe ở nơi quy định.",
                true
            )
        )
        answerList8.add(
            Answer(
                " Xe cơ giới phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.",
                false
            )
        )
        answerList8.add(
            Answer(
                "Xe máy chuyên dùng phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.",
                false
            )
        )
        answerList8.add(Answer("", false))
        val answerList9: MutableList<Answer> = ArrayList<Answer>()
        answerList9.add(
            Answer(
                "Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.",
                false
            )
        )
        answerList9.add(Answer("Xe bị vượt giảm tốc độ và nhường đường.", false))
        answerList9.add(Answer("Phát hiện có xe đi ngược chiều.", false))
        answerList9.add(Answer("Cả ý 1 và ý 3.", true))
        val answerList10: MutableList<Answer> = ArrayList<Answer>()
        answerList10.add(
            Answer(
                "Chủ động giữ khoảng cách an toàn phù hợp với xe chạy liền trước xe của mình.",
                false
            )
        )
        answerList10.add(
            Answer(
                "Đảm bảo khoảng cách an toàn theo mật độ phương tiện, tình hình giao thông thực tế.",
                false
            )
        )
        answerList10.add(Answer("Cả ý 1 và ý 2.", true))
        answerList10.add(Answer("", false))
        val answerList11: MutableList<Answer> = ArrayList<Answer>()
        answerList11.add(Answer("Ra tín hiệu bằng tay rồi cho xe vượt qua.", false))
        answerList11.add(Answer("Tăng ga mạnh để gây sự chú ý rồi cho xe vượt qua.", false))
        answerList11.add(Answer("Bạn phải có tín hiệu bằng đèn hoặc còi.", true))
        answerList11.add(Answer("", false))
        val answerList12: MutableList<Answer> = ArrayList<Answer>()
        answerList12.add(
            Answer(
                "Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                true
            )
        )
        answerList12.add(
            Answer(
                "Nhả hết tay ga, tắt động cơ, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                false
            )
        )
        answerList12.add(
            Answer(
                "Sử dụng phanh trước để giảm tốc độ kết hợp với tắt chìa khóa điện của xe.",
                false
            )
        )
        answerList12.add(Answer("", false))
        val answerList13: MutableList<Answer> = ArrayList<Answer>()
        answerList13.add(Answer("Để điều khiển xe chạy về phía trước.", false))
        answerList13.add(
            Answer(
                "Để điều tiết công suất động cơ qua đó điều khiển tốc độ của xe.",
                false
            )
        )
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

        list.add(
            Question(
                1,
                "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì ?",
                answerList1,
                0
            )
        )
        list.add(
            Question(
                2,
                "“Phương tiện tham gia giao thông đường bộ” gồm những loại nào ?",
                answerList2,
                0
            )
        )
        list.add(
            Question(
                3,
                "Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào ?",
                answerList3,
                R.drawable.img1
            )
        )
        list.add(
            Question(
                4,
                "Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?",
                answerList4,
                0
            )
        )
        list.add(
            Question(
                5,
                "Hành vi sử dụng xe mô tô để kéo, đẩy xe mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không ?",
                answerList5,
                R.drawable.img2
            )
        )
        list.add(
            Question(
                6,
                "Biển báo hiệu hình tròn có nền xanh lam có hình vẽ màu trắng là loại biển gì dưới đây?",
                answerList6,
                R.drawable.img3
            )
        )
        list.add(
            Question(
                7,
                "Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?",
                answerList7,
                0
            )
        )
        list.add(
            Question(
                8,
                "Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây ?",
                answerList8,
                0
            )
        )
        list.add(
            Question(
                9,
                "Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?",
                answerList9,
                0
            )
        )
        list.add(
            Question(
                10,
                "Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào ?",
                answerList10,
                0
            )
        )
        list.add(
            Question(
                11,
                "Để báo hiệu cho xe phía trước biết xe mô tô của bạn muốn vượt, bạn phải có tín hiệu như thế nào dưới đây ?",
                answerList11,
                0
            )
        )
        list.add(
            Question(
                12,
                "Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để đảm bảo an toàn ?",
                answerList12,
                R.drawable.img4
            )
        )
        list.add(
            Question(
                13,
                "Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây ?",
                answerList13,
                0
            )
        )
        list.add(Question(14, "Biển nào cấm xe rẽ trái ?", answerList14, R.drawable.img5))
        list.add(
            Question(
                15,
                "Biển nào dưới đây các phương tiện không được phép đi vào ?",
                answerList15,
                R.drawable.img6
            )
        )
        list.add(
            Question(
                16,
                "Biển nào xe mô tô hai bánh không được đi vào ?",
                answerList16,
                R.drawable.img7
            )
        )
        list.add(
            Question(
                17,
                "Biển nào báo hiệu nguy hiểm giao nhau với đường sắt ?",
                answerList17,
                R.drawable.img8
            )
        )
        list.add(
            Question(
                18,
                "Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp ?",
                answerList18,
                R.drawable.img9
            )
        )
        list.add(
            Question(
                19,
                "Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ ?",
                answerList19,
                R.drawable.img10
            )
        )
        list.add(
            Question(
                20,
                "Biển nào dưới đây báo hiệu hết cấm vượt ?",
                answerList20,
                R.drawable.img11
            )
        )

        return list
    }

    private fun getListQuestionDaThi2(): ArrayList<Question>? {
        val list: ArrayList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(
            Answer(
                "Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.",
                false
            )
        )
        answerList1.add(
            Answer(
                "Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",
                true
            )
        )
        answerList1.add(Answer("Là đường cho xe ô tô chạy, dừng, đỗ an toàn.", false))
        answerList1.add(Answer("", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(
            Answer(
                "Người điều khiển, người sử dụng phương tiện tham gia giao thông đường bộ.",
                false
            )
        )
        answerList2.add(
            Answer(
                "Người điều khiển, dẫn dắt súc vật; người đi bộ trên đường bộ.",
                false
            )
        )
        answerList2.add(Answer("Cả ý 1 và ý 2.", true))
        answerList2.add(Answer("", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Người điều khiển: Xe ô tô, xe mô tô, xe đạp, xe gắn máy.", true))
        answerList3.add(Answer("Người ngồi phía sau người điều khiển xe cơ giới.", false))
        answerList3.add(Answer("Người đi bộ.", false))
        answerList3.add(Answer("Cả ý 1 và ý 2.", false))
        val answerList4: MutableList<Answer> = ArrayList<Answer>()
        answerList4.add(Answer("Được phép.", false))
        answerList4.add(
            Answer(
                "Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình.",
                false
            )
        )
        answerList4.add(Answer("Tuỳ trường hợp.", false))
        answerList4.add(Answer("Không được vượt.", true))
        val answerList5: MutableList<Answer> = ArrayList<Answer>()
        answerList5.add(Answer("Không được vận chuyển.", true))
        answerList5.add(Answer("Chỉ được vận chuyển khi đã chằng buộc cẩn thận.", false))
        answerList5.add(
            Answer(
                "Chỉ được vận chuyển vật cồng kềnh trên xe máy nếu khoảng cách về nhà ngắn hơn 2 km.",
                false
            )
        )
        answerList5.add(Answer("", false))
        val answerList6: MutableList<Answer> = ArrayList<Answer>()
        answerList6.add(Answer("Biển báo nguy hiểm.", false))
        answerList6.add(Answer("Biển báo cấm.", false))
        answerList6.add(Answer("Biển báo hiệu lệnh phải thi hành.", false))
        answerList6.add(Answer("Biển báo chỉ dẫn.", true))
        val answerList7: MutableList<Answer> = ArrayList<Answer>()
        answerList7.add(
            Answer(
                "Tăng tốc độ và ra hiệu cho xe sau vượt, không được gây trở ngại cho xe sau vượt.",
                false
            )
        )
        answerList7.add(
            Answer(
                "Người điều khiển phương tiện phía trước phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại cho xe sau vượt.",
                true
            )
        )
        answerList7.add(
            Answer(
                "Cho xe tránh về bên trái mình và ra hiệu cho xe sau vượt; nếu có chướng ngại vật phía trước hoặc thiếu điều kiện an toàn chưa cho vượt được phải ra hiệu cho xe sau biết; cấm gây trở ngại cho xe xin vượt.",
                false
            )
        )
        answerList7.add(Answer("", false))
        val answerList8: MutableList<Answer> = ArrayList<Answer>()
        answerList8.add(Answer("Khi tham gia giao thông đường bộ.", true))
        answerList8.add(Answer("Chỉ khi đi trên đường chuyên dùng; đường cao tốc.", false))
        answerList8.add(Answer("Khi tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ.", false))
        answerList8.add(Answer("", false))
        val answerList9: MutableList<Answer> = ArrayList<Answer>()
        answerList9.add(
            Answer(
                "Nếu đủ điều kiện an toàn, người lái xe phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại đối với xe xin vượt.",
                true
            )
        )
        answerList9.add(
            Answer(
                "Lái xe vào lề đường bên trái và giảm tốc độ để xe phía sau vượt qua, không được gây trở ngại đối với xe xin vượt.",
                false
            )
        )
        answerList9.add(
            Answer(
                "Nếu đủ điều kiện an toàn, người lái xe phải tăng tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua.",
                false
            )
        )
        answerList9.add(Answer("", false))
        val answerList10: MutableList<Answer> = ArrayList<Answer>()
        answerList10.add(Answer("Gặp biển báo nguy hiểm trên đường.", true))
        answerList10.add(Answer("Gặp biển chỉ dẫn trên đường.", false))
        answerList10.add(Answer("Gặp biển báo hết mọi lệnh cấm.", false))
        answerList10.add(Answer("Gặp biển báo hết hạn chế tốc độ tối đa cho phép.", false))
        val answerList11: MutableList<Answer> = ArrayList<Answer>()
        answerList11.add(Answer("Đường ướt, đường có sỏi cát trên nền đường.", false))
        answerList11.add(Answer("Đường hẹp có nhiều điểm giao cắt từ hai phía.", false))
        answerList11.add(Answer("Đường đèo dốc, vòng liên tục.", false))
        answerList11.add(Answer("Tất cả các ý nêu trên.", true))
        val answerList12: MutableList<Answer> = ArrayList<Answer>()
        answerList12.add(
            Answer(
                "Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe cho thích hợp; quay đầu xe với tốc độ thấp; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đầu xe về phía nguy hiểm đưa đuôi xe về phía an toàn.",
                true
            )
        )
        answerList12.add(
            Answer(
                "Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe; quay đầu xe với tốc độ tối đa; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đuôi xe về phía nguy hiểm và đầu xe về phía an toàn.",
                false
            )
        )
        answerList12.add(Answer("", false))
        answerList12.add(Answer("", false))
        val answerList13: MutableList<Answer> = ArrayList<Answer>()
        answerList13.add(Answer("Để quan sát an toàn phía bên trái khi chuẩn bị rẽ trái.", false))
        answerList13.add(Answer("Để quan sát an toàn phía bên phải khi chuẩn bị rẽ phải.", false))
        answerList13.add(
            Answer(
                "Để quan sát an toàn phía sau cả bên trái và bên phải trước khi chuyển hướng.",
                true
            )
        )
        answerList13.add(
            Answer(
                "Để quan sát an toàn phía trước cả bên trái và bên phải trước khi chuyển hướng.",
                false
            )
        )
        val answerList14: MutableList<Answer> = ArrayList<Answer>()
        answerList14.add(Answer("Biển 1.", false))
        answerList14.add(Answer("Biển 2.", false))
        answerList14.add(Answer("Biển 3", true))
        answerList14.add(Answer("", false))
        val answerList15: MutableList<Answer> = ArrayList<Answer>()
        answerList15.add(Answer("Báo hiệu đường có ổ gà, lồi lõm.", false))
        answerList15.add(Answer("Báo hiệu đường có gồ giảm tốc phía trước.", true))
        answerList15.add(Answer("", false))
        answerList15.add(Answer("", false))
        val answerList16: MutableList<Answer> = ArrayList<Answer>()
        answerList16.add(Answer("Biển 1.", false))
        answerList16.add(Answer("Biển 2.", true))
        answerList16.add(Answer("Biển 3.", false))
        answerList16.add(Answer("Cả 3 biển", false))
        val answerList17: MutableList<Answer> = ArrayList<Answer>()
        answerList17.add(Answer("Vạch 1", false))
        answerList17.add(Answer("Vạch 2", false))
        answerList17.add(Answer("Vạch 3", false))
        answerList17.add(Answer("Vạch 1 và 3", true))
        val answerList18: MutableList<Answer> = ArrayList<Answer>()
        answerList18.add(Answer("Xe con và xe khách.", true))
        answerList18.add(Answer("Mô tô", false))
        answerList18.add(Answer("", false))
        answerList18.add(Answer("", false))
        val answerList19: MutableList<Answer> = ArrayList<Answer>()
        answerList19.add(Answer("Xe con", false))
        answerList19.add(Answer("Xe mô tô", true))
        answerList19.add(Answer("", false))
        answerList19.add(Answer("", false))
        val answerList20: MutableList<Answer> = ArrayList<Answer>()
        answerList20.add(Answer("Xe công an, xe quân sự, xe con + mô tô.", false))
        answerList20.add(Answer("Xe quân sự, xe công an, xe con + mô tô.", true))
        answerList20.add(Answer("Xe mô tô + xe con, xe quân sự, xe công an.", false))
        answerList20.add(Answer("", false))

        list.add(Question(1, "“Làn đường” là gì ?", answerList1, 0))
        list.add(
            Question(
                2,
                "“Người tham gia giao thông đường bộ” gồm những đối tượng nào ?",
                answerList2,
                0
            )
        )
        list.add(
            Question(
                3,
                "Theo Luật phòng chống tác hại của rượu, bia, đối tượng nào dưới đây bị cấm sử dụng rượu bia khi tham gia giao thông ?",
                answerList3,
                R.drawable.de2_img3
            )
        )
        list.add(
            Question(
                4,
                "Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không ?",
                answerList4,
                R.drawable.de2_img4
            )
        )
        list.add(
            Question(
                5,
                "Hành vi vận chuyển đồ vật cồng kềnh bằng xe mô tô, xe gắn máy khi tham gia giao thông có được phép hay không ?",
                answerList5,
                R.drawable.de2_img5
            )
        )
        list.add(
            Question(
                6,
                "Biển báo hiệu hình chữ nhật hoặc hình vuông hoặc hình mũi tên nền xanh lam là loại biển gì dưới đây ?",
                answerList6,
                R.drawable.de2_img6
            )
        )
        list.add(
            Question(
                7,
                "Khi điều khiển xe chạy trên đường biết có xe sau xin vượt nếu đủ điều kiện an toàn người lái xe phải làm gì ?",
                answerList7,
                0
            )
        )
        list.add(
            Question(
                8,
                "Người ngồi trên xe mô tô 2 bánh, xe gắn máy phải đội mũ bảo hiểm có cài quai đúng quy cách khi nào ?",
                answerList8,
                R.drawable.de2_img8
            )
        )
        list.add(
            Question(
                9,
                "Người lái xe mô tô xử lý như thế nào khi cho xe mô tô phía sau vượt ?",
                answerList9,
                0
            )
        )
        list.add(
            Question(
                10,
                "Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép đến mức cần thiết, chú ý quan sát và chuẩn bị sẵn sàng những tình huống có thế xảy ra để phòng ngừa tai nạn trong các trường hợp nào dưới đây ?",
                answerList10,
                0
            )
        )
        list.add(
            Question(
                11,
                "Người điều khiển xe mô tô phải giảm tốc độ và hết sức thận trọng khi qua những đoạn đường nào dưới đây ?",
                answerList11,
                0
            )
        )
        list.add(
            Question(
                12,
                "Khi quay đầu xe, người lái xe cần phải quan sát và thực hiện các thao tác nào để đảm bảo an toàn giao thông ?",
                answerList12,
                0
            )
        )
        list.add(
            Question(
                13,
                "Gương chiếu hậu của xe mô tô hai bánh, có tác dụng gì trong các trường hợp dưới đây ?",
                answerList13,
                0
            )
        )
        list.add(
            Question(
                14,
                "Biển nào báo hiệu “Đường đôi” ?",
                answerList14,
                R.drawable.de2_img14
            )
        )
        list.add(Question(15, "Biển báo này có ý nghĩa gì ?", answerList15, R.drawable.de2_img15))
        list.add(
            Question(
                16,
                "Trong các biển dưới đây biển nào là biển “Hết mọi lệnh cấm” ?",
                answerList16,
                R.drawable.de2_img16
            )
        )
        list.add(
            Question(
                17,
                "Vạch kẻ đường nào dưới đây là vạch phân chia hai chiều xe chạy (vạch tim đường) ?",
                answerList17,
                R.drawable.de2_img17
            )
        )
        list.add(
            Question(
                18,
                "Theo tín hiệu đèn, xe nào được phép đi ?",
                answerList18,
                R.drawable.de2_img18
            )
        )
        list.add(
            Question(
                19,
                "Xe nào được quyền đi trước trong trường hợp này ?",
                answerList19,
                R.drawable.de2_img19
            )
        )
        list.add(
            Question(
                20,
                "Trong trường hợp này, thứ tự xe đi như thế nào là đúng quy tắc giao thông ?",
                answerList20,
                R.drawable.de2_img20
            )
        )

        return list
    }

    private fun getListQuestionDaThi3(): ArrayList<Question>? {
        val list: ArrayList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(
            Answer(
                "Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.",
                false
            )
        )
        answerList1.add(
            Answer(
                "Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.",
                false
            )
        )
        answerList1.add(
            Answer(
                "Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.",
                true
            )
        )
        answerList1.add(Answer("", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(Answer("Người điều khiển xe cơ giới, người điều khiển xe thô sơ.", false))
        answerList2.add(
            Answer(
                "Người điều khiển xe máy chuyên dùng tham gia giao thông đường bộ.",
                false
            )
        )
        answerList2.add(Answer("Cả ý 1 và ý 2.", true))
        answerList2.add(Answer("", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Bị nghiêm cấm tuỳ từng trường hợp.", false))
        answerList3.add(Answer("Không bị nghiêm cấm.", false))
        answerList3.add(Answer("Bị nghiêm cấm.", true))
        answerList3.add(Answer("", false))
        val answerList4: MutableList<Answer> = ArrayList<Answer>()
        answerList4.add(Answer("Được phép.", false))
        answerList4.add(Answer("Tuỳ trường hợp.", false))
        answerList4.add(Answer("Không được phép.", true))
        answerList4.add(Answer("", false))
        val answerList5: MutableList<Answer> = ArrayList<Answer>()
        answerList5.add(Answer("16 tuổi.", false))
        answerList5.add(Answer("18 tuổi.", true))
        answerList5.add(Answer("17 tuổi.", false))
        answerList5.add(Answer("", false))
        val answerList6: MutableList<Answer> = ArrayList<Answer>()
        answerList6.add(Answer("02 năm.", false))
        answerList6.add(Answer("03 năm..", false))
        answerList6.add(Answer("04 năm.", true))
        answerList6.add(Answer("05 năm.", false))
        val answerList7: MutableList<Answer> = ArrayList<Answer>()
        answerList7.add(
            Answer(
                "Quan sát gương, ra tín hiệu, quan sát an toàn và chuyển hướng",
                false
            )
        )
        answerList7.add(
            Answer(
                "Quan sát gương, giảm tốc độ, ra tín hiệu chuyển hướng, quan sát an toàn và chuyển hướng.",
                true
            )
        )
        answerList7.add(Answer("Quan sát gương, tăng tốc độ, ra tín hiệu và chuyển hướng.", false))
        answerList7.add(Answer("", false))
        val answerList8: MutableList<Answer> = ArrayList<Answer>()
        answerList8.add(Answer("Chở người bệnh đi cấp cứu; trẻ em dưới 14 tuổi.", false))
        answerList8.add(Answer("Áp giải người có hành vi vi phạm pháp luật.", false))
        answerList8.add(Answer("Cả ý 1 và ý 2.", true))
        answerList8.add(Answer("", false))
        val answerList9: MutableList<Answer> = ArrayList<Answer>()
        answerList9.add(
            Answer(
                "Phải đội mũ bảo hiểm đạt chuẩn, có cài quai đúng quy cách, mặc quần áo gọn gàng; không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính).",
                true
            )
        )
        answerList9.add(
            Answer(
                "Phải đội mũ bảo hiểm khi trời mưa gió hoặc trời quá nắng; có thể sử dụng ô, điện thoại di động, thiết bị âm thanh nhưng phải đảm bảo an toàn.",
                false
            )
        )
        answerList9.add(
            Answer(
                "Phải đội mũ bảo hiểm khi cảm thấy mất an toàn giao thông hoặc khi chuẩn bị di chuyển quãng đường xa.",
                false
            )
        )
        answerList9.add(Answer("", false))
        val answerList10: MutableList<Answer> = ArrayList<Answer>()
        answerList10.add(Answer("Hiệu lệnh của nhân viên gác chắn.", false))
        answerList10.add(Answer("Đèn đỏ sáng nháy, cờ đỏ, biển đỏ.", false))
        answerList10.add(Answer("Còi, chuông kêu, chắn đã đóng", false))
        answerList10.add(Answer("Tất cả các ý trên.", true))
        val answerList11: MutableList<Answer> = ArrayList<Answer>()
        answerList11.add(Answer("Tăng tốc độ để nhanh chóng vượt qua bến đỗ.", false))
        answerList11.add(
            Answer(
                "Giảm tốc độ đến mức an toàn có thể và quan sát người qua đường và từ từ vượt qua xe buýt.",
                true
            )
        )
        answerList11.add(
            Answer(
                "Yêu cầu phải dừng lại phía sau xe buýt chờ xe rời bến mới đi tiếp.",
                false
            )
        )
        answerList11.add(Answer("", false))
        val answerList12: MutableList<Answer> = ArrayList<Answer>()
        answerList12.add(
            Answer(
                "Không nên đi cố vào đường hẹp; xe đi ở sườn núi nên dừng lại trước để nhường đường; khi dừng xe nhường đường phải đỗ ngay ngắn.",
                false
            )
        )
        answerList12.add(
            Answer(
                "Trong khi tránh nhau không nên đổi số; khi tránh nhau ban đêm, phải tắt đèn pha bật đèn cốt.",
                false
            )
        )
        answerList12.add(
            Answer(
                "Khi tránh nhau ban đêm, phải thường xuyên bật đèn pha tắt đèn cốt.",
                false
            )
        )
        answerList12.add(Answer("Cả ý 1 và ý 2.", false))
        val answerList13: MutableList<Answer> = ArrayList<Answer>()
        answerList13.add(Answer("Tăng ga thật nhanh, giảm ga từ từ.", false))
        answerList13.add(Answer("Tăng ga thật nhanh, giảm ga thật nhanh.", false))
        answerList13.add(Answer("Tăng ga từ từ, giảm ga thật nhanh.", true))
        answerList13.add(Answer("Tăng ga từ từ, giảm ga từ từ.", false))
        val answerList14: MutableList<Answer> = ArrayList<Answer>()
        answerList14.add(Answer("Biển 1 và 2.", true))
        answerList14.add(Answer("Biển 1 và 3.", false))
        answerList14.add(Answer("Biển 2 và 3.", false))
        answerList14.add(Answer("Cả ba biển.", false))
        val answerList15: MutableList<Answer> = ArrayList<Answer>()
        answerList15.add(Answer("Biển 1.", true))
        answerList15.add(Answer("Biển 2.", false))
        answerList15.add(Answer("Cả hai biển.", false))
        answerList15.add(Answer("", false))
        val answerList16: MutableList<Answer> = ArrayList<Answer>()
        answerList16.add(Answer("Biển 1.", true))
        answerList16.add(Answer("Biển 2.", false))
        answerList16.add(Answer("Biển 3.", false))
        answerList16.add(Answer("Biển 1 và 3.", false))
        val answerList17: MutableList<Answer> = ArrayList<Answer>()
        answerList17.add(Answer("Biển 1.", true))
        answerList17.add(Answer("Biển 2", false))
        answerList17.add(Answer("Biển 3.", false))
        answerList17.add(Answer("Biển 1 và 3.", false))
        val answerList18: MutableList<Answer> = ArrayList<Answer>()
        answerList18.add(Answer("Biển 1.", false))
        answerList18.add(Answer("Biển 2", false))
        answerList18.add(Answer("Biển 3", true))
        answerList18.add(Answer("", false))
        val answerList19: MutableList<Answer> = ArrayList<Answer>()
        answerList19.add(Answer("Biển 1", false))
        answerList19.add(Answer("Biển 2", false))
        answerList19.add(Answer("Không biển nào.", true))
        answerList19.add(Answer("", false))
        val answerList20: MutableList<Answer> = ArrayList<Answer>()
        answerList20.add(Answer("Biển 1.", true))
        answerList20.add(Answer("Biển 2.", false))
        answerList20.add(Answer("Cả hai biển.", false))
        answerList20.add(Answer("Không biển nào.", false))

        list.add(
            Question(
                1,
                "Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng ?",
                answerList1,
                0
            )
        )
        list.add(
            Question(
                2,
                "Người điều khiển phương tiện tham gia giao thông đường bộ” gồm những đối tượng nào dưới đây ?",
                answerList2,
                0
            )
        )
        list.add(
            Question(
                3,
                "Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không ?",
                answerList3,
                R.drawable.de3_img3
            )
        )
        list.add(
            Question(
                4,
                "Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép hay không ?",
                answerList4,
                R.drawable.de3_img4
            )
        )
        list.add(
            Question(
                5,
                "Người đủ bao nhiêu tuổi trở lên thì được điều khiển xe mô tô hai bánh, xe mô tô ba bánh có dung tích xi lanh từ 50 cm3 trở lên và các loại xe có kết cấu tương tự; xe ô tô tải, máy kéo có trọng tải dưới 3,5 tấn; xe ô tô chở người đến 9 chỗ ngồi",
                answerList5,
                0
            )
        )
        list.add(
            Question(
                6,
                "Khi sử dụng giấy phép lái xe đã khai báo mất để điều khiển phương tiện cơ giới đường bộ, ngoài việc bị thu hồi giấy phép lái xe, chịu trách nhiệm trước pháp luật, người lái xe không được cấp giấy phép lái xe trong thời gian bao nhiêu năm ?",
                answerList6,
                0
            )
        )
        list.add(
            Question(
                7,
                "Khi muốn chuyển hướng, người lái xe phải thực hiện như thế nào để đảm bảo an toàn giao thông ?",
                answerList7,
                0
            )
        )
        list.add(
            Question(
                8,
                "Người điểu khiển xe mô tô hai bánh, xe gắn máy được phép chở tối đa 2 người trong những trường hợp nào ?",
                answerList8,
                0
            )
        )
        list.add(
            Question(
                9,
                "Trong các trường hợp dưới đây, để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô cần thực hiện như thế nào ?",
                answerList9,
                0
            )
        )
        list.add(
            Question(
                10,
                "Các phương tiện tham gia giao thông đường bộ (kể cả những xe có quyền ưu tiên) đều phải dừng lại bên phải đường của mình và trước vạch “dừng xe” tại các điểm giao cắt giữa đường bộ và đường sắt khi có báo hiệu dừng nào dưới đây ?",
                answerList10,
                0
            )
        )
        list.add(
            Question(
                11,
                "Khi gặp xe buýt đang đang dừng đón, trả khách, người điều khiển xe mô tô phải xử lý như thế nào dưới đây để đảm bảo an toàn giao thông ?",
                answerList11,
                0
            )
        )
        list.add(
            Question(
                12,
                "Khi tránh nhau trên đường hẹp, người lái xe cần phải chú ý những điểm nào để đảm bảo an toàn giao thông ?",
                answerList12,
                0
            )
        )
        list.add(
            Question(
                13,
                "Để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô hai bánh cần điều khiển tay ga như thế nào trong các trường hợp dưới đây ?",
                answerList13,
                0
            )
        )
        list.add(
            Question(
                14,
                "Biển nào cấm các phương tiện giao thông đường bộ rẽ phải ?",
                answerList14,
                R.drawable.de3_img14
            )
        )
        list.add(
            Question(
                15,
                "Biển nào cấm tất cả các loại xe cơ giới và thô sơ đi lại trên đường, trừ xe ưu tiên theo luật định (nếu đường vẫn cho xe chạy được) ?",
                answerList15,
                R.drawable.de2_img15
            )
        )
        list.add(
            Question(
                16,
                "Gặp biển nào người lái xe phải nhường đường cho người đi bộ ?",
                answerList16,
                R.drawable.de3_img16
            )
        )
        list.add(
            Question(
                17,
                "Biển nào báo hiệu sắp đến chỗ giao nhau giữa đường bộ và đường sắt ?",
                answerList17,
                R.drawable.de3_img17
            )
        )
        list.add(
            Question(
                18,
                "Biển nào báo hiệu “Đường đôi” ?",
                answerList18,
                R.drawable.de3_img18
            )
        )
        list.add(
            Question(
                19,
                "Biển nào (đặt trước ngã ba, ngã tư) cho phép xe được rẽ sang hướng khác ?",
                answerList19,
                R.drawable.de3_img19
            )
        )
        list.add(
            Question(
                20,
                "Biển nào chỉ dẫn cho người đi bộ sử dụng cầu vượt qua đường ?",
                answerList20,
                R.drawable.de3_img20
            )
        )

        return list
    }

    private fun getListQuestionDaThi4(): ArrayList<Question>? {
        val list: ArrayList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(Answer("Dải phân cách gồm loại cố định và loại di động.", true))
        answerList1.add(
            Answer(
                "Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.",
                false
            )
        )
        answerList1.add(Answer("Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.", false))
        answerList1.add(Answer("", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(
            Answer(
                "Là người điều khiển phương tiện tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                false
            )
        )
        answerList2.add(
            Answer(
                "Là cảnh sát giao thông, người được giao nhiệm vụ hướng dẫn giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                true
            )
        )
        answerList2.add(
            Answer(
                "Là người tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                false
            )
        )
        answerList2.add(Answer("", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Từ 22 giờ đêm đến 5 giờ sáng.", false))
        answerList3.add(Answer("Từ 5 giờ sáng đến 22 giờ tối.", true))
        answerList3.add(Answer("Từ 23 giờ đêm đến 5 giờ sáng hôm sau.", false))
        answerList3.add(Answer("", false))
        val answerList4: MutableList<Answer> = ArrayList<Answer>()
        answerList4.add(
            Answer(
                "Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy.",
                true
            )
        )
        answerList4.add(
            Answer(
                "Buông một tay; sử dụng xe để chở người hoặc hàng hoá; để chân chạm xuống đất khi khởi hành.",
                false
            )
        )
        answerList4.add(
            Answer(
                "Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.",
                false
            )
        )
        answerList4.add(Answer("Chở người ngồi sau dưới 16 tuổi.", false))
        val answerList5: MutableList<Answer> = ArrayList<Answer>()
        answerList5.add(Answer("Xe mô tô 2 bánh có dung tích xi-lanh từ 50 cm3 trở lên.", false))
        answerList5.add(Answer("Xe gắn máy có dung tích xi-lanh dưới 50 cm3.", true))
        answerList5.add(Answer("Xe ô tô tải dưới 3,5 tấn; xe chở người đến 9 chỗ ngồi", false))
        answerList5.add(Answer("Tất cả các ý nêu trên.", false))
        val answerList6: MutableList<Answer> = ArrayList<Answer>()
        answerList6.add(Answer("Người tham gia giao thông ở các hướng phải dừng lại.", false))
        answerList6.add(
            Answer(
                "Người tham gia giao thông ở các hướng được đi theo chiều gậy chỉ của cảnh sát giao thông.",
                false
            )
        )
        answerList6.add(
            Answer(
                "Người tham gia giao thông ở phía trước và phía sau người điều khiển được đi tất cả các hướng; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển phải dừng lại.",
                false
            )
        )
        answerList6.add(
            Answer(
                "Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; người tham giao thông ở phía bên phải và bên trái người điều khiển được đi tất cả các hướng.",
                true
            )
        )
        val answerList7: MutableList<Answer> = ArrayList<Answer>()
        answerList7.add(
            Answer(
                "Nơi đường hẹp chỉ đủ cho một xe chạy và có chỗ tránh xe thì xe nào ở gần chỗ tránh hơn phải vào vị trí tránh, nhường đường cho xe kia đi.",
                false
            )
        )
        answerList7.add(
            Answer(
                "Xe xuống dốc phải nhường đường cho xe đang lên dốc; xe nào có chướng ngại vật phía trước phải nhường đường cho xe không có chướng ngại vật đi trước.",
                false
            )
        )
        answerList7.add(
            Answer(
                "Xe lên dốc phải nhường đường cho xe xuống dốc; xe nào không có chướng ngại vật phía trước phải nhường đường cho xe có chướng ngại vật đi trước.",
                false
            )
        )
        answerList7.add(Answer("Cả ý 1 và ý 2.", true))
        val answerList8: MutableList<Answer> = ArrayList<Answer>()
        answerList8.add(
            Answer(
                "Đi vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính), đi xe dàn hàng ngang.",
                true
            )
        )
        answerList8.add(
            Answer(
                "Chở 02 người; trong đó, có người bệnh đi cấp cứu hoặc trẻ em dưới 14 tuổi hoặc áp giải người có hành vi vi phạm pháp luật.",
                false
            )
        )
        answerList8.add(
            Answer(
                "Điều khiển phương tiện tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ.",
                false
            )
        )
        answerList8.add(Answer("", false))
        val answerList9: MutableList<Answer> = ArrayList<Answer>()
        answerList9.add(
            Answer(
                "Là đoạn đường nằm trong khu công nghiệp có đông người và phương tiện tham gia giao thông và được xác định cụ thể bằng biển chỉ dẫn địa giới.",
                false
            )
        )
        answerList9.add(
            Answer(
                "Là đoạn đường bộ nằm trong khu vực nội thành phố, nội thị xã, nội thị trấn và những đoạn đường có đông dân cư sinh sống sát dọc theo đường, có các hoạt động ảnh hưởng đến an toàn giao thông; được xác định bằng biển báo hiệu là đường khu đông dân cư.",
                true
            )
        )
        answerList9.add(
            Answer(
                "Là đoạn đường nằm ngoài khu vực nội thành phố, nội thị xã có đông người và phương tiện tham gia giao thông và được xác định cụ thể bằng biển chỉ dẫn địa giới.",
                false
            )
        )
        answerList9.add(Answer("", false))
        val answerList10: MutableList<Answer> = ArrayList<Answer>()
        answerList10.add(Answer("Để làm đẹp.", false))
        answerList10.add(Answer("Để tránh mưa nắng.", false))
        answerList10.add(Answer("Để giảm thiểu chấn thương vùng đầu.", true))
        answerList10.add(Answer("Để các loại phương tiện khác dễ quan sát.", false))
        val answerList11: MutableList<Answer> = ArrayList<Answer>()
        answerList11.add(Answer("Biển 1.", false))
        answerList11.add(Answer("Biển 1 và 3.", false))
        answerList11.add(Answer("Biển 3.", true))
        answerList11.add(Answer("Cả ba biển", false))
        val answerList12: MutableList<Answer> = ArrayList<Answer>()
        answerList12.add(Answer("Biển 1 và 2.", false))
        answerList12.add(Answer("Biển 1 và 3.", true))
        answerList12.add(Answer("Biển 2 và 3.", false))
        answerList12.add(Answer("Cả ba biển", false))
        val answerList13: MutableList<Answer> = ArrayList<Answer>()
        answerList13.add(Answer("Biển 1.", true))
        answerList13.add(Answer("Biển 2.", false))
        answerList13.add(Answer("Biển 3.", false))
        answerList13.add(Answer("", false))
        val answerList14: MutableList<Answer> = ArrayList<Answer>()
        answerList14.add(Answer("Biển 1.", true))
        answerList14.add(Answer("Biển 2.", false))
        answerList14.add(Answer("", false))
        answerList14.add(Answer("", false))
        val answerList15: MutableList<Answer> = ArrayList<Answer>()
        answerList15.add(Answer("Biển 1.", false))
        answerList15.add(Answer("Biển 1.", true))
        answerList15.add(Answer("Cả hai biển", false))
        answerList15.add(Answer("Không biển nào cả", false))
        val answerList16: MutableList<Answer> = ArrayList<Answer>()
        answerList16.add(Answer("Vạch 1.", false))
        answerList16.add(Answer("Vạch 2.", false))
        answerList16.add(Answer("Vạch 3.", false))
        answerList16.add(Answer("Vạch 1 và Vạch 3.", true))
        val answerList17: MutableList<Answer> = ArrayList<Answer>()
        answerList17.add(Answer("Xe khách, xe tải, mô tô, xe con.", false))
        answerList17.add(Answer("Xe con, xe khách, xe tải, mô tô.", false))
        answerList17.add(Answer("Mô tô, xe tải, xe khách, xe con.", true))
        answerList17.add(Answer("Mô tô, xe tải, xe con, xe khách.", false))
        val answerList18: MutableList<Answer> = ArrayList<Answer>()
        answerList18.add(Answer("Biển 1.", true))
        answerList18.add(Answer("Biển 2.", false))
        answerList18.add(Answer("Biển 3.", false))
        answerList18.add(Answer("", false))
        val answerList19: MutableList<Answer> = ArrayList<Answer>()
        answerList19.add(Answer("Xe con (B), mô tô (C).", false))
        answerList19.add(Answer("Xe con (A), mô tô (C).", false))
        answerList19.add(Answer("Xe con (E), mô tô (D).", true))
        answerList19.add(Answer("Tất cả các loại xe trên.", false))
        val answerList20: MutableList<Answer> = ArrayList<Answer>()
        answerList20.add(Answer("Xe của bạn, mô tô, xe con.", false))
        answerList20.add(Answer("Xe con, xe của bạn, mô tô.", true))
        answerList20.add(Answer("Mô tô, xe con, xe của bạn.", false))
        answerList20.add(Answer("", false))

        list.add(Question(1, "“Dải phân cách” trên đường bộ gồm những loại nào?", answerList1, 0))
        list.add(
            Question(
                2,
                "Khái niệm “người điều khiển giao thông” được hiểu như thế nào là đúng?",
                answerList2,
                0
            )
        )
        list.add(
            Question(
                3,
                "Khi lái xe trong khu đô thị và đông dân cư trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi như thế nào trong các trường hợp dưới đây?",
                answerList3,
                0
            )
        )
        list.add(
            Question(
                4,
                "Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào không được phép?",
                answerList4,
                0
            )
        )
        list.add(
            Question(
                5,
                "Người đủ 16 tuổi được điều khiển các loại xe nào dưới đây?",
                answerList5,
                0
            )
        )
        list.add(
            Question(
                6,
                "Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?",
                answerList6,
                R.drawable.de4_img6
            )
        )
        list.add(
            Question(
                7,
                "Khi tránh xe đi ngược chiều, các xe phải nhường đường như thế nào là đúng quy tắc giao thông?",
                answerList7,
                0
            )
        )
        list.add(
            Question(
                8,
                "Người điều khiển xe mô tô hai bánh, xe gắn máy không được thực hiện những hành vi nào dưới đây?",
                answerList8,
                0
            )
        )
        list.add(
            Question(
                9,
                "Đường bộ trong khu vực đông dân cư gồm những đoạn đường nào dưới đây?",
                answerList9,
                0
            )
        )
        list.add(
            Question(
                10,
                "Tác dụng của mũ bảo hiểm đối với người ngồi trên xe mô tô hai bánh trong trường hợp xảy ra tai nạn giao thông là gì?",
                answerList10,
                0
            )
        )
        list.add(
            Question(
                11,
                "Biển nào chỉ đường dành cho người đi bộ, các loại xe không được đi vào khi gặp biển này?",
                answerList11,
                R.drawable.de4_img11
            )
        )
        list.add(
            Question(
                12,
                "Biển nào báo hiệu, chỉ dẫn xe đi trên đường này được quyền ưu tiên qua nơi giao nhau?",
                answerList12,
                R.drawable.de4_img12
            )
        )
        list.add(
            Question(
                13,
                "Biển nào báo hiệu “Giao nhau với đường hai chiều”?",
                answerList13,
                R.drawable.de4_img13
            )
        )
        list.add(
            Question(
                14,
                "Biển nào báo hiệu “Hướng đi thẳng phải theo”?",
                answerList14,
                R.drawable.de4_img14
            )
        )
        list.add(
            Question(
                15,
                "Biển nào chỉ dẫn cho người đi bộ sử dụng hầm chui qua đường?",
                answerList15,
                R.drawable.de4_img15
            )
        )
        list.add(
            Question(
                16,
                "Khi gặp vạch kẻ đường nào các xe được phép đè vạch?",
                answerList16,
                R.drawable.de4_img16
            )
        )
        list.add(
            Question(
                17,
                "Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                answerList17,
                R.drawable.de4_img17
            )
        )
        list.add(
            Question(
                18,
                "Xe nào được quyền đi trước trong trường hợp này?",
                answerList18,
                R.drawable.de4_img18
            )
        )
        list.add(
            Question(
                19,
                "Trong hình dưới, những xe nào vi phạm quy tắc giao thông?",
                answerList19,
                R.drawable.de4_img19
            )
        )
        list.add(
            Question(
                20,
                "Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?",
                answerList20,
                R.drawable.de4_img20
            )
        )

        return list;
    }
}