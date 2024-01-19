package baseball.view

import baseball.domain.RoundResult

class View {

    fun printStartGameMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun inputUserNumbers(): String {
        print("숫자를 입력해주세요 : ")
        return readln()
    }

    fun printRoundResult(roundResult: RoundResult) {
        if (roundResult.isNothing()) {
            println("낫싱")
        }
        if(roundResult.isOnlyBall()) {
            println("%d볼".format(roundResult.ballCount))
        }
        if(roundResult.isOnlyStrike()) {
            println("%d스트라이크".format(roundResult.strikeCount))
        }
        if(roundResult.isBallAndStrike()) {
            println("%d볼 %d스트라이크".format(roundResult.ballCount, roundResult.strikeCount))
        }
    }

    fun printWinMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun inputRetryCommand(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readln()
    }
}
