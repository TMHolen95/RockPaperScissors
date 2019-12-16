package com.netcompany.tormah.rockpaperscissors

import androidx.lifecycle.MutableLiveData

class GameViewModel{

    lateinit var gameData: MutableLiveData<GameData>
    val model: GameModel = GameModel()

    fun onPlayerAction(choice: GameAction) = gameData.postValue(model.calculateWinner(choice))

    fun onNewGame() = gameData.postValue(model.newGame())
}