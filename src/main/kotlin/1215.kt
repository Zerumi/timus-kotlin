/**
 * №1215. Exactness of Projectile Hit
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1215
 *
 * Idea: Calculate point of intersection between each part of the polygon,
 * and take minimum of it. But if area of polygon equals sum of
 * areas of triangles MP1P2, then we hit in polygon and the answer is 0.
 *
 * This solution gets AC with 0.203s of time and 3 572KB of memory
 */

import kotlin.math.*

data class Point1215(val x: Double, val y: Double) {
    operator fun plus(other: Vector1215) = Point1215(x + other.x, y + other.y)
    operator fun times(other: Float) = Point1215(x * other, y * other)
}

data class Vector1215(val p1: Point1215, val p2: Point1215) {
    val x = p2.x - p1.x
    val y = p2.y - p1.y

    operator fun times(other: Vector1215) = x * other.x + y * other.y
    operator fun times(other: Double) = Vector1215(p1, Point1215(p1.x + other * x, p1.y + other * y))

    fun abs() = sqrt(x.pow(2) + y.pow(2))
}

fun triangleSquare(v1: Vector1215, v2: Vector1215, v3: Vector1215): Double {
    val halvedSideSum = (v1.abs() + v2.abs() + v3.abs()) / 2.0
    return sqrt(
        halvedSideSum *
                (halvedSideSum - v1.abs()) *
                (halvedSideSum - v2.abs()) *
                (halvedSideSum - v3.abs())
    )
}

fun Double.fuzzyEquals1215(other: Double) = abs(this - other) < 0.00001

fun main() {
    // input
    val (x0, y0, n) = readln().split(' ').map { it.toDouble() }
    val points = List(n.toInt()) {
        val (x, y) = readln().split(' ').map { it.toDouble() }
        return@List Point1215(x, y)
    }

    // solution
    var minR = Double.MAX_VALUE
    var targetArea = 0.0
    var mArea = 0.0

    val pM = Point1215(x0, y0)

    for (i in points.indices) {
        val p1 = points[i]
        val p2 = points[(i + 1) % points.size]

        val p1p2 = Vector1215(p1, p2)
        val p1pM = Vector1215(p1, pM)

        val rawRatio = p1p2 * p1pM / p1p2.abs().pow(2)
        val ratio = if (rawRatio !in 0.0..1.0) {
            if (rawRatio < 0) 0.0 else 1.0
        } else rawRatio

        val mP = p1 + p1p2 * ratio

        val targetVector = Vector1215(pM, mP)
        val length = targetVector.abs()

        minR = min(minR, length)

        val p2pM = Vector1215(p2, pM)
        mArea += triangleSquare(p1p2, p1pM, p2pM)
        targetArea += (p1.x + p2.x) * (p1.y - p2.y)
    }

    targetArea /= 2.0f

    if (targetArea.absoluteValue.fuzzyEquals1215(mArea)) minR = 0.0

    // output
    println("%.3f".format(2 * minR))
}