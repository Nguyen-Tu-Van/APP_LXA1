package com.example.app_lxa1


import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.app_lxa1.models.Answer
import com.example.app_lxa1.models.Question
import java.util.ArrayList


class thisathach : AppCompatActivity() ,View.OnClickListener{
    private var tvQuestion: TextView? = null
    private var tvContentQuestion: TextView? = null
    private var tvAnswer1: CheckBox? = null
    private var tvAnswer2:CheckBox? = null
    private var tvAnswer3:CheckBox? = null
    private var tvAnswer4:CheckBox? = null
    private var mListQuestion: List<Question>? = null
    private var currentQuetion = 0
    private var mQuetion: Question? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thisathach)
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
        bt_next.setOnClickListener{
            currentQuetion++
            Handler().postDelayed({ setDataQuestion(mListQuestion!![currentQuetion]) }, 1200)
        }
        bt_prev.setOnClickListener{
            currentQuetion--
            Handler().postDelayed({ setDataQuestion(mListQuestion!![currentQuetion]) }, 1200)
        }
    }
    fun time_thi()
    {
        val tv_time = findViewById<TextView>(R.id.textviewTime)
        object : CountDownTimer(620000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val minute = millisUntilFinished/60000
                val second = (millisUntilFinished/1000)%60
                if(second<10 && minute>=10) tv_time.setText(""+minute+":0"+second)
                else if(second>=10 && minute>=10) tv_time.setText(""+minute+":"+second)
                else if(second<10 && minute<10) tv_time.setText("0"+minute+":0"+second)
                else if(second>=10 && minute<10) tv_time.setText("0"+minute+":"+second)
                else tv_time.setText(""+minute+":"+second)
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
            { var intent = Intent(this,MainActivity::class.java)
                startActivity(intent) }
        )
    }
    private fun initUi() {
        tvQuestion = findViewById(R.id.question)
        tvContentQuestion = findViewById(R.id.content_question)
        tvAnswer1 = findViewById(R.id.checkboxA)
        tvAnswer2 = findViewById(R.id.checkboxB)
        tvAnswer3 = findViewById(R.id.checkboxC)
        tvAnswer4 = findViewById(R.id.checkboxD)
    }
    private fun setDataQuestion(question: Question?) {
        //trong thi tra ve
        if (question == null) {
            return
        }
        //khac null thi gan mQuestion
        mQuetion = question
        // reset mau và checked
        tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
        tvAnswer1!!.isChecked = false
        tvAnswer2!!.isChecked = false
        tvAnswer3!!.isChecked = false
        tvAnswer4!!.isChecked = false
        //hien thi du lieu
        val titleQuestion = "Câu " + question.number + "/20"
        tvQuestion!!.text = titleQuestion
        tvContentQuestion!!.text = question.content
        tvAnswer1!!.text = question.getListAnswer()[0].content
        tvAnswer2!!.text = question.getListAnswer()[1].content
        tvAnswer3!!.text = question.getListAnswer()[2].content
        tvAnswer4!!.text = question.getListAnswer()[3].content


        //set su kien
        tvAnswer1!!.setOnClickListener(this)
        tvAnswer2!!.setOnClickListener(this)
        tvAnswer3!!.setOnClickListener(this)
        tvAnswer4!!.setOnClickListener(this)
    }
    private fun getListQuestion(): List<Question>? {
        val list: MutableList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(Answer("Không được vượt.", true))
        answerList1.add(Answer("Được vượt khi đang đi trên cầu.", false))
        answerList1.add(Answer("Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.", false))
        answerList1.add(Answer("Được vượt khi đảm bảo an toàn.", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(Answer("Phải báo hiệu bằng đèn hoặc còi;", false))
        answerList2.add(Answer("Chỉ được báo hiệu bằng còi.", false))
        answerList2.add(Answer("Phải báo hiệu bằng cả còi và đèn.", false))
        answerList2.add(Answer("Chỉ được báo hiệu bằng đèn.", true))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.", false))
        answerList3.add(Answer("Xe bị vượt giảm tốc độ và nhường đường.", false))
        answerList3.add(Answer("Phát hiện có xe đi ngược chiều.", false))
        answerList3.add(Answer("Cả ý 1 và ý 3.", true))
        list.add(Question(1, "Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?", answerList1))
        list.add(Question(2, "Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?", answerList2))
        list.add(Question(3, "Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?", answerList3))
        return list
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.checkboxA -> {
                if(tvAnswer1!!.isChecked == true) tvAnswer1!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                else tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }
            R.id.checkboxB -> {
                if(tvAnswer2!!.isChecked == true) tvAnswer2!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                else tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }
            R.id.checkboxC -> {
                if(tvAnswer3!!.isChecked == true) tvAnswer3!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                else tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }
            R.id.checkboxD -> {
                if(tvAnswer4!!.isChecked == true) tvAnswer4!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                else tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_10)
            }

        }
    }


}