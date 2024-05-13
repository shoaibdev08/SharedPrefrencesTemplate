package com.example.sharedprefrencestemplate

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        val textViewData = findViewById<TextView>(R.id.text_view_data)
        val intValue = sharedPreferences.getInt("INT_VALUE", 0)
        val stringValue = sharedPreferences.getString("STRING_VALUE", "")

        textViewData.text = "Int Value: $intValue\nString Value: $stringValue"
    }
}