/**
 * №1068. Sum
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1068
 *
 * Idea: Using pre-defined formula of arithmetic progression.
 *
 * This solution gets AC with 0.14s of time and 460KB of memory.
 */

fun main() {
    val n = readln().toInt()

    println(
        if (n > 0) {
            n * (n + 1) / 2
        } else {
            1 - n * (n - 1) / 2
        }
    )
}
