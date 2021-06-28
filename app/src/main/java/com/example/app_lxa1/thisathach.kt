package com.example.app_lxa1


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.app_lxa1.models.Answer
import com.example.app_lxa1.models.Question


class thisathach : AppCompatActivity() ,View.OnClickListener{
    private var tvQuestion: TextView? = null
    private var tvContentQuestion: TextView? = null
    private var tvAnswer1: RadioButton? = null
    private var tvAnswer2:RadioButton? = null
    private var tvAnswer3:RadioButton? = null
    private var tvAnswer4:RadioButton? = null
    private var btGroup:RadioGroup? = null
    private var mListQuestion: List<Question>? = null
    private var currentQuetion = 0
    private var list: MutableList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thisathach)
        for (i in 0..19) {
            list.add(-1)
        }
        initUi()
        time_thi()
        back_thi()
        mListQuestion = getListQuestion()
        if (mListQuestion!!.isEmpty()) {
            return
        }
        setDataQuestion(mListQuestion!![currentQuetion])
        val bt_prev = findViewById<Button>(R.id.bt_Truoc)
        val bt_next = findViewById<Button>(R.id.bt_Sau)
        val bt_Nop = findViewById<Button>(R.id.bt_NopBai)
        bt_next.setOnClickListener{
            try {
                if(tvAnswer1!!.isChecked==true) list.set(currentQuetion,0)
                else if(tvAnswer2!!.isChecked==true) list.set(currentQuetion,1)
                else if(tvAnswer3!!.isChecked==true) list.set(currentQuetion,2)
                else if(tvAnswer4!!.isChecked==true) list.set(currentQuetion,3)

                if(currentQuetion<19) {
                    currentQuetion++
                    Handler().postDelayed({ setDataQuestion(mListQuestion!![currentQuetion]) }, 250)
                }
                else {
                    currentQuetion=19
                    Toast.makeText(this, "Đây đã là trang cuôi", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
            }
        }
        bt_prev.setOnClickListener{
            try {
                if(tvAnswer1!!.isChecked==true) list.set(currentQuetion,0)
                else if(tvAnswer2!!.isChecked==true) list.set(currentQuetion,1)
                else if(tvAnswer3!!.isChecked==true) list.set(currentQuetion,2)
                else if(tvAnswer4!!.isChecked==true) list.set(currentQuetion,3)

                currentQuetion--
                if(currentQuetion>=0)
                    Handler().postDelayed({ setDataQuestion(mListQuestion!![currentQuetion]) }, 250)
                else{
                    currentQuetion=0
                    Toast.makeText(this, "Đây là trang đầu rồi", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
            }
        }
        bt_Nop.setOnClickListener{
            showDialogSubmit("THời gian làm bài thi vẫn còn . Bạn có chắc chắn muốn nộp bài thi không?")
        }
    }
    fun time_thi()
    {
        val tv_time = findViewById<TextView>(R.id.textviewTime)
        object : CountDownTimer(1200000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val minute = millisUntilFinished/60000
                val second = (millisUntilFinished/1000)%60
                if(second<10 && minute>=10) tv_time.setText(""+minute+":0"+second)
                else if(second>=10 && minute>=10) tv_time.setText(""+minute+":"+second)
                else if(second<10 && minute<10) tv_time.setText("0"+minute+":0"+second)
                else if(second>=10 && minute<10) tv_time.setText("0"+minute+":"+second)
                else tv_time.setText(""+minute+":"+second)

                if(minute<5)
                {
                    tv_time.setTextColor(Color.RED);
                }
                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
                tv_time.setText("done!")
            }
        }.start()
    }
    fun back_thi()
    {
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarThi) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        toolbar.setNavigationOnClickListener(
            View.OnClickListener
            {
                showDialogBack("Bạn có muốn quay lại , bài thi sẽ không được chấm điểm")
            }
        )
    }
    private fun initUi() {
        tvQuestion = findViewById(R.id.question)
        tvContentQuestion = findViewById(R.id.content_question)
        tvAnswer1 = findViewById(R.id.checkboxA)
        tvAnswer2 = findViewById(R.id.checkboxB)
        tvAnswer3 = findViewById(R.id.checkboxC)
        tvAnswer4 = findViewById(R.id.checkboxD)
        btGroup = findViewById(R.id.bt_group)
    }
    private fun setDataQuestion(question: Question?) {
        //trong thi tra ve
        if (question == null) {
            return
        }

        // reset mau và checked, visible
        tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        btGroup!!.clearCheck()
        tvAnswer3!!.visibility=View.VISIBLE
        tvAnswer4!!.visibility=View.VISIBLE
        //Kiem tra neu da chon trong list thi chon
        if(list.get(currentQuetion)==0) {
            tvAnswer1!!.isChecked=true
            tvAnswer1!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }
        if(list.get(currentQuetion)==1){
            tvAnswer2!!.isChecked=true
            tvAnswer2!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }
        if(list.get(currentQuetion)==2){
            tvAnswer3!!.isChecked=true
            tvAnswer3!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }
        if(list.get(currentQuetion)==3){
            tvAnswer4!!.isChecked=true
            tvAnswer4!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }

        //hien thi du lieu
        val titleQuestion = "Câu " + question.number + "/20"
        tvQuestion!!.text = titleQuestion
        tvContentQuestion!!.text = question.content
        tvAnswer1!!.text = question.getListAnswer()[0].content
        tvAnswer2!!.text = question.getListAnswer()[1].content
        tvAnswer3!!.text = question.getListAnswer()[2].content
        tvAnswer4!!.text = question.getListAnswer()[3].content

        //Ẩn nêu nội dung rỗng
        if(question.getListAnswer()[2].content.equals("")) tvAnswer3!!.visibility=View.INVISIBLE
        if(question.getListAnswer()[3].content.equals("")) tvAnswer4!!.visibility=View.INVISIBLE
        //set su kien
        tvAnswer1!!.setOnClickListener(this)
        tvAnswer2!!.setOnClickListener(this)
        tvAnswer3!!.setOnClickListener(this)
        tvAnswer4!!.setOnClickListener(this)
    }
    private fun getListQuestion(): List<Question>? {
        val list: MutableList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(Answer("Phần mặt đường và lề đường.", false))
        answerList1.add(Answer("Phần đường xe chạy..", true))
        answerList1.add(Answer("Phần đường xe cơ giới.", false))
        answerList1.add(Answer("", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(Answer("Phần mặt đường và lề đường.", false))
        answerList2.add(Answer("Phần đường xe chạy..", true))
        answerList2.add(Answer("Phần đường xe cơ giới.", false))
        answerList2.add(Answer("", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Phần mặt đường và lề đường.", false))
        answerList3.add(Answer("Phần đường xe chạy..", true))
        answerList3.add(Answer("Phần đường xe cơ giới.", false))
        answerList3.add(Answer("", false))
        val answerList4: MutableList<Answer> = ArrayList<Answer>()
        answerList4.add(Answer("Được vượt khi đang đi trên cầu.", false))
        answerList4.add(Answer("Không được vượt.", true))
        answerList4.add(Answer("Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.", false))
        answerList4.add(Answer("Được vượt khi đảm bảo an toàn.", false))
        val answerList5: MutableList<Answer> = ArrayList<Answer>()
        answerList5.add(Answer("Phần mặt đường và lề đường.", false))
        answerList5.add(Answer("Phần đường xe chạy..", true))
        answerList5.add(Answer("Phần đường xe cơ giới.", false))
        answerList5.add(Answer("", false))
        val answerList6: MutableList<Answer> = ArrayList<Answer>()
        answerList6.add(Answer("Phần mặt đường và lề đường.", false))
        answerList6.add(Answer("Phần đường xe chạy..", true))
        answerList6.add(Answer("Phần đường xe cơ giới.", false))
        answerList6.add(Answer("", false))
        val answerList7: MutableList<Answer> = ArrayList<Answer>()
        answerList7.add(Answer("Phải báo hiệu bằng đèn hoặc còi;", false))
        answerList7.add(Answer("Chỉ được báo hiệu bằng còi.", false))
        answerList7.add(Answer("Chỉ được báo hiệu bằng đèn.", true))
        answerList7.add(Answer("Phải báo hiệu bằng cả còi và đèn.", false))
        val answerList8: MutableList<Answer> = ArrayList<Answer>()
        answerList8.add(Answer("Phần mặt đường và lề đường.", false))
        answerList8.add(Answer("Phần đường xe chạy..", true))
        answerList8.add(Answer("Phần đường xe cơ giới.", false))
        answerList8.add(Answer("", false))
        val answerList9: MutableList<Answer> = ArrayList<Answer>()
        answerList9.add(Answer("Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.", false))
        answerList9.add(Answer("Xe bị vượt giảm tốc độ và nhường đường.", false))
        answerList9.add(Answer("Phát hiện có xe đi ngược chiều.", false))
        answerList9.add(Answer("Cả ý 1 và ý 3.", true))
        val answerList10: MutableList<Answer> = ArrayList<Answer>()
        answerList10.add(Answer("Phần mặt đường và lề đường.", false))
        answerList10.add(Answer("Phần đường xe chạy..", true))
        answerList10.add(Answer("Phần đường xe cơ giới.", false))
        answerList10.add(Answer("", false))
        val answerList11: MutableList<Answer> = ArrayList<Answer>()
        answerList11.add(Answer("Phần mặt đường và lề đường.", false))
        answerList11.add(Answer("Phần đường xe chạy..", true))
        answerList11.add(Answer("Phần đường xe cơ giới.", false))
        answerList11.add(Answer("", false))
        val answerList12: MutableList<Answer> = ArrayList<Answer>()
        answerList12.add(Answer("Phần mặt đường và lề đường.", false))
        answerList12.add(Answer("Phần đường xe chạy..", true))
        answerList12.add(Answer("Phần đường xe cơ giới.", false))
        answerList12.add(Answer("", false))
        val answerList13: MutableList<Answer> = ArrayList<Answer>()
        answerList13.add(Answer("Phần mặt đường và lề đường.", false))
        answerList13.add(Answer("Phần đường xe chạy..", true))
        answerList13.add(Answer("Phần đường xe cơ giới.", false))
        answerList13.add(Answer("", false))
        val answerList14: MutableList<Answer> = ArrayList<Answer>()
        answerList14.add(Answer("Phần mặt đường và lề đường.", false))
        answerList14.add(Answer("Phần đường xe chạy..", true))
        answerList14.add(Answer("Phần đường xe cơ giới.", false))
        answerList14.add(Answer("", false))
        val answerList15: MutableList<Answer> = ArrayList<Answer>()
        answerList15.add(Answer("Phần mặt đường và lề đường.", false))
        answerList15.add(Answer("Phần đường xe chạy..", true))
        answerList15.add(Answer("Phần đường xe cơ giới.", false))
        answerList15.add(Answer("", false))
        val answerList16: MutableList<Answer> = ArrayList<Answer>()
        answerList16.add(Answer("Phần mặt đường và lề đường.", false))
        answerList16.add(Answer("Phần đường xe chạy..", true))
        answerList16.add(Answer("Phần đường xe cơ giới.", false))
        answerList16.add(Answer("", false))
        val answerList17: MutableList<Answer> = ArrayList<Answer>()
        answerList17.add(Answer("Phần mặt đường và lề đường.", false))
        answerList17.add(Answer("Phần đường xe chạy..", true))
        answerList17.add(Answer("Phần đường xe cơ giới.", false))
        answerList17.add(Answer("", false))
        val answerList18: MutableList<Answer> = ArrayList<Answer>()
        answerList18.add(Answer("Phần mặt đường và lề đường.", false))
        answerList18.add(Answer("Phần đường xe chạy..", true))
        answerList18.add(Answer("Phần đường xe cơ giới.", false))
        answerList18.add(Answer("", false))
        val answerList19: MutableList<Answer> = ArrayList<Answer>()
        answerList19.add(Answer("Phần mặt đường và lề đường.", false))
        answerList19.add(Answer("Phần đường xe chạy..", true))
        answerList19.add(Answer("Phần đường xe cơ giới.", false))
        answerList19.add(Answer("", false))
        val answerList20: MutableList<Answer> = ArrayList<Answer>()
        answerList20.add(Answer("Phần mặt đường và lề đường.", false))
        answerList20.add(Answer("Phần đường xe chạy..", true))
        answerList20.add(Answer("Phần đường xe cơ giới.", false))
        answerList20.add(Answer("", false))


        list.add(Question(1, "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì ?", answerList1))
        list.add(Question(2, "“Phương tiện tham gia giao thông đường bộ” gồm những loại nào ?", answerList2))
        list.add(Question(3, "Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào ?", answerList3))
        list.add(Question(4, "Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?", answerList4))
        list.add(Question(5, "Hành vi sử dụng xe mô tô để kéo, đẩy xe mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không ?", answerList5))
        list.add(Question(6, "Biển báo hiệu hình tròn có nền xanh lam có hình vẽ màu trắng là loại biển gì dưới đây ?", answerList6))
        list.add(Question(7, "Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?", answerList7))
        list.add(Question(8, "Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây ?", answerList8))
        list.add(Question(9, "Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?", answerList9))
        list.add(Question(10, "Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào ?", answerList10))
        list.add(Question(11, "Để báo hiệu cho xe phía trước biết xe mô tô của bạn muốn vượt, bạn phải có tín hiệu như thế nào dưới đây ?", answerList11))
        list.add(Question(12, "Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để đảm bảo an toàn ?", answerList12))
        list.add(Question(13, "Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây ?", answerList13))
        list.add(Question(14, "Biển nào cấm xe rẽ trái ?", answerList14))
        list.add(Question(15, "Biển nào dưới đây các phương tiện không được phép đi vào ?", answerList15))
        list.add(Question(16, "Biển nào xe mô tô hai bánh không được đi vào ?", answerList16))
        list.add(Question(17, "Biển nào báo hiệu nguy hiểm giao nhau với đường sắt ?", answerList17))
        list.add(Question(18, "Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp ?", answerList18))
        list.add(Question(19, "Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ ?", answerList19))
        list.add(Question(20, "Biển nào dưới đây báo hiệu hết cấm vượt ?", answerList20))

        return list
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.checkboxA -> {
                tvAnswer1!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }
            R.id.checkboxB -> {
                tvAnswer2!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }
            R.id.checkboxC -> {
                tvAnswer3!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }
            R.id.checkboxD -> {
                tvAnswer4!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
                tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }

        }
    }

    private fun showDialogBack(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        //dieu khien bam ra ngoai ta dialog
        //neu nhu muon ko
        builder.setCancelable(false) //click ra ben ngoai k tat dialog

        //click nut yes ,xu li ntn
        builder.setNegativeButton("Quay lại") { dialog, which ->
            var intent = Intent(this,dethi::class.java)
            startActivity(intent)
            dialog.dismiss() //tat dialog
        }.setPositiveButton("Tiếp tục thi") { dialog, which ->
            dialog.dismiss() //tat dialog
        }
        //showdialog
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun showDialogSubmit(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        //dieu khien bam ra ngoai ta dialog
        //neu nhu muon ko
        builder.setCancelable(false) //click ra ben ngoai k tat dialog
        //click nut yes ,xu li ntn
        builder.setPositiveButton("Nộp bài thi") { dialog, which ->
            var intent = Intent(this,ketquathi::class.java)
            if(tvAnswer1!!.isChecked==true) list.set(currentQuetion,0)
            else if(tvAnswer2!!.isChecked==true) list.set(currentQuetion,1)
            else if(tvAnswer3!!.isChecked==true) list.set(currentQuetion,2)
            else if(tvAnswer4!!.isChecked==true) list.set(currentQuetion,3)
            var score:Int = 0
            try {
                if (mListQuestion!![0].getListAnswer()[list.get(0)].isCorrect == true) score++
                if (mListQuestion!![1].getListAnswer()[list.get(1)].isCorrect == true) score++
                if (mListQuestion!![2].getListAnswer()[list.get(2)].isCorrect == true) score++
                if (mListQuestion!![3].getListAnswer()[list.get(3)].isCorrect == true) score++
                if (mListQuestion!![4].getListAnswer()[list.get(4)].isCorrect == true) score++
                if (mListQuestion!![5].getListAnswer()[list.get(5)].isCorrect == true) score++
                if (mListQuestion!![6].getListAnswer()[list.get(6)].isCorrect == true) score++
                if (mListQuestion!![7].getListAnswer()[list.get(7)].isCorrect == true) score++
                if (mListQuestion!![8].getListAnswer()[list.get(8)].isCorrect == true) score++
                if (mListQuestion!![9].getListAnswer()[list.get(9)].isCorrect == true) score++
                if (mListQuestion!![10].getListAnswer()[list.get(10)].isCorrect == true) score++
                if (mListQuestion!![11].getListAnswer()[list.get(11)].isCorrect == true) score++
                if (mListQuestion!![12].getListAnswer()[list.get(12)].isCorrect == true) score++
                if (mListQuestion!![13].getListAnswer()[list.get(13)].isCorrect == true) score++
                if (mListQuestion!![14].getListAnswer()[list.get(14)].isCorrect == true) score++
                if (mListQuestion!![15].getListAnswer()[list.get(15)].isCorrect == true) score++
                if (mListQuestion!![16].getListAnswer()[list.get(16)].isCorrect == true) score++
                if (mListQuestion!![17].getListAnswer()[list.get(17)].isCorrect == true) score++
                if (mListQuestion!![18].getListAnswer()[list.get(18)].isCorrect == true) score++
                if (mListQuestion!![19].getListAnswer()[list.get(19)].isCorrect == true) score++
                if (mListQuestion!![20].getListAnswer()[list.get(20)].isCorrect == true) score++

            } catch (e: Exception) {

            }

            intent.putExtra("score",score.toString())
            startActivity(intent)
            dialog.dismiss() //tat dialog
        }.setNegativeButton("Kiểm tra lại") { dialog, which ->
            dialog.dismiss() //tat dialog
        }
        //showdialog
        val alertDialog = builder.create()
        alertDialog.show()
    }


}