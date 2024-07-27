/**
 * №1820. Ural Steaks
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1820
 *
 * Idea: We need to cook 2*n halves of steaks. So, max utilization
 * there is 2 * n / k -> ceil to int = answer.
 * But if k >= n, answer is 2 (fry from two sides for one minute each)
 *
 * This solution gets AC with 0.187s of time and 3 140KB of memory
 */

import kotlin.math.ceil

fun main() {
    // input
    val (n, k) = readln().split(' ').map { it.toInt() }

    // solution
    val halves = 2 * n
    val answer = if (k >= n) 2 else ceil(halves / k.toDouble()).toInt()

    // val answer = ceil(halves / k.toDouble()).toInt() -> WA 8

    // output
    println(answer)
}