package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GameTest {

    @Nested
    inner class 라운드_결과를_반환한다 {

        val answerNumbers = Numbers(listOf(1, 2, 3))
        val game = Game(BasicNumbersGenerator(answerNumbers))

        @Test
        fun 낫싱을_반환한다() {
            val userNumbers = Numbers(listOf(4, 5, 6))
            val roundResult = game.playRound(userNumbers)
            assertThat(roundResult.isNothing()).isTrue()
        }

        @Test
        fun 볼만_반환한다() {
            val userNumbers = Numbers(listOf(2, 3, 1))
            val roundResult = game.playRound(userNumbers)
            assertSoftly {
                it.assertThat(roundResult.isOnlyBall()).isTrue
                it.assertThat(roundResult.ballCount).isEqualTo(3)
            }
        }

        @Test
        fun 스트라이크만_반환한다() {
            val userNumbers = Numbers(listOf(1, 2, 4))
            val roundResult = game.playRound(userNumbers)
            assertSoftly {
                it.assertThat(roundResult.isOnlyStrike()).isTrue
                it.assertThat(roundResult.strikeCount).isEqualTo(2)
            }
        }

        @Test
        fun 볼과_스트라이크를_반환한다() {
            val userNumbers = Numbers(listOf(1, 3, 2))
            val roundResult = game.playRound(userNumbers)
            assertSoftly {
                it.assertThat(roundResult.isBallAndStrike()).isTrue
                it.assertThat(roundResult.strikeCount).isEqualTo(1)
                it.assertThat(roundResult.ballCount).isEqualTo(2)
            }
        }

        @Test
        fun 게임에서_승리한다() {
            val userNumbers = Numbers(listOf(1, 2, 3))
            val roundResult = game.playRound(userNumbers)
            assertSoftly {
                it.assertThat(roundResult.isWin()).isTrue
                it.assertThat(roundResult.isOnlyStrike()).isTrue
                it.assertThat(roundResult.strikeCount).isEqualTo(3)
                it.assertThat(roundResult.ballCount).isEqualTo(0)
            }
        }
    }
}
