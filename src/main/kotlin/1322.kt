/**
 * №1322. Spy
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1322
 *
 * Idea: Fast inverse Burrows Wheeler Transform.
 *
 * This solution gets AC with 0.25s of time and 11 528KB of memory
 *
 * @see <a href="http://cbloomrants.blogspot.com/2021/03/faster-inverse-bwt.html">source</a>
 */

fun main() {
    // input
    val eof = readln().toInt()
    val encrypted = readln()

    // solution
    val encryptedDeduplicated = encrypted.mapIndexed { index, it -> it to index }

    val sorted = encryptedDeduplicated.sortedBy { it.first }

    val decoded = CharArray(encrypted.length) { '?' }

    var next = eof - 1
    for (i in decoded.indices) {
        decoded[i] = sorted[next].first
        next = sorted[next].second
    }

    // output
    println(String(decoded))
}