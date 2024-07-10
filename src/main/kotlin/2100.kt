/**
 * №2100. Wedding Dinner
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2100
 *
 * Idea: Get substring from the tail of the string for check "+one".
 * If members will == 13, the answer is 1400
 *
 * This solution gets AC with 0.187s of time and 2 424KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val names = List(n) {
        readln()
    }

    // solution
    val additional = names.count { it.takeLast(4) == "+one" }
    val answer = if (additional + n + 2 == 13) 14 else additional + n + 2

    // output
    println(answer * 100)
}