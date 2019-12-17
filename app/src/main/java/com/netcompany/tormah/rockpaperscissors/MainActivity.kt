package com.netcompany.tormah.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO: create a solution using a architectural pattern MVC, MVVM, etc...
    //  There is a model and some enums in the GameModel.kt file.
    //  Choose if you want to build upon this, or delete them and start fresh.
    //  Create a file for the Controller or ViewModel depending on the architecture you choose.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: retrieve the views and update them with useful text ex below:
        textView_main_myChoice.text = GameAction.Rock.toString()
        // An example pof changing a views visibility
        textView_main_playAgainInfo.visibility = View.INVISIBLE


    }

    // TODO: create logic for handling user input
    // The user interface should reflect the games two states;
    // State 1: waiting for the user to select a action, i.e. either the rock, paper or
    // scissors buttons.
    // State 2; Displaying the result of the game, where the "new game" button resets
    // the game to state 1.


}
