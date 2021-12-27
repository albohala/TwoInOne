package com.example.twoinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_numbers_game.*
import kotlin.random.Random

class NumbersGameActivity : AppCompatActivity() {

    val randomNumber = Random.nextInt(11) // Random number between 0 and 10
    var tries = 0 // Number of tries
    var numOfGuesses = 3 // Number of guesses

    lateinit var submitButton: Button
    lateinit var etEnterMessage: EditText

    private var items = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_game)

        Log.d("MainActivity", randomNumber.toString())

        etEnterMessage = findViewById(R.id.etEnterMessage)

        submitButton = findViewById(R.id.btnSubmit)

        submitButton.setOnClickListener{ addItems() }
    }

    private fun addItems() {
        if (numOfGuesses > 0) {
            if (etEnterMessage.text.isEmpty() || etEnterMessage.text.toString() == " ") {
                Snackbar.make(clMain, "You did not enter anything!", Snackbar.LENGTH_SHORT).show()
                return

            } else if (etEnterMessage.text.toString() == randomNumber.toString()) {
                items.add("You entered: ${etEnterMessage.text.toString()}")
                items.add("You guessed correctly")
                val myRV = findViewById<RecyclerView>(R.id.rvNumbersGame)
                myRV.adapter = NumbersGameRVAdapter(items)
                myRV.layoutManager = LinearLayoutManager(this)

                btnSubmit.isEnabled = false
                etEnterMessage.text.clear()

            } else {
                items.add("You entered: ${etEnterMessage.text.toString()}")
                items.add("You have ${numOfGuesses-1} tries left")

                val myRV = findViewById<RecyclerView>(R.id.rvNumbersGame)
                myRV.adapter = NumbersGameRVAdapter(items)
                myRV.layoutManager = LinearLayoutManager(this)

                etEnterMessage.text.clear()

                Log.d("MainActivity", items.toString())
            }
            numOfGuesses--
        }

        if (numOfGuesses==0){
            items.add("Game Over!")
            btnSubmit.isEnabled = false
            etEnterMessage.text.clear()
        }
    }
}