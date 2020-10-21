package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun plus(view: View) {
        if(editText1.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            val result = editText1.text.toString().toInt() + editText2.text.toString().toInt()
            val intent = Intent(this, Result::class.java).apply {
                putExtra("Result", editText1.text.toString()+ "+" + editText2.text.toString() + "=" + result.toString())
            }
            startActivity(intent)
        }
        else {
            val intent = Intent(this, Result::class.java)
            intent.putExtra("Result", "isEmpty!")
            startActivity(intent)
        }
    }

    fun minus(view: View) {
        if(editText1.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            val result = editText1.text.toString().toInt() - editText2.text.toString().toInt()
            val intent = Intent(this, Result::class.java).apply {
                putExtra("Result", editText1.text.toString()+ "-" + editText2.text.toString() + "=" + result.toString())
            }
            startActivity(intent)
        }
        else {
            val intent = Intent(this, Result::class.java)
            intent.putExtra("Result", "isEmpty!")
            startActivity(intent)
        }
    }
    fun multiply(view: View) {
        if(editText1.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            val result = editText1.text.toString().toInt() * editText2.text.toString().toInt()
            val intent = Intent(this, Result::class.java).apply {
                putExtra("Result", editText1.text.toString()+ "*" + editText2.text.toString() + "=" + result.toString())
            }
            startActivity(intent)
        }
        else {
            val intent = Intent(this, Result::class.java)
            intent.putExtra("Result", "isEmpty!")
            startActivity(intent)
        }
    }
    fun divide(view: View) {
        if(editText1.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            if (editText2.text.toString().toInt() == 0) {
                val intent = Intent(this, Result::class.java).apply {
                    putExtra("Result", "You cant divide by 0 !")
                }
                startActivity(intent)
                return
            }
            val result = editText1.text.toString().toInt() / editText2.text.toString().toInt()
            val intent = Intent(this, Result::class.java).apply {
                putExtra("Result", editText1.text.toString()+ "/" + editText2.text.toString() + "=" + result.toString())
            }
            startActivity(intent)
        }
        else {
            val intent = Intent(this, Result::class.java)
            intent.putExtra("Result", "isEmpty!")
            startActivity(intent)
        }
    }
}