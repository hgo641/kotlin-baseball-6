package baseball.domain

enum class RetryCommand(val inputCommand: String) {
    RETRY("1"),
    EXIT("2");

    companion object {
        fun from(inputCommand: String): RetryCommand {
            return entries.find { it.inputCommand == inputCommand }
                ?: throw IllegalArgumentException("입력한 커맨드가 존재하지 않습니다.")
        }
    }
}
