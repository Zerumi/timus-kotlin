/**
 * №1020. Rope
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1020
 *
 * Idea: Calculate distances between centers.
 * Sum of rounded corners are equal to length of 1 circle.
 * We should sum all of these distances.
 *
 * This solution gets AC with 0.203s of time and 3 612KB of memory
 */

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    // input
    val strNR = readln()
    val n = strNR.substringBefore(' ').toInt()
    val r = strNR.substringAfter(' ').toDouble()
    val points = List(n) {
        val string = readln()
        return@List Pair(string.substringBefore(' ').toDouble(), string.substringAfter(' ').toDouble())
    }

    // solution
    val arcLengthSum = 2 * PI * r
    val centerLengthSum = points.mapIndexed { index, point ->
        sqrt(
            (point.first - points[(index + 1) % n].first).pow(2) +
                    (point.second - points[(index + 1) % n].second).pow(2)
        )
    }.sum()

    val result = centerLengthSum + arcLengthSum

    // output
    println("%.2f".format(result))
}