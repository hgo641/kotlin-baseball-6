package baseball.controller

import baseball.domain.*
import baseball.view.View

class GameController(val view: View, val numbersGenerator: NumbersGenerator = RandomNumbersGenerator()) {

    fun startGame() {
        view.printStartGameMessage();
        do {
            playEachGame()
        } while (isRetryGame())
    }

    private fun playEachGame() {
        val game = Game(numbersGenerator)
        do {
            val userNumbers = Numbers.from(view.inputUserNumbers())
            val roundResult = game.playRound(userNumbers)
            view.printRoundResult(roundResult)
        } while (!roundResult.isWin())
        view.printWinMessage()
    }

    private fun isRetryGame(): Boolean {
        val retryCommand = RetryCommand.from(view.inputRetryCommand())
        return retryCommand.equals(RetryCommand.RETRY);
    }
}