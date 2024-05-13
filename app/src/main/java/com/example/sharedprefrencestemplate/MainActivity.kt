package com.example.sharedprefrencestemplate

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        val editTextInt = findViewById<EditText>(R.id.edit_text_int)
        val editTextString = findViewById<EditText>(R.id.edit_text_string)
        val addButton = findViewById<Button>(R.id.button_add)
        val seeDataButton = findViewById<Button>(R.id.button_see_data)

        addButton.setOnClickListener {
            val intValue = editTextInt.text.toString().toInt()
            val stringValue = editTextString.text.toString()
            saveData(intValue, stringValue)
        }

        seeDataButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun saveData(intValue: Int, stringValue: String) {
        val editor = sharedPreferences.edit()
        editor.putInt("INT_VALUE", intValue)
        editor.putString("STRING_VALUE", stringValue)
        editor.apply()
    }
}