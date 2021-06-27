package com.example.app_lxa1

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.app_lxa1.models.Answer
import com.example.app_lxa1.models.Question
import java.util.*


class thisathach2 : AppCompatActivity() , View.OnClickListener {

    private var tvQuestion: TextView? = null
    private var tvContentQuestion: TextView? = null
    private var tvAnswer1: TextView? = null
    private var tvAnswer2:TextView? = null
    private var tvAnswer3:TextView? = null
    private var tvAnswer4:TextView? = null
    private var mListQuestion: List<Question>? = null
    private var currentQuetion = 0

    private var mQuetion: Question? = null

    //xem cau hoi minh dang chon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thisathach2)
        initUi()

        mListQuestion = getListQuestion()
        if (mListQuestion!!.isEmpty()) {
            return
        }
        setDataQuestion(mListQuestion!![currentQuetion])
    }
    private fun setDataQuestion(question: Question?) {
        //trong thi tra ve
        if (question == null) {
            return
        }
        //khac null thi gan mQuestion
        mQuetion = question

        //reset background khi chuyen trang
        tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)


        //hien thi du lieu
        val titleQuestion = "Question" + question.number
        tvQuestion!!.text = titleQuestion
        tvContentQuestion!!.text = question.content
        tvAnswer1!!.text = question.getListAnswer()[0].content
        tvAnswer2!!.text = question.getListAnswer()[1].content
        tvAnswer3!!.text = question.getListAnswer()[2].content
        tvAnswer4!!.text = question.getListAnswer()[3].content
//        tvAnswer1.setText(question.getListAnswer()[0].getContent())
//        tvAnswer2.setText(question.getListAnswer()[1].getContent())
//        tvAnswer3.setText(question.getListAnswer()[2].getContent())
//        tvAnswer4.setText(question.getListAnswer()[3].getContent())


        //set su kien
        tvAnswer1!!.setOnClickListener(this)
        tvAnswer2!!.setOnClickListener(this)
        tvAnswer3!!.setOnClickListener(this)
        tvAnswer4!!.setOnClickListener(this)
    }


    private fun initUi() {
        tvQuestion = findViewById(R.id.tv_question)
        tvContentQuestion = findViewById(R.id.tv_content_question)
        tvAnswer1 = findViewById(R.id.tv_answer1)
        tvAnswer2 = findViewById(R.id.tv_answer2)
        tvAnswer3 = findViewById(R.id.tv_answer3)
        tvAnswer4 = findViewById(R.id.tv_answer4)
    }
    private fun getListQuestion(): List<Question>? {
        val list: MutableList<Question> = ArrayList()
        val answerList1: MutableList<Answer> = ArrayList<Answer>()
        answerList1.add(Answer("Có", true))
        answerList1.add(Answer("Không", false))
        answerList1.add(Answer("Không", false))
        answerList1.add(Answer("Không", false))
        val answerList2: MutableList<Answer> = ArrayList<Answer>()
        answerList2.add(Answer("Ga", true))
        answerList2.add(Answer("Cho", false))
        answerList2.add(Answer("Meo", false))
        answerList2.add(Answer("Khi", false))
        val answerList3: MutableList<Answer> = ArrayList<Answer>()
        answerList3.add(Answer("Ga", true))
        answerList3.add(Answer("Cho", false))
        answerList3.add(Answer("Meo", false))
        answerList3.add(Answer("Khi", false))
        list.add(Question(1, "Crush có thích Trương không ? ", answerList1))
        list.add(Question(2, "Con nao la gia cầm", answerList2))
        list.add(Question(3, "Con nao la gia cam", answerList3))
        return list
    }

    //xu li su kien trong onClick
    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_answer1 -> {
                tvAnswer1!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                checkAnswer(tvAnswer1!!, mQuetion!!, mQuetion!!.getListAnswer()[0])
            }
            R.id.tv_answer2 -> {
                tvAnswer2!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                checkAnswer(tvAnswer2!!, mQuetion!!, mQuetion!!.getListAnswer()[1])
            }
            R.id.tv_answer3 -> {
                tvAnswer3!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                checkAnswer(tvAnswer3!!, mQuetion!!, mQuetion!!.getListAnswer()[2])
            }
            R.id.tv_answer4 -> {
                tvAnswer4!!.setBackgroundResource(R.drawable.bg_maucam_corner_30)
                checkAnswer(tvAnswer4!!, mQuetion!!, mQuetion!!.getListAnswer()[3])
            }
        }
    }

    //xem cau tra loi dung ko,xd textview cau do hay xanh,dap an cau hoi
    private fun checkAnswer(textView: TextView, question: Question, answer: Answer) {
        //sau 1 s xem kq dung hay sai dung handler
        Handler().postDelayed({
            if (answer.isCorrect) {
                textView.setBackgroundResource(R.drawable.bg_xanhdapan_corner_30)
                //chuyen sang dap an dung
                nextQuestion()
            } else {
                textView.setBackgroundResource(R.drawable.bg_maudo_corner_30)
                //sai thi se hien thi no
                showAnswerCorrect(question)
                gameOVer()
            }
        }, 1200)
    }

    private fun gameOVer() {
        Handler().postDelayed({ showDialog("Ket Thuc") }, 1000)
    }

    //xd dap an dung cau hoi nao
    private fun showAnswerCorrect(question: Question?) {
        //neu question = null
        if (question == null || question.getListAnswer() == null || question.getListAnswer()
                .isEmpty()
        ) {
            return
        }
        //neu dam bao khac null
        //neu dung cau nao thi doi sang mau chinh xac
        if (question.getListAnswer()[0].isCorrect) {
            tvAnswer1!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        } else if (question.getListAnswer()[1].isCorrect) {
            tvAnswer2!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        } else if (question.getListAnswer()[2].isCorrect) {
            tvAnswer3!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        } else if (question.getListAnswer()[3].isCorrect) {
            tvAnswer4!!.setBackgroundResource(R.drawable.bg_xanhnhat_corner_30)
        }
    }

    private fun showDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        //dieu khien bam ra ngoai ta dialog
        //neu nhu muon ko
        builder.setCancelable(false) //click ra ben ngoai k tat dialog

        //click nut yes ,xu li ntn
        builder.setPositiveButton("Yes") { dialog, which ->
            //quay lai cau hoi dau tien
            currentQuetion = 0
            setDataQuestion(mListQuestion!![currentQuetion])
            dialog.dismiss() //tat dialog
        }

        //showdialog
        val alertDialog = builder.create()
        alertDialog.show()
    }

    //chuyen sang cau hoi
    private fun nextQuestion() {
        //neu la cau cuoi cung
        if (currentQuetion == mListQuestion!!.size - 1) {
            showDialog("Succed")
        } // ng lai
        else {
            currentQuetion++
            Handler().postDelayed({ setDataQuestion(mListQuestion!![currentQuetion]) }, 1200)
        }
    }

}
