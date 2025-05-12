/**
 * №1576. Telephone Tariffs
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1576
 *
 * Idea: Each tariff has a formula for calculation.
 * Economy tariff = n1 + c1 * callsTotalMinutes
 * Combined tariff = n2 + c2 * (totalMinutes - t).coerceAtLeast(0)
 * / ! \ Pay attention - (totalMinutes - t) may become < 0, which should be handled
 * Unlimited tariff = n3
 *
 * This solution gets AC with 0.156s of time and 3 880KB of memory
 */

fun main() {
    // input
    val (n1, c1) = readln().split(' ').map { it.toInt() }
    val (n2, t, c2) = readln().split(' ').map { it.toInt() }
    val n3 = readln().toInt()
    val k = readln().toInt()
    val calls = List(k) {
        val (first, second) = readln().split(':').map { it.toInt() }
        return@List first to second
    }

    // solution
    val callsTotalMinutes = calls.filterNot { it.first == 0 && it.second <= 6 }
        .sumOf { if (it.second > 0) it.first + 1 else it.first }
    val economy = n1 + c1 * callsTotalMinutes
    val combined = n2 + c2 * (callsTotalMinutes - t).coerceAtLeast(0)
    val unlimited = n3

    // output
    println("Basic:     $economy")
    println("Combined:  $combined")
    println("Unlimited: $unlimited")
}
