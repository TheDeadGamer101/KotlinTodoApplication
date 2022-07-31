package com.notifications.todoapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // private list variables
    private var todos : ArrayList<Todo> = ArrayList()
    private var taskList: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the taskList to add the tasks to
        taskList = findViewById(R.id.todoList)

        // placeholder tasks for preview
        todos.add(Todo("test",false))
        todos.add(Todo("lel",true))
        todos.add(Todo("lel",true))
        todos.add(Todo("lel",true))

        populateTaskList()

        // on click listener for the button to show the task add window
        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            findViewById<LinearLayout>(R.id.addTaskContainer).visibility = View.VISIBLE
        }

        // on click listener for the canceling of the task add window
        findViewById<Button>(R.id.addTaskCancelButton).setOnClickListener {
            findViewById<LinearLayout>(R.id.addTaskContainer).visibility = View.GONE
        }


    }

    // Populate the task list
    private fun populateTaskList(){
        todos.forEach { task ->
            run{
                val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val rowView: View = inflater.inflate(R.layout.single_task, null)
                taskList!!.addView(rowView)
        } }
    }
}