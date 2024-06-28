/**
 * №1200. Horns and Hoofs
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1200
 *
 * Idea: The formula below. We should maximize function.
 * Also, we should calibrate K from 0 to K and calculate the maximum revenue.
 *
 * This solution gets AC with 0.187s of time and 3 396KB of memory.
 */
import kotlin.math.roundToInt

fun main() {
    // Ax + By - x^2 - y^2 -> max
    // x + y = K

    // -> x + y = K
    // -> x = K - y

    // -> AK - Ay + By - y^2 + 2yK - K^2 - y^2 -> max
    // -> y*(-A+B+2K) - 2y^2 + AK - K^2 -> max
    // -A + B + 2K - 4y = 0

    // y = (-A + B + 2K) / 4
    // x = K - y

    // input
    val ab = readln().split(' ').map { it.toDouble() }
    val a = ab[0]
    val b = ab[1]

    val k = readln().toInt()

    // solution
    var mPrice = Double.MIN_VALUE
    var mX = 0
    var mY = 0

    for (i in 0..k) {
        var y = ((-a + b + 2 * i) / 4).roundToInt()
        var x = i - y

        if (y < 0) {
            y = 0
            x = i
        }

        if (x < 0) {
            x = 0
            y = i
        }

        val price = a * x + b * y - x * x - y * y
        if (mPrice < price) {
            mPrice = price
            mX = x
            mY = y
        }
    }

    // output
    print("$mPrice\n$mX $mY")
}