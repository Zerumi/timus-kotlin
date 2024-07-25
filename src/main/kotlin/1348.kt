/**
 * №1348. Goat in the Garden 2
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1348
 *
 * Idea: Answer is distance between point C and line AB (the same idea was in task 1215).
 * For capture all line, we should calculate maximum of distance AC and BC.
 *
 * This solution gets AC with 0.203s of time and 4 296KB of memory
 */

import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

private operator fun <E> List<E>.component6() = get(5)
private operator fun <E> List<E>.component7() = get(6)

data class Point1348(val x: Double, val y: Double) {
    operator fun plus(other: Vector1348) = Point1348(x + other.x, y + other.y)
    operator fun times(other: Float) = Point1348(x * other, y * other)
}

data class Vector1348(val p1: Point1348, val p2: Point1348) {
    val x = p2.x - p1.x
    val y = p2.y - p1.y

    operator fun times(other: Vector1348) = x * other.x + y * other.y
    operator fun times(other: Double) = Vector1348(p1, Point1348(p1.x + other * x, p1.y + other * y))

    fun abs() = sqrt(x.pow(2) + y.pow(2))
}

fun main() {
    // input
    val (aX, aY, bX, bY, cX, cY, l) = generateSequence { readlnOrNull() }
        .takeWhile { true }
        .joinToString(" ")
        .split(' ')
        .map { it.toDouble() }

    val pointA = Point1348(aX, aY)
    val pointB = Point1348(bX, bY)
    val pointC = Point1348(cX, cY)

    val vectorAB = Vector1348(pointA, pointB)
    val vectorAC = Vector1348(pointA, pointC)

    val rawRatio = vectorAB * vectorAC / vectorAB.abs().pow(2)
    val ratio = if (rawRatio !in 0.0..1.0) {
        if (rawRatio < 0) 0.0 else 1.0
    } else rawRatio

    val mP = pointA + vectorAB * ratio

    val targetVector = Vector1348(pointC, mP)
    val minimalLength = targetVector.abs()

    val acLength = vectorAC.abs()
    val bcLength = Vector1348(pointB, pointC).abs()
    val totalLength = max(acLength, bcLength)

    // output
    println(max(0.0, minimalLength - l))
    println(max(0.0, totalLength - l))
}