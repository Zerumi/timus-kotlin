/**
 * №1025. Democracy in Danger
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1025
 *
 * Idea: Get 1/2 of groups with minimal amount of people and pick 1/2 of people from each of them.
 *
 * This solution gets AC with 0.187s of time and 6 952KB of memory
 */

import kotlin.math.roundToInt

fun main() {
    // input
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    // solution
    val sorted = arr.sorted().take((n / 2.0).roundToInt())
    val answer = sorted.sumOf { (it / 2.0).roundToInt() }

    // output
    println(answer)
}