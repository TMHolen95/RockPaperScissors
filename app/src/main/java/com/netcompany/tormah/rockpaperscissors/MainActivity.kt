package com.netcompany.tormah.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.TextView
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val viewModel = GameViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_main_rockChosen.setOnClickListener { viewModel.onPlayerAction(GameAction.Rock) }
        button_main_paperChosen.setOnClickListener { viewModel.onPlayerAction(GameAction.Paper) }
        button_main_scissorsChosen.setOnClickListener { viewModel.onPlayerAction(GameAction.Scissors) }

        viewModel.gameData.observe(this, gameObserver)
    }

    private var gameObserver = Observer<GameData> { value ->
        textView_main_myChoice.text = value.playerAction.toString()
        textView_main_opponentChoice.text = value.opponentAction.toString()
        textView_main_winState.text = value.gameState.toString()
        displayFeedback()
    }

    private fun displayFeedback() {
        textView_main_playAgainInfo.visibility = View.VISIBLE

        // An example of a Kotlin Coroutine this starts a thread which waits x ms and then tells the
        // UI thread to update a view in the UI.
        CoroutineScope(Dispatchers.Unconfined).launch {
            delay(1500)
            runOnUiThread {
                textView_main_playAgainInfo.visibility = View.INVISIBLE
            }
        }
    }
}