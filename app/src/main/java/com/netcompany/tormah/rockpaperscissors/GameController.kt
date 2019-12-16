package com.netcompany.tormah.rockpaperscissors

class GameController {

    private val model: GameModel = GameModel()

    fun onPlayerAction(choice: GameAction): GameData {
        return model.calculateWinner(choice)
    }
}