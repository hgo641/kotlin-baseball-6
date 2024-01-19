package baseball.domain

class RoundResult(val ballCount: Int, val strikeCount: Int) {

    init {
        require(ballCount >= 0 || strikeCount >= 0) { "볼과 스트라이크 카운트는 음수일 수 없습니다." }
    }

    fun isWin(): Boolean {
        return strikeCount == 3
    }

    fun isNothing(): Boolean {
        return ballCount == 0 && strikeCount == 0
    }

    fun isOnlyBall(): Boolean {
        return ballCount > 0 && strikeCount == 0
    }

    fun isOnlyStrike(): Boolean {
        return ballCount == 0 && strikeCount > 0
    }

    fun isBallAndStrike(): Boolean {
        return ballCount > 0 && strikeCount > 0
    }
}
