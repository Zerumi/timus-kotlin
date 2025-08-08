/**
 * №1052. Rabbit Hunt
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1052
 *
 * Idea: Build line and test all the points (O(n^3) solution)
 *
 * This solution gets AC with 0.671s of time and 3 304KB of memory.
 */

import kotlin.math.abs

fun main() {
    // input
    val n = readln().toInt()
    val points = List(n) {
        val string = readln()
        return@List Pair(string.substringBefore(' ').toDouble(), string.substringAfter(' ').toDouble())
    }

    // solution
    val answer =
        points.maxOf { p1 ->
            points.maxOf { p2 ->
                points.count { p3 ->
                    pointOnLine(p1, p2, p3)
                }
            }
        }

    // output
    println(answer)
}

fun pointOnLine(p1: Pair<Double, Double>, p2: Pair<Double, Double>, p3: Pair<Double, Double>): Boolean {
    val x1 = p1.first
    val y1 = p1.second
    val x2 = p2.first
    val y2 = p2.second
    val x = p3.first
    val y = p3.second

    return when {
        x1 == x2 -> x == x1
        p3 == p1 -> true
        p3 == p2 -> true
        else -> (y - y1).fuzzyEquals1052((y2 - y1) / (x2 - x1) * (x - x1))
    }
}

fun Double.fuzzyEquals1052(other: Double): Boolean {
    return (abs(this - other) < 1e-6)
}
