package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumbersTest {

    @Test
    fun 세_자리수가_아니면_예외가_발생한다() {
        assertThatThrownBy { Numbers(listOf(1, 2)) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자는 세 자리만 가능합니다.")
    }

    @Test
    fun 숫자가_중복이면_예외가_발생한다() {
        assertThatThrownBy { Numbers(listOf(1, 2, 2)) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자안의 수들은 중복이 될 수 없습니다.")
    }

    @Test
    fun 스트라이크를_카운트한다() {
        var numbers1 = Numbers(listOf(1,2,3))
        var numbers2 = Numbers(listOf(1,3,2))

        assertThat(numbers1.countStrike(numbers2)).isEqualTo(1);
    }

    @Test
    fun 볼을_카운트한다() {
        var numbers1 = Numbers(listOf(1,2,3))
        var numbers2 = Numbers(listOf(1,3,2))

        assertThat(numbers1.countBall(numbers2)).isEqualTo(2);
    }
}