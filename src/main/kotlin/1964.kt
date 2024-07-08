/**
 * №1964. Chinese Dialects
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1964
 *
 * Idea: Calculate intersection between k values.
 *
 * This solution gets AC with 0.187s of time and 3 120KB of memory
 */

fun main() {
    // input
    val (n, _) = readln().split(" ").map { it.toLong() }
    val arr = readln().split(" ").map { it.toLong() }

    // solution
    var intersection = arr[0]
    for (i in 0..<arr.lastIndex) {
        intersection = intersection + arr[i + 1] - n
        if (intersection < 0) {
            intersection = 0
            break
        }
    }

    // output
    println(intersection)
}