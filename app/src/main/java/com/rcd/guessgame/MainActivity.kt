package com.rcd.guessgame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var user:TextView? = null
    var result : Button? = null
    var answer:Int? = null
    var empty:TextView? = null
    var score : TextView? = null
    var playAgain: Button? = null
    var guess = 5
    var input : Int? = null
    var answerDisplay : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)
    }

    fun game(view:View){
        setContentView(R.layout.activity_main)
        user = findViewById(R.id.userNumber)
        result = findViewById(R.id.guess)
        empty = findViewById(R.id.display)
        score = findViewById(R.id.score)
        playAgain = findViewById(R.id.again)
        answer = (0..20).random()
        playAgain?.isClickable = false
        result?.setOnClickListener {
            val inputText = user?.text.toString()
            if (inputText.isNotEmpty()) {
                input = inputText.toInt()
                if (guess > 1) {
                    if (input == answer) {
                        setContentView(R.layout.win_page)
                    }
                    else {
                        if (input!! >= answer!!) {
                            empty?.text = "Your answer is very High"
                        } else {
                            empty?.text = "Your answer is very low"
                        }
                        guess = guess - 1
                        score?.text = "Your guess is : ${guess}"
                        user?.text = ""
                    }
                }
                else {
                    guess = guess - 1
                    answerDisplay?.text = answer.toString()
                    setContentView(R.layout.end_page)

                }
            }
            else {
                empty?.text = "enter the vaild input"
                score?.text = "Your guess is : ${guess}"
                playAgain?.isClickable = true
            }
        }

        playAgain(view)

    }

    fun playAgain(view: View) {
        guess = 5
        playAgain?.setOnClickListener {
            answer = (0..20).random()
            user?.text = "" // Clear the user input TextView
            empty?.text = ""
            playAgain?.isClickable = false

        }
    }
    fun home(view: View){
        setContentView(R.layout.first_page)
    }

}