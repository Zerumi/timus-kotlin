/**
 * №1079. Maximum
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1079
 *
 * Idea: DP, find maximum in the sequence.
 *
 * This solution gets AC with 0.171s of time and 6 232KB of memory
 */

fun main() {
    // input
    var line = readln()

    while (line != "0") {
        val n = line.toInt()

        // solution
        val arr = IntArray(n + 1)

        arr[0] = 0
        arr[1] = 1

        for (i in 2..n) {
            if (i % 2 == 0) arr[i] = arr[i / 2]
            else arr[i] = arr[i / 2] + arr[i / 2 + 1]
        }

        // output
        println(arr.maxOrNull()!!)

        line = readln()
    }
}