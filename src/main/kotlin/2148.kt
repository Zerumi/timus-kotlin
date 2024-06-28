/**
 * №2148. Insane Shot
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2148
 *
 * Idea: Get points on circle from player and enemy,
 * build center point between it and project it on circle.
 *
 * This solution gets AC with 0.25s of time and 3 264KB of memory
 */
import kotlin.math.sqrt

class Point2(val x: Double, val y: Double) {

    constructor(raw: String) :
            this(raw.split(' ')[0].toDouble(), raw.split(' ')[1].toDouble())

    override fun toString(): String = "$x $y"
}

class Vector2(val p1: Point2, val p2: Point2) {
    val x = p1.x - p2.x
    val y = p1.y - p2.y
    fun length(): Double = sqrt((x * x + y * y))
}

fun getVector(source: Vector2, subtractLength: Double): Vector2 {
    val ratio = (source.length() - subtractLength) / source.length()
    val newX = source.x * ratio
    val newY = source.y * ratio
    return Vector2(source.p1, Point2(source.p1.x - newX, source.p1.y - newY))
}

fun main() {
    // input
    val cylinder = readln().split(' ').map { it.toDouble() }
    val pointP = Point2(readln())
    val pointE = Point2(readln())

    // solution

    val pointO = Point2(cylinder[0], cylinder[1])
    val r = cylinder[2]

    val vectorOP = Vector2(pointO, pointP)
    val vectorOE = Vector2(pointO, pointE)
    // check existence

    val vectorPE = Vector2(pointP, pointE)
    val halvedVectorPE = getVector(vectorPE, vectorPE.length() / 2)

    val pointM = halvedVectorPE.p2
    val vectorOM = Vector2(pointO, pointM)

    // if the path exists, calculate it
    val vectorOA = getVector(vectorOP, vectorOP.length() - r)
    val vectorOB = getVector(vectorOE, vectorOE.length() - r)

    val vectorAB = Vector2(vectorOA.p2, vectorOB.p2)
    val vectorAD = getVector(vectorAB, vectorAB.length() / 2)

    val vectorOD = Vector2(pointO, vectorAD.p2)

    val vectorOC = getVector(vectorOD, vectorOD.length() - r)

    // output
    if (vectorOM.length() <= r)
        println("No way")
    else
        println(vectorOC.p2)
}