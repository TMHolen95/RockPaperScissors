package com.netcompany.tormah.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[GameViewModel::class.java]

        button_main_rockChosen.setOnClickListener { updateScreen(GameAction.Rock) }
        button_main_paperChosen.setOnClickListener { updateScreen(GameAction.Paper) }
        button_main_scissorsChosen.setOnClickListener { updateScreen(GameAction.Scissors) }
        displayFeedback()
        firstUpdate()
    }

    // By not using a observable we have to do some extra work to make the ViewModel work properly.
    // When combined with the ViewModel this makes the app work as expected when rotated.
    // In addition a change to the GameModel was required to allow for datatypes with null.
    private fun firstUpdate() {
        val gameData = viewModel.getLastState()

        textView_main_winState.text = gameData.gameState.toString()

        // If the user haven't made a selection display default text.
        textView_main_opponentChoice.text = if (gameData.opponentAction == null) {
            "Waiting..."
        } else {
            gameData.opponentAction.toString()
        }

        textView_main_myChoice.text = if (gameData.playerAction == null) {
            "Make a choice"
        } else {
            gameData.playerAction.toString()
        }
    }

    private fun updateScreen(playerChoice: GameAction) {
        val gameData = viewModel.onPlayerAction(playerChoice)
        textView_main_winState.text = gameData.gameState.toString()
        textView_main_myChoice.text = gameData.playerAction.toString()
        textView_main_opponentChoice.text = gameData.opponentAction.toString()
    }

    private fun displayFeedback() {
        textView_main_playAgainInfo.visibility = View.VISIBLE

    }
}