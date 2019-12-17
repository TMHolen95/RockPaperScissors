package com.netcompany.tormah.rockpaperscissors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    var gameData: MutableLiveData<GameData> = MutableLiveData()
    private val model: GameModel = GameModel()

    fun onPlayerAction(choice: GameAction) = gameData.postValue(model.calculateWinner(choice))
}