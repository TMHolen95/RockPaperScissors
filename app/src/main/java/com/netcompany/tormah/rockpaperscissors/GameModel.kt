package com.netcompany.tormah.rockpaperscissors

enum class GameState { PlayerChoosing, Victory, Draw, Loss }
enum class GameAction { Rock, Paper, Scissors }

class GameModel {

    var gameState = GameState.PlayerChoosing

    // Should be used in the game to reflect the GameState
    lateinit var playerAction: GameAction
    lateinit var opponentAction: GameAction

    fun calculateWinner(playerAction: GameAction): GameState {
        // Set the actions for the player
        opponentAction = randomizeOpponentAction()
        this.playerAction = playerAction

        return when (playerAction) {
            GameAction.Paper -> paperChosen(opponentAction)
            GameAction.Rock -> rockChosen(opponentAction)
            GameAction.Scissors -> scissorsChosen(opponentAction)
        }
    }

    private fun randomizeOpponentAction(): GameAction {
        return GameAction.values().random()
    }

    private fun scissorsChosen(opponentAction: GameAction): GameState {
        return when (opponentAction) {
            GameAction.Rock -> GameState.Loss
            GameAction.Paper -> GameState.Victory
            GameAction.Scissors -> GameState.Draw
        }
    }

    private fun rockChosen(opponentAction: GameAction): GameState {
        return when (opponentAction) {
            GameAction.Rock -> GameState.Draw
            GameAction.Paper -> GameState.Loss
            GameAction.Scissors -> GameState.Victory
        }
    }

    private fun paperChosen(opponentAction: GameAction): GameState {
        return when (opponentAction) {
            GameAction.Rock -> GameState.Victory
            GameAction.Paper -> GameState.Draw
            GameAction.Scissors -> GameState.Loss
        }
    }
}