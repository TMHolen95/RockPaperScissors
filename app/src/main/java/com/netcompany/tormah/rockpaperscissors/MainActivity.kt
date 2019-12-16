package com.netcompany.tormah.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel = GameController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_main_rockChosen.setOnClickListener { updateScreen(GameAction.Rock) }
        button_main_paperChosen.setOnClickListener { updateScreen(GameAction.Paper) }
        button_main_scissorsChosen.setOnClickListener { updateScreen(GameAction.Scissors) }
        displayFeedback()
    }

    private fun updateScreen(playerChoice: GameAction) {
        val gameData = viewModel.onPlayerAction(playerChoice)
        textView_main_myChoice.text = gameData.playerAction.toString()
        textView_main_winState.text = gameData.gameState.toString()
        textView_main_opponentChoice.text = gameData.opponentAction.toString()
    }

    private fun displayFeedback() {
        textView_main_playAgainInfo.visibility = View.VISIBLE

    }
}