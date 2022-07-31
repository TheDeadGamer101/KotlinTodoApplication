package com.notifications.todoapplication

import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import com.google.gson.Gson

// Locale Storage
class LS {

    // save data
    fun saveData(list : ArrayList<Todo>, context: Context) {
        val prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit()
        val jsonString = Gson().toJson(list)
        prefEditor.putString("todos", jsonString).apply()

        Toast.makeText( context, "Data Saved", Toast.LENGTH_SHORT).show()
    }

    // load data
    fun loadData(context: Context): List<Todo> {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val jsonString = preferences.getString("todos", null)

        Toast.makeText( context, "Data Loaded", Toast.LENGTH_SHORT).show()

        return if (jsonString != null)
            Gson().fromJson(jsonString)
        else
            listOf()
    }
}