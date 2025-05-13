/**
 * №1457. Heating Main
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1457
 *
 * Idea: I don't actually sure why p.average() is a solution
 *
 * This solution gets AC with 0.156s of time and 3 364KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val p = readln().split(' ').map { it.toInt() }

    // solution
    val answer = p.sum() / n.toDouble()

    // output
    println(answer)
}
