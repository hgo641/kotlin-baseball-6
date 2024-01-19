package baseball.domain

const val NUMBERS_SIZE = 3

class Numbers(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBERS_SIZE) { "숫자는 세 자리만 가능합니다." }
        require(numbers.size == numbers.distinct().size) { "숫자안의 수들은 중복이 될 수 없습니다." }
    }

    fun countStrike(other: Numbers): Int {
        return numbers.zip(other.numbers).count { (a, b) -> a == b }
    }

    fun countBall(other: Numbers): Int {
        val overlapCount = numbers.intersect(other.numbers.toSet()).count();
        return overlapCount - countStrike(other)
    }

    companion object {
        fun from(inputs: String): Numbers {
            val numbers = inputs.map { it.toString().toInt() }
            return Numbers(numbers)
        }
    }
}