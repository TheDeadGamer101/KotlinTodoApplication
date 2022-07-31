package com.notifications.todoapplication

// simple TODO class
class Todo(private var text: String, private var isDone: Boolean) {

    fun getText() : String{
        return this.text
    }

    fun getIsDone() : Boolean{
        return isDone
    }

    fun setIsDone(){
        isDone = true
    }

    override fun toString(): String {
        return "[$text,$isDone]"
    }
}