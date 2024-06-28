/**
 * №1209. 1, 10, 100, 1000...
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1209
 *
 * Idea: The formula below.
 * If this is a member of a higher order progression,
 * then we will output 1. If the position is fractional,
 * this is not a member of the progression (out 0).
 *
 * This solution gets AC with 0.25s of time and 4 288KB of memory.
 */
import kotlin.math.sqrt

fun main() {
    // input
    val n = readln().toInt()

    repeat(n) {
        val pos = readln().toLong()

        // solution
        // 1, 2, 4, 7, 11, 16, 22, 29..
        // 1, 2, 3, 4, 5, 6, 7,..
        // 1, 1, 1, 1, 1, 1, 1,..

        // a_n = 1 + n - 1 + 1/2 * (n^2 -3n + 2)
        // a_n = n + 1/2n^2 -3/2n + 1
        // a_n = 1/2n^2 -1/2n + 1
        // 2a_n = n^2 - n + 2
        // n^2 - n + 2(1 - a_n) = 0
        // n = (1 + sqrt(1 - 8(1 - a_n))) / 2

        val x = (1 + sqrt((1 - 8 * (1 - pos)).toDouble())) / 2

        // output
        if (x % 1 == 0.0) print("1 ")
        else print("0 ")
    }
}