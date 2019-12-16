package com.netcompany.tormah.rockpaperscissors

import androidx.lifecycle.MutableLiveData

class GameViewModel {

    var gameData: MutableLiveData<GameData> = MutableLiveData()
    private val model: GameModel = GameModel()

    fun onPlayerAction(choice: GameAction) = gameData.postValue(model.calculateWinner(choice))
}