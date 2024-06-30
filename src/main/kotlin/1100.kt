/**
 * №1100. Final Standings
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1100
 *
 * Idea: Using library stable sort by second element in Pair<Int, Int>.
 * There are some simple optimizations, because pretty solution works slow.
 *
 * This solution gets AC with 1s of time and 12 524KB of memory.
 */

fun main() {
    // input
    val n = readln().toInt()

    val results = Array(n) {
        val pair = readln() // readln().split(' ').map { it.toInt() } - TLE 14
        return@Array Pair(pair.substringBefore(' ').toInt(), pair.substringAfter(' ').toInt())
    } // using List and sortedByDescending { ... } - MLE 11

    // solution
    results.sortByDescending { it.second }

    // output
    // println(results.joinToString("\n") { "${it.first} ${it.second}" }) - MLE 11
    for (result in results) {
        println("${result.first} ${result.second}")
    }
}