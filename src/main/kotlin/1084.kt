/**
 * №1084. Goat in the Garden
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1084
 *
 * Idea: Answer may be an area of the circle, or area of the square.
 * Or may be infliction of circle and square. It's calculating by
 * taking 4 times of sum of area of triangle and circle part.
 *
 * This solution gets AC with 0.187s of time and 3 512KB of memory
 */

import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sqrt

data class Point2D(var x: Double, var y: Double)

data class Vector2D(val p1: Point2D, val p2: Point2D) {
    private val x = p1.x - p2.x
    private val y = p1.y - p2.y
    fun length(): Double = sqrt((x * x + y * y))
}

fun main() {
    // input
    val (a, r) = readln().split(' ').map { it.toDouble() }

    // solution
    val ans: Double
    if (r <= a / 2.0) {
        ans = r.pow(2) * PI
    } else {
        val diag = (a / 2.0) * sqrt(2.0)
        if (r >= diag) {
            ans = a.pow(2)
        } else {
            val pointA = Point2D(0.0, 0.0)
            val pointB = Point2D(
                sqrt(r * r - a * a / 4.0),
                a / 2.0,
            )
            val pointC = Point2D(
                a / 2.0,
                sqrt(r * r - a * a / 4.0),
            )
            val pointD = Point2D(
                -sqrt(r * r - a * a / 4.0),
                a / 2.0,
            )

            val sideAB = Vector2D(pointA, pointB).length()

            val sideBC = Vector2D(pointB, pointC).length()
            val sideAC = Vector2D(pointA, pointC).length()

            val angleBAC = acos((sideAB.pow(2) + sideAC.pow(2) - sideBC.pow(2)) / (2.0 * sideAB * sideAC))

            val area1 = r.pow(2) / 2.0 * angleBAC

            val sideAD = Vector2D(pointA, pointD).length()
            val sideBD = Vector2D(pointB, pointD).length()

            val triangleABDHalvedSideSum = (sideAB + sideAD + sideBD) / 2.0

            val area2 = sqrt(triangleABDHalvedSideSum *
                        (triangleABDHalvedSideSum - sideAB) *
                        (triangleABDHalvedSideSum - sideAD) *
                        (triangleABDHalvedSideSum - sideBD))

            ans = 4 * (area1 + area2)
        }
    }

    // output
    println("%.3f".format(ans))
}