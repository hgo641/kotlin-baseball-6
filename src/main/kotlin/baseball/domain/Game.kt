package baseball.domain

class Game(numbersGenerator: NumbersGenerator = RandomNumbersGenerator()) {

    private val answerNumbers = numbersGenerator.generate()

    fun playRound(userNumbers: Numbers): RoundResult {
        val ballCount = answerNumbers.countBall(userNumbers)
        val strikeCount = answerNumbers.countStrike(userNumbers)
        return RoundResult(ballCount, strikeCount)
    }
}
