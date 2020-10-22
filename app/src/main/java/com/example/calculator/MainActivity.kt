package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

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
           val firstNum: BigDecimal = editText1.text.toString().toBigDecimal()
           val secondNum: BigDecimal = editText2.text.toString().toBigDecimal()
            if (secondNum.toString() == "0" && symbol == "/") {
                Toast.makeText(this, byZero, Toast.LENGTH_SHORT).show()
                return
            }
           val res: BigDecimal = when(symbol) {
                "-" -> firstNum - secondNum
                "+" -> firstNum + secondNum
                "*" -> firstNum * secondNum
                "/" -> firstNum / secondNum
               else -> return
           }
            val intent: Intent = Intent(this, Result::class.java).apply {
                putExtra("Result", "$firstNum $symbol $secondNum = $res")
            }
            startActivity(intent)
        }
        else {
            Toast.makeText(this, empty, Toast.LENGTH_SHORT).show()
        }
    }
}