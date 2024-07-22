/**
 * №1409. Two Gangsters
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1409
 *
 * Idea: A + B equals to Total Cans + 1.
 * So, we need to swap b & a and subtract 1.
 *
 * This solution gets AC with 0.14s of time and 3 144KB of memory
 */

fun main() {
    // input
    val (a, b) = readln().split(' ').map { it.toInt() }

    // solution & output
    println("${b - 1} ${a - 1}")
}