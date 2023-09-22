package com.example.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var contador:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.ButtonOne).setOnClickListener(this)
        findViewById<Button>(R.id.ButtonTwo).setOnClickListener(this)
        findViewById<Button>(R.id.buttonThree).setOnClickListener(this)
        findViewById<Button>(R.id.buttonFour).setOnClickListener(this)
        findViewById<Button>(R.id.buttonFive).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSix).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSeven).setOnClickListener(this)
        findViewById<Button>(R.id.buttonEight).setOnClickListener(this)
        findViewById<Button>(R.id.buttonNine).setOnClickListener(this)
        findViewById<Button>(R.id.buttonZero).setOnClickListener(this)
        findViewById<Button>(R.id.buttonAC).setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        val textView: TextView = findViewById(R.id.textView)

        when (view?.id) {
            R.id.ButtonOne -> textView.text = textView.text.toString() + getString(R.string.txt_one)
            R.id.ButtonTwo -> textView.text = textView.text.toString() + getString(R.string.txt_two)
            R.id.buttonThree -> textView.text = textView.text.toString() + getString(R.string.txt_three)
            R.id.buttonFour -> textView.text = textView.text.toString() + getString(R.string.txt_four)
            R.id.buttonFive -> textView.text = textView.text.toString() + getString(R.string.txt_five)
            R.id.buttonSix -> textView.text = textView.text.toString() + getString(R.string.txt_six)
            R.id.buttonSeven -> textView.text = textView.text.toString() + getString(R.string.txt_seven)
            R.id.buttonEight -> textView.text = textView.text.toString() + getString(R.string.txt_eight)
            R.id.buttonNine -> textView.text = textView.text.toString() + getString(R.string.txt_nine)
            R.id.buttonZero -> textView.text = textView.text.toString() + getString(R.string.txt_zero)
            R.id.buttonDiv -> textView.text = textView.text.toString() + getString(R.string.txt_divide)
            R.id.buttonMult -> textView.text = textView.text.toString() + getString(R.string.txt_multiply)
            R.id.buttonRes -> textView.text = textView.text.toString() + getString(R.string.txt_substract)
            R.id.buttonSum -> textView.text = textView.text.toString() + getString(R.string.txt_add)
            R.id.buttonAC -> textView.text = ""
        }
        contador = textView.text.toString()
    }

    override fun onResume(){
        super.onResume()
        Log.d("Debug","onResume")
        val text: TextView = findViewById(R.id.textView)
        text.text = contador.toString()
    }
    override fun onSaveInstanceState(outState: Bundle) {
// Save the user's current game state.
        outState?.run {
            putInt("contador", contador.toInt())
        }
// Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
// Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
// Restore state members from saved instance.
        savedInstanceState?.run {
            contador = savedInstanceState.getInt("contador").toString()
        }
    }


}