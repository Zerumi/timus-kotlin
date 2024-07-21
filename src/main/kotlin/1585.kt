/**
 * №1585. Penguins
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1585
 *
 * Idea: Get leading element in list with stdlib eachCount() function.
 *
 * This solution gets AC with 0.14s of time and 1 472KB of memory
 */

enum class Penguins {
    EMPEROR,
    LITTLE,
    MACARONI
}

fun main() {
    // input
    val n = readln().toInt()
    val penguins = List(n) {
        when (readln()) {
            "Emperor Penguin" -> Penguins.EMPEROR
            "Little Penguin" -> Penguins.LITTLE
            "Macaroni Penguin" -> Penguins.MACARONI
            else -> throw IllegalArgumentException("Unknown Penguin")
        }
    }

    // solution
    val answer = penguins.groupingBy { it }.eachCount().maxBy { it.value }.key

    // output
    println(
        when (answer) {
            Penguins.EMPEROR -> "Emperor Penguin"
            Penguins.LITTLE -> "Little Penguin"
            Penguins.MACARONI -> "Macaroni Penguin"
        }
    )
}