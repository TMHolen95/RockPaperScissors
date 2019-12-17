package com.netcompany.tormah.rockpaperscissors

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private val model: GameModel = GameModel()

    fun onPlayerAction(choice: GameAction): GameData {
        return model.calculateWinner(choice)
    }

    fun getLastState(): GameData {
        return model.gameData
    }
}