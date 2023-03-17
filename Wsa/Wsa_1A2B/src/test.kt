import java.util.Random

fun main() {
    val answer = generateAnswer()
    var guess = ""
    var count = 0

    while (guess != answer) {
        print("Input your guess: ")
        guess = readlnOrNull() ?: ""
        count ++

        if (guess.length != 4 || !guess.all { it.isDigit() }) {
            println("Invalid answer")
            continue
        }

        val (a, b) = checkAnswer(guess, answer)
        println("Times: $count, $guess -> $a A $b B")
    }

    println("You win at $count times")
}

fun generateAnswer(): String {
    val digits = (0..9).toMutableList()
    return (0..3).map {
        digits.removeAt(Random().nextInt(digits.size))
    }.joinToString("")
}

fun checkAnswer(guess: String, answer: String): Pair<Int, Int> {
    val guessDigits = guess.toList()
    val answerDigits = answer.toList()
    val a = guessDigits.zip(answerDigits).count { (a, b) -> a == b }
    val b = (guessDigits intersect answerDigits).size - a
    return a to b
}
