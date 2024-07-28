/**
 * №1011. Conductors
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1011
 *
 * Idea: Brute-force i and j for match j / i ratio between input.
 *
 * This solution gets AC with 0.203s of time and 3 168KB of memory
 */

import kotlin.math.abs

fun Double.fuzzyEquals1011(other: Double): Boolean = abs(this - other) < 1e-10

fun main() {
    // input
    val (start, finish) = readln().split(' ').map { it.toDouble() / 100 }

    // solution
    for (i in 1..10000) {
        for (j in 1..i) {
            val ratio = j / i.toDouble()

            if (ratio > start && ratio < finish &&
                !ratio.fuzzyEquals1011(start) && !ratio.fuzzyEquals1011(finish)
            ) {
                // output
                println(i)
                return
            }
        }
    }
}