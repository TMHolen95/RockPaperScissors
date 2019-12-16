package com.netcompany.tormah.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Variables are declared like this in Kotlin, add the lateinit modifier if the variable has no
    // initial value.
    lateinit var myHandAction: TextView

    // Values that doesn't change are declared like this:
    private val tag = "Rock-Paper-Scissors"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: retrieve the views and assign them decent variable names, ex below:
        myHandAction = textView_main_myChoice

    }

    // TODO: create logic for handling user input
    // The user interface should reflect the games two states;
    // State 1: waiting for the user to select a action, i.e. either the rock, paper or
    // scissors buttons.
    // State 2; Displaying the result of the game, where the "new game" button resets
    // the game to state 1.


}
