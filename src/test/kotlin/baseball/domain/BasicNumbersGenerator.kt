package baseball.domain

class BasicNumbersGenerator(private val numbers: Numbers) : NumbersGenerator {

    override fun generate(): Numbers {
        return numbers
    }
}
