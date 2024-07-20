/**
 * №1264. Workdays
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1264
 *
 * Idea: Calculate A * (B + 1). Best Kotlin oneliner practise.
 *
 * This solution gets AC with 0.156s of time and 3 136KB of memory
 */

fun main() =
    println(readln().split(" ").map { it.toInt() }.take(2).reduce { acc, i -> acc * (i + 1) })