package com.example.app_lxa1

import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.app_lxa1.models.Answer
import com.example.app_lxa1.models.Question
import java.io.Serializable


class thisathach : AppCompatActivity() ,View.OnClickListener{
    private var tvQuestion: TextView? = null
    private var tvContentQuestion: TextView? = null
    private var tvImage: ImageView? = null
    private var tvAnswer1: RadioButton? = null
    private var tvAnswer2:RadioButton? = null
    private var tvAnswer3:RadioButton? = null
    private var tvAnswer4:RadioButton? = null
    private var btGroup:RadioGroup? = null
    private var mListQuestion: ArrayList<Question>? = null
    private var currentQuetion = 0
    private var tv_time:TextView? = null
    private var list: ArrayList<Int> = ArrayList()
    private var soundPool: SoundPool? = null
    private var sound1 = 0
    private var sound2 = 0
    private var sound3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thisathach)
        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build()
        } else {
            SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        }
        sound1 = soundPool!!.load(this, R.raw.win, 1)
        sound2 = soundPool!!.load(this, R.raw.loss, 1)
        sound3 = soundPool!!.load(this, R.raw.ping2, 1)
        for (i in 0..19) {
            list.add(-1)
        }
        initUi()
        time_thi()
        back_thi()
        var ListQuestion: ArrayList<Question> = ArrayList()
        ListQuestion = getIntent().getSerializableExtra("mListQuestion") as ArrayList<Question>
        mListQuestion = ListQuestion

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
            showDialogSubmit("Thời gian làm bài thi vẫn còn . Bạn có chắc chắn muốn nộp bài thi không?")
        }
    }
    fun time_thi()
    {
        tv_time =  findViewById(R.id.textviewTime)
        object : CountDownTimer(1200000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minute = millisUntilFinished/60000
                val second = (millisUntilFinished/1000)%60
                if(second<10 && minute>=10) tv_time!!.setText(""+minute+":0"+second)
                else if(second>=10 && minute>=10) tv_time!!.setText(""+minute+":"+second)
                else if(second<10 && minute<10) tv_time!!.setText("0"+minute+":0"+second)
                else if(second>=10 && minute<10) tv_time!!.setText("0"+minute+":"+second)
                else tv_time!!.setText(""+minute+":"+second)

                if(minute<5)
                {
                    tv_time!!.setTextColor(Color.RED);
                }
                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
                tv_time!!.setText("Hết giờ!")
                ketthuc()
            }
        }.start()
    }
    fun ketthuc()
    {
        var intent = Intent(this,ketquathi::class.java)
        if(tvAnswer1!!.isChecked==true) list.set(currentQuetion,0)
        else if(tvAnswer2!!.isChecked==true) list.set(currentQuetion,1)
        else if(tvAnswer3!!.isChecked==true) list.set(currentQuetion,2)
        else if(tvAnswer4!!.isChecked==true) list.set(currentQuetion,3)
        var score:Int = 0
        for(i in 0..19)
        {
            try {
                if (mListQuestion!![i].getListAnswer()[list.get(i)].isCorrect == true) score++
            } catch (e: Exception) {

            }
        }
        if(score>=16) soundPool!!.play(sound1, 1f, 1f, 0, 0, 1f)
        else soundPool!!.play(sound2, 1f, 1f, 0, 0, 1f)
        intent.putExtra("score",score.toString())
        intent.putExtra("tvTime",tv_time!!.text)
        intent.putIntegerArrayListExtra("list",list)
        intent.putExtra("mListQuestion", mListQuestion)

        startActivity(intent)
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
        tvImage = findViewById(R.id.image_thisathach)
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
        if(question.image == 0) tvImage!!.setImageDrawable(getResources().getDrawable(R.drawable.gone))
        else tvImage!!.setImageDrawable(getResources().getDrawable(question.image))
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

            for(i in 0..19)
            {
                try {
                if (mListQuestion!![i].getListAnswer()[list.get(i)].isCorrect == true) score++
                } catch (e: Exception) {

                }
            }
            if(score>=16) soundPool!!.play(sound1, 1f, 1f, 0, 0, 1f)
            else soundPool!!.play(sound2, 1f, 1f, 0, 0, 1f)
            intent.putExtra("score",score.toString())
            intent.putExtra("tvTime",tv_time!!.text)
            intent.putIntegerArrayListExtra("list",list)
            intent.putExtra("mListQuestion", mListQuestion)

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