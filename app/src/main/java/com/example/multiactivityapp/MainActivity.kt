package com.example.multiactivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var gofact: Button
    lateinit var gocal: Button
    lateinit var check: Button
    lateinit var textView: TextView
    lateinit var edits: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gofact = findViewById(R.id.nav1)
        gocal = findViewById(R.id.nav2)
        check = findViewById(R.id.checkbutton)
        textView = findViewById(R.id.result)
        edits = findViewById(R.id.edit)

        gofact.setOnClickListener {
            startActivity(Intent(this, Factorial::class.java))
        }

        gocal.setOnClickListener {
            startActivity(Intent(this, Calculator::class.java))
        }

        check.setOnClickListener {

            val numberText = edits.text.toString()

            if (numberText.isNotEmpty()) {

                val num = numberText.toInt()

                if (num % 2 == 0) {
                    textView.text = "Even Number"
                } else {
                    textView.text = "Odd Number"
                }

            } else {
                textView.text = "Enter Number"
            }
        }
    }
}