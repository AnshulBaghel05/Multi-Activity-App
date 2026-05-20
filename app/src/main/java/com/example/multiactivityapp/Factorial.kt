package com.example.multiactivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Factorial : AppCompatActivity() {

    lateinit var edit: EditText
    lateinit var result: TextView
    lateinit var factorialBtn: Button
    lateinit var nav1: Button
    lateinit var nav2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.factorial)

        edit = findViewById(R.id.editFactorial)
        result = findViewById(R.id.factorialResult)
        factorialBtn = findViewById(R.id.btnFactorial)

        nav1 = findViewById(R.id.nav1)
        nav2 = findViewById(R.id.nav2)

        nav1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        nav2.setOnClickListener {
            startActivity(Intent(this, Calculator::class.java))
        }

        factorialBtn.setOnClickListener {

            val text = edit.text.toString()

            if (text.isNotEmpty()) {

                val num = text.toInt()

                var fact = 1L

                for (i in 1..num) {
                    fact *= i
                }

                result.text = "Factorial = $fact"

            } else {
                result.text = "Enter Number"
            }
        }
    }
}