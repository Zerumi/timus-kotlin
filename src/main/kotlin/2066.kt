/**
 * №2066. Simple Expression
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2066
 *
 * Idea: Only 2 possible expressions will give minimum result: a - b * c or a - b - c.
 *
 * This solution gets AC with 0.156s of time and 528KB of memory
 */

import kotlin.math.min

fun main() {
    // input
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    // solution
    val answerMultiply = a - b * c
    val answerAddition = a - b - c
    val answer = min(answerMultiply, answerAddition)

    // output
    println(answer)
}