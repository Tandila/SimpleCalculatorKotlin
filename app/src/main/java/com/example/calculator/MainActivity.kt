package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val empty = "Please enter both numbers"
    private val byZero = "You can't divide by 0 !"

    fun clickedButton(view: View) {
        val symbol = view.tag.toString()
        if(editText1.text.isNotEmpty() && editText2.text.isNotEmpty()) {
           val firstNum = editText1.text.toString().toBigDecimal()
           val secondNum = editText2.text.toString().toBigDecimal()
            if (secondNum.toInt() == 0 && symbol == "/") {
                Toast.makeText(this, byZero, Toast.LENGTH_SHORT).show()
                return
            }
           val res = when(symbol) {
                "-" -> firstNum - secondNum
                "+" -> firstNum + secondNum
                "*" -> firstNum * secondNum
                "/" -> firstNum / secondNum
               else -> return
           }
            val intent = Intent(this, Result::class.java).apply {
                putExtra("Result", editText1.text.toString() + " " + symbol + " " + editText2.text.toString() + " = " + res.toString())
            }
            startActivity(intent)
        }
        else {
            Toast.makeText(this, empty, Toast.LENGTH_SHORT).show()
        }
    }
}