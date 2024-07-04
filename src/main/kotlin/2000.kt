/**
 * №2000. Grand Theft Array V
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2000
 *
 * Idea: If the distance between players is 0 (starting from one point),
 * the first player will take a max sum from the left or right side, second - min sum.
 *
 * If distance is not 0, take the middle between two players, and calculate sums
 * start-middle and middle-finish. That was the answer (warning! a lot of edge-cases)
 *
 * This solution gets AC with 0.296s of time and 13 208KB of memory
 */

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    // input
    val n = readln().toInt()
    val arr = readln().split(' ').map { it.toInt() }
    val (first, second) = readln().split(' ').map { it.toInt() - 1 }

    // solution
    val difference = abs(second - first) - 1
    val middle = difference / 2

    val firstAnswer: Int
    val secondAnswer: Int
    if (second - first > 0) {
        if (difference % 2 != 0) {
            firstAnswer = arr.take(first + middle + 2).sum()
            secondAnswer = arr.drop(first + middle + 2).sum()
        } else {
            firstAnswer = arr.take(first + middle + 1).sum()
            secondAnswer = arr.drop(first + middle + 1).sum()
        }
    } else if (second - first < 0) {
        firstAnswer = arr.drop(second + middle + 1).sum()
        secondAnswer = arr.take(second + middle + 1).sum()
    } else {
        val rightFirstSum = arr.drop(first).sum()
        val leftFirstSum = arr.take(first + 1).sum()

        val rightSecondSum = arr.drop(second + 1).sum()
        val leftSecondSum = arr.take(second).sum()

        firstAnswer = max(rightFirstSum, leftFirstSum)
        secondAnswer = min(rightSecondSum, leftSecondSum)
    }

    // output
    print("$firstAnswer $secondAnswer")
}