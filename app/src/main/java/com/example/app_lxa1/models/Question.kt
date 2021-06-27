package com.example.app_lxa1.models


class Question(var number: Int, var content: String, listAnswer: List<Answer>) {
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
