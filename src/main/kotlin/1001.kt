/**
 * №1001. Reverse Root
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1001
 *
 * Idea: Calculate reverse root. Solution mainly taken from tutorial.
 *
 * This solution gets AC with 0.875s of time and 18 008KB of memory
 */

import kotlin.math.sqrt

fun main() {
    // input
    val input = generateSequence { readlnOrNull() }.takeWhile { true }.joinToString(" ") { it }
        .split(' ')
        .filter { it.isNotEmpty() }
        .map { it.trim().toDouble() }

    // solution
    val solution = input.reversed().map { sqrt(it) }

    // output
    println(solution.joinToString("\n") { "%.4f".format(it) })
}

/* oneliner works slower - 1.406s and 17 724KB
fun main() =
    generateSequence { readlnOrNull() }.takeWhile { true }.joinToString(" ") { it }
        .split(' ')
        .filter { it.isNotEmpty() }
        .map { it.trim().toDouble() } // input
        .reversed()
        .map { "%.4f".format(sqrt(it)) } // solution
        .forEach(::println) // output
 */