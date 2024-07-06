/**
 * №1010. Discrete Function
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1010
 *
 * Idea: Build differences between neighbour points and find maximum (divide by 1).
 * Because minimal difference between points is 1, probably, other differences and validating
 * restriction isn't necessary. I really surprised, that this solution got AC.
 *
 * This solution gets AC with 0.265s of time and 7 804KB of memory
 */

import kotlin.math.abs

fun main() {
    // input
    val n = readln().toInt()
    val function = List(n) { readln().toLong() }

    // solution
    val differences = List(n) { index ->
        abs(function[index] - function[(index + 1) % n])
    }

    val maximum = differences.indexOf(differences.maxOrNull()!!)

    // output
    if (maximum + 1 != n)
        println("${maximum + 1} ${maximum + 2}")
    else
        println("1 $n")
}