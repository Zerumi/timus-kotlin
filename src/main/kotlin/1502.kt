/**
 * №1502. Domino Dots
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1502
 *
 * Idea: Using recursion for build domino sets
 * from 0 (where the answer is 0) to N.
 *
 * This solution gets AC with 0.265s of time and 716KB of memory
 */

fun main() {
    // input
    val n = readln().toLong()

    // for N = 2:
    // 0-0; 0-1; 0-2 - sum 3
    // 1-1; 1-2      - sum 5
    // 2-2           - sum 4
    // 3 + 4 + 5 = 12

    // for N = 3:
    // 0-0; 0-1; 0-2; 0-3 - sum 6
    // 1-1; 1-2; 1-3      - sum 9
    // 2-2; 2-3           - sum 9
    // 3-3                - sum 6
    // 6 + 9 + 9 + 6 = 30

    // output
    println(buildDominoSet(n))
}

fun buildDominoSet(n: Long) : Long {
    // solution
    if (n == 0L) return 0
    var count = buildDominoSet(n - 1)
    for (i in 0..n) {
        count += i + n
    }
    return count
}