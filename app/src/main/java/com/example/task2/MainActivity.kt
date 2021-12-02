package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val mapCollection = mutableMapOf("Somebody" to 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val clickBtn = findViewById<TextView>(R.id.clickBtn)
        val userText = findViewById<TextInputLayout>(R.id.userText)

        clickBtn.setOnClickListener {
            val userName = userText.editText?.text?.toString()
            val maskedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName
            if (mapCollection[maskedUserName] == null) mapCollection[maskedUserName] = 0
            val oldValue = mapCollection[maskedUserName]
            if (oldValue != null) {
                mapCollection[maskedUserName] = oldValue.plus(1)
            }
            val currUserCount = mapCollection[maskedUserName]
            textView.text = "$maskedUserName clicked $currUserCount times"
        }
    }
}