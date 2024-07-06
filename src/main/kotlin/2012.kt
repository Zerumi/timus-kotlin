/**
 * №2012. About Grisha N.
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2012
 *
 * Idea: Described below.
 *
 * This solution gets AC with 0.171s of time and 500KB of memory
 */

fun main() {
    // 4 hours is 240 minutes
    // -> max 5 tasks (1 task = 45 minutes)

    // input
    val f = readln().toInt()

    // solution
    val answer = 12 - 5 <= f

    // output
    println(if (answer) "YES" else "NO")
}