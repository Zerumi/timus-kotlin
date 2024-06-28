/**
 * №1710. Boris, You Are Wrong!
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1710
 *
 * Idea: We should build isosceles triangle inside (or outside) the source, if possible.
 *
 * This solution gets WA on test 44
 */
import kotlin.math.*

class Point(val x: Int, val y: Int) {

    constructor(raw: String) :
            this(raw.split(' ')[0].toInt(), raw.split(' ')[1].toInt())

    override fun toString(): String = "$x $y"
}

class Vector(p1: Point, p2: Point) {
    private val x = p1.x - p2.x
    private val y = p1.y - p2.y
    fun length(): Double = sqrt((x*x + y*y).toDouble())
}

fun angle(v1: Vector, v2: Vector, v3: Vector): Double =
    acos(
        (v1.length().pow(2) + v2.length().pow(2) - v3.length().pow(2))
                / (2 * v1.length() * v2.length())
    )

fun triangleSquare(v1: Vector, v2: Vector, v3: Vector): Double {
    val halvedSideSum = (v1.length() + v2.length() + v3.length()) / 2.0
    return sqrt(
        halvedSideSum *
                (halvedSideSum - v1.length()) *
                (halvedSideSum - v2.length()) *
                (halvedSideSum - v3.length())
    )
}

fun Double.fuzzyEquals(other: Double): Boolean {
    return (abs(this - other) < 1e-10)
}

fun main() {
    // input
    val pointA = Point(readln())
    val pointB = Point(readln())
    val pointC = Point(readln())

    // solution
    val fixedPointA = Point(0, 0)
    val fixedPointB = Point(pointB.x - pointA.x, pointB.y - pointA.y)
    val fixedPointC = Point(pointC.x - pointA.x, pointC.y - pointA.y)

    val sideAB = Vector(fixedPointA, fixedPointB)
    val sideBC = Vector(fixedPointB, fixedPointC)
    val sideAC = Vector(fixedPointA, fixedPointC)

    val angleBAC = angle(sideAB, sideAC, sideBC)
    val angleACB = angle(sideAC, sideBC, sideAB)
    val angleCBA = angle(sideBC, sideAB, sideAC)

    // find h
    val h = 2.0 / sideAC.length() * triangleSquare(sideAB, sideBC, sideAC)
    // tan ACB = h / x
    val x = h / tan(angleACB)
    val subtractVectorLength = 2.0 * x
    val ratio = (sideAC.length() - subtractVectorLength) / sideAC.length()

    if (ratio <= 0.0 || ratio.fuzzyEquals(0.0) || ratio.fuzzyEquals(1.0)) println("YES")
    else {
        println("NO")
        println(fixedPointA)
        println(fixedPointB)
        println("${fixedPointC.x * ratio} ${fixedPointC.y * ratio}")
    }
}