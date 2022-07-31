package com.notifications.todoapplication

// simple TODO class
class Todo(private var text: String, private var isDone: Boolean) {

    fun getText() : String{
        return this.text
    }

    fun setText(text : String){
        this.text = text
    }

    fun getIsDone() : Boolean{
        return isDone
    }
}