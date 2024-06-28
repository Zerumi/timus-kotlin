/**
 * №1496. Spammer
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1496
 *
 * Idea: Using a Map<String, Count: Int>. Which count is > 1 - then output.
 *
 * This solution gets AC with 0.171s of time and 2 312KB of memory
 */
fun main() {
    // input
    val N = readln().toInt()

    // solution
    val teamMap = buildMap<String, Int> {
        repeat(N) {
            val key = readln()
            put(key, (getOrPut(key) { 0 }) + 1)
        }
    }

    // output
    for ((k, v) in teamMap) {
        if (v > 1) println(k)
    }
}