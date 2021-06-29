package com.example.app_lxa1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.app_lxa1.models.Question

class xemlaiketqua : AppCompatActivity() {
    private var currentQuetion = 0
    private var tvQuestion: TextView? = null
    private var tvContentQuestion: TextView? = null
    private var tvImage: ImageView? = null
    private var tvAnswer1: RadioButton? = null
    private var tvAnswer2: RadioButton? = null
    private var tvAnswer3: RadioButton? = null
    private var tvAnswer4: RadioButton? = null
    private var btGroup: RadioGroup? = null
    private var list: ArrayList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xemlaiketqua)
        initUi()
        backThi()
        list = getIntent().getIntegerArrayListExtra("list")
        var score = getIntent().getStringExtra("score")
        var tvTime = getIntent().getStringExtra("tvTime")
        var ListQuestion: ArrayList<Question> = ArrayList()
        ListQuestion = getIntent().getSerializableExtra("mListQuestion") as ArrayList<Question>

        var xemlaikq = findViewById<Button>(R.id.bt_viewXemLaiKQ)
        var tTime = findViewById<TextView>(R.id.textviewXemLaiTime)
        xemlaikq.text = "Đúng "+score.toString()+"/20"
        tTime.text = tvTime.toString()

        if (ListQuestion!!.isEmpty()) {
            return
        }
        setDataQuestion(ListQuestion!![currentQuetion])
        val bt_prev = findViewById<Button>(R.id.bt_TruocXemLaiKq)
        val bt_next = findViewById<Button>(R.id.bt_SauXemLaiKq)
        bt_next.setOnClickListener{
            try {
                if(currentQuetion<19) {
                    currentQuetion++
                    Handler().postDelayed({ setDataQuestion(ListQuestion!![currentQuetion]) }, 250)
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
                currentQuetion--
                if(currentQuetion>=0)
                    Handler().postDelayed({ setDataQuestion(ListQuestion!![currentQuetion]) }, 250)
                else{
                    currentQuetion=0
                    Toast.makeText(this, "Đây là trang đầu rồi", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
            }
        }
    }
    private fun initUi() {
        tvQuestion = findViewById(R.id.questionXemLaiKq)
        tvContentQuestion = findViewById(R.id.content_questionXemLaiKq)
        tvImage = findViewById(R.id.image_thisathachXemLaiKq)
        tvAnswer1 = findViewById(R.id.checkboxAXemLaiKq)
        tvAnswer2 = findViewById(R.id.checkboxBXemLaiKq)
        tvAnswer3 = findViewById(R.id.checkboxCXemLaiKq)
        tvAnswer4 = findViewById(R.id.checkboxDXemLaiKq)
        btGroup = findViewById(R.id.bt_groupXemLaiKq)
    }
    private fun backThi()
    {
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarXemKQ) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        toolbar.setNavigationOnClickListener(
            View.OnClickListener
            { var intent = Intent(this,dethi::class.java)
                startActivity(intent) }
        )
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

        //hien thi du lieu
        val titleQuestion = "Câu " + question.number + "/20"
        tvQuestion!!.text = titleQuestion
        tvContentQuestion!!.text = question.content
        if(question.image == 0) tvImage!!.setImageDrawable(getResources().getDrawable(R.drawable.gone))
        else tvImage!!.setImageDrawable(getResources().getDrawable(question.image))
        tvAnswer1!!.text = question.getListAnswer()[0].content
        tvAnswer2!!.text = question.getListAnswer()[1].content
        tvAnswer3!!.text = question.getListAnswer()[2].content
        tvAnswer4!!.text = question.getListAnswer()[3].content

        if(list!!.get(currentQuetion) == 0) tvAnswer1!!.setBackgroundResource(R.drawable.bg_maudo_corner_30)
        else if (list!!.get(currentQuetion) == 1) tvAnswer2!!.setBackgroundResource(R.drawable.bg_maudo_corner_30)
        else if (list!!.get(currentQuetion) == 2) tvAnswer3!!.setBackgroundResource(R.drawable.bg_maudo_corner_30)
        else if (list!!.get(currentQuetion) == 3) tvAnswer4!!.setBackgroundResource(R.drawable.bg_maudo_corner_30)

        if(question.getListAnswer()[0].isCorrect == true) {
            tvAnswer1!!.isChecked=true
            if(list!!.get(currentQuetion) == 0) tvAnswer1!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }
        else if(question.getListAnswer()[1].isCorrect == true){
            tvAnswer2!!.isChecked=true
            if(list!!.get(currentQuetion) == 1) tvAnswer2!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }
        else if(question.getListAnswer()[2].isCorrect == true){
            tvAnswer3!!.isChecked=true
            if(list!!.get(currentQuetion) == 2) tvAnswer3!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }
        else if(question.getListAnswer()[3].isCorrect == true){
            tvAnswer4!!.isChecked=true
            if(list!!.get(currentQuetion) == 3) tvAnswer4!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
        }

        //Ẩn nêu nội dung rỗng
        if(question.getListAnswer()[2].content.equals("")) tvAnswer3!!.visibility=View.INVISIBLE
        if(question.getListAnswer()[3].content.equals("")) tvAnswer4!!.visibility=View.INVISIBLE

        tvAnswer1!!.isClickable = false
        tvAnswer2!!.isClickable = false
        tvAnswer3!!.isClickable = false
        tvAnswer4!!.isClickable = false


    }

}