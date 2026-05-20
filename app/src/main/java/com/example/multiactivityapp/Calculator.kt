package com.example.multiactivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {

    lateinit var resultText: TextView

    var input = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        resultText = findViewById(R.id.resultText)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2,
            R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8,
            R.id.btn9, R.id.btnPlus, R.id.btnMinus,
            R.id.btnMultiply, R.id.btnDivide
        )

        for (id in buttons) {

            val btn = findViewById<Button>(id)

            btn.setOnClickListener {
                input += btn.text.toString()
                resultText.text = input
            }
        }

        findViewById<Button>(R.id.btnAC).setOnClickListener {
            input = ""
            resultText.text = ""
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {

            if (input.isNotEmpty()) {
                input = input.dropLast(1)
                resultText.text = input
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {

            try {

                val result = calculate(input)
                resultText.text = result.toString()
                input = result.toString()

            } catch (e: Exception) {
                resultText.text = "Error"
            }
        }

        findViewById<Button>(R.id.nav1).setOnClickListener {
            startActivity(Intent(this, Factorial::class.java))
        }

        findViewById<Button>(R.id.nav2).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun calculate(expression: String): Int {

        return if (expression.contains("+")) {

            val parts = expression.split("+")
            parts[0].toInt() + parts[1].toInt()

        } else if (expression.contains("-")) {

            val parts = expression.split("-")
            parts[0].toInt() - parts[1].toInt()

        } else if (expression.contains("*")) {

            val parts = expression.split("*")
            parts[0].toInt() * parts[1].toInt()

        } else if (expression.contains("/")) {

            val parts = expression.split("/")
            parts[0].toInt() / parts[1].toInt()

        } else {
            expression.toInt()
        }
    }
}