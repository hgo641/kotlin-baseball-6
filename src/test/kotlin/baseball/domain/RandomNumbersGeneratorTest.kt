package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumbersGeneratorTest {

    @Test
    fun 랜덤으로_숫자를_생성한다() {
        val numberGenerator = RandomNumbersGenerator()
        assertThat(numberGenerator.generate()).isInstanceOf(Numbers::class.java)
    }
}
