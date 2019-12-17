package com.netcompany.tormah.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO: create a solution using the MVVM architectural pattern
    //  There is a model and some enums in the GameModel.kt file.
    //  1. Create a file for the ViewModel file .
    //  2. Connect the Activity with the ViewModel
    //  3. Connect the ViewModel with the GameModel
    //  4. Update the Views in the activity to reflect hte state of the game
    //  5. Attempt to figure out how to keep the game state when rotating the phone
    //  For info on LiveModel see:
    //  https://developer.android.com/topic/libraries/architecture/viewmodel
    //  If MutableLiveData is hard, try just replacing it with a simple variable with GameData


    // val model: MyViewModel = //TODO instantiate retrieve ViewModel
    // Note in Kotlin values that don't get reassigned are defined with "val",
    // if they get reassigned use "var"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO replace with your own code

        // In kotlin you can access views by their id directly (as shown a few lines below),
        // or you can assign them to variables like this:
        val textView = findViewById<TextView>(R.id.textView_main_myChoice)

        // Example: Setting text on a view:
        textView_main_myChoice.text = GameAction.Rock.toString()

        // Example: Changing a views visibility:
        textView_main_playAgainInfo.visibility = View.INVISIBLE

        // Example: Adding a button listener:
        button_main_paperChosen.setOnClickListener {
            // You can update TextViews in listeners like these

            // This logs to the Logcat (Hit: Alt + 6)
            Log.d("MainActivity","I was clicked")
        }

    }




}
