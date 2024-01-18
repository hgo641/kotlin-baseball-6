package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersGenerator : NumbersGenerator {

    override fun generate(): Numbers {
        val numbers: MutableList<Int> = mutableListOf();
        while (numbers.size < NUMBERS_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return Numbers(numbers)
    }
}