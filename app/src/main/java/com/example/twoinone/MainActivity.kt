package com.example.twoinone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbersGameButtonPressed = findViewById<Button>(R.id.btnNumbersGame)
        numbersGameButtonPressed.setOnClickListener {
            val numbersGameIntent = Intent(this, NumbersGameActivity::class.java)
            startActivity(numbersGameIntent)
        }


        val guessGameButtonPressed = findViewById<Button>(R.id.btnGuessGame)
        guessGameButtonPressed.setOnClickListener {
            val guessGameIntent = Intent(this, GuessGameActivity::class.java)
            startActivity(guessGameIntent)
        }
    }
}