package com.example.app_lxa1.models

import java.io.Serializable


class Question(var number: Int, var content: String, listAnswer: List<Answer>, var image: Int) :Serializable {
    private var listAnswer: List<Answer>
    fun getListAnswer(): List<Answer> {
        return listAnswer
    }

    fun setListAnswer(listAnswer: List<Answer>) {
        this.listAnswer = listAnswer
    }

    init {
        this.listAnswer = listAnswer
    }

}
