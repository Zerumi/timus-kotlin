/**
 * №1567. SMS-spam
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1567
 *
 * Idea: There is a formula:
 * <click count> = 1 + (it.code - 'a'.code) % 3 for a-z letter
 * and one click for ' ' and '.', two for ',' and three for '!'.
 *
 * This solution gets AC with 0.187s of time and 1 928KB of memory
 */

fun main() {
    // input
    val message = readln()

    // solution
    val cost = message.map {
        if (it.isLetter()) {
            return@map 1 + (it.code - 'a'.code) % 3
        } else when (it) {
            ' ' -> return@map 1
            '.' -> return@map 1
            ',' -> return@map 2
            '!' -> return@map 3
            else -> throw IllegalArgumentException()
        }
    }.sum()

    // output
    println(cost)
}