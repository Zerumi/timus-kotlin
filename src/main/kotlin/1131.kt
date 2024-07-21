/**
 * №1131. Copying
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1131
 *
 * Idea: Calculate max binary spreading: +1, +2, +4, +8... +k.
 * After it, calculate remaining computers, and it's spreading is linear by k.
 *
 * This solution gets AC with 0.187s of time and 3 292KB of memory
 */

import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

fun main() {
    // input
    val (n, k) = readln().split(' ').map { it.toInt() }

    // solution
    val total: Int

    val spreadingMaxKTime = ceil(log2(k.toFloat())).toInt() + 1
    val maxSpread = (2.0.pow(spreadingMaxKTime - 1)).toInt() + k

    if (maxSpread > n) {
        total = ceil(log2(n.toFloat())).toInt()
    } else {
        val remainingComputers = n - maxSpread
        val remainingTime = remainingComputers / k + if (remainingComputers % k != 0) 1 else 0
        total = spreadingMaxKTime + remainingTime
    }

    // output
    println(total)
}