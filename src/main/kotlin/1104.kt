/**
 * №1104. Don’t Ask Woman about Her Age
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1104
 *
 * Idea: If sum of numbers dividable by (k - 1), then whole number dividable by (k - 1)
 *
 * This solution gets AC with 0.437s of time and 14 584KB of memory.
 */

import kotlin.math.max

fun main() {
    // A1A_22 = 10*22 + 1*22*22 + 10*22*22*22 = 107184
    // 107184 / 21 = 5104

    // input
    val number = readln().toCharArray().map {
        if (it.isLetter()) it.code - 'A'.code + 10
        else it.code - '0'.code
    }

    // solution
    var answer = -1
    val startNotation = max(number.maxOrNull()!! + 1, 2)

    for (notation in startNotation..36) {
        val convertedNumber = number.sum()

        if (convertedNumber % (notation - 1) == 0) {
            answer = notation
            break
        }
    }

    // output
    if (answer == -1) {
        println("No solution.")
    } else {
        println(answer)
    }
}