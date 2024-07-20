/**
 * №1149. Sinus Dances
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1149
 *
 * Idea: Build string recursively.
 *
 * This solution gets AC with 0.156s of time and 16 560KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()

    // solution
    val answer = buildSn(n, 1)

    // output
    println(answer.substring(1..answer.length - 2))
}

fun buildSn(n: Int, reverseN: Int): String {
    if (n == 1) return "(${buildAn(1, n)}+$reverseN)"
    return "(${buildSn(n - 1, reverseN + 1)}${buildAn(1, n)}+$reverseN)"
}

fun buildAn(n: Int, limit: Int): String {
    if (n == limit) return "sin($n)"
    return "sin($n${if (n % 2 == 0) "+" else "-"}${buildAn(n + 1, limit)})"
}