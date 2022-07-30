package com.notifications.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    private var todos : ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            findViewById<LinearLayout>(R.id.addTaskContainer).visibility = View.VISIBLE
        }

        findViewById<Button>(R.id.addTaskCancelButton).setOnClickListener {
            findViewById<LinearLayout>(R.id.addTaskContainer).visibility = View.GONE
        }
    }
}