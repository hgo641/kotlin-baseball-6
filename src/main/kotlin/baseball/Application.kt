package baseball

import baseball.controller.GameController
import baseball.view.View

fun main() {
    val gameController = GameController(View())
    gameController.startGame();
}
