package com.notifications.todoapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
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

        // on click listener for task add confirmation
        findViewById<Button>(R.id.addTaskConfirmButton).setOnClickListener {
            findViewById<LinearLayout>(R.id.addTaskContainer).visibility = View.GONE

            createNewTask()

            findViewById<EditText>(R.id.taskNameField).hideKeyboard()

            findViewById<EditText>(R.id.taskNameField).setText("")
        }

        // on click listener for deletion of all tasks
        findViewById<Button>(R.id.removeAllTasksButton).setOnClickListener {
            deleteAllTasks()
        }

    }

    // delete all current tasks
    private fun deleteAllTasks(){
        todos.clear()

        populateTaskList()
    }

    // add new task to the list
    private fun createNewTask(){
        var text = findViewById<EditText>(R.id.taskNameField).text.toString()
        todos.add(Todo(text,false))

        populateTaskList()
    }

    // Populate the task list
    private fun populateTaskList(){
        taskList?.removeAllViews()
        todos.forEach { task ->
            run{
                val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val rowView: View = inflater.inflate(R.layout.single_task, null)
                rowView.findViewById<TextView>(R.id.singleTaskName).text = task.getText()
                rowView.findViewById<CheckBox>(R.id.singleTaskIsDone).isChecked = task.getIsDone()
                taskList!!.addView(rowView)
        } }
    }

    // function for hiding keyboard in a single view
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}