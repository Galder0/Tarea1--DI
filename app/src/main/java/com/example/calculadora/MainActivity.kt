package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var contador:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 : Button = findViewById<Button>(R.id.ButtonOne)

        val text : TextView = findViewById<TextView>(R.id.textView)


        button1.setOnClickListener {
            contador += 1
            text.text= (contador).toString()
        }


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
            putInt("contador", contador)
        }
// Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
// Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
// Restore state members from saved instance.
        savedInstanceState?.run {
            contador = savedInstanceState.getInt("contador")
        }
    }


}