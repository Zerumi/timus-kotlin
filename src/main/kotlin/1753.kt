/**
 * №1753. Bookshelf
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1753
 *
 * Idea: Delta from the left border of bookshelf expressed through the function,
 * which we're taking derivative and find maximum of it. Pretty geometry problem.
 * If we've got NaN -> answer is 0; C don't get out from the bookshelf.
 * Parameter L is unnecessary in this problem.
 *
 * Note about function: we need to consider similar right triangles.
 * First one: hypotenuse is H / 2, leg is (answer + t)
 * Second one: legs are t and h, hypotenuse is sqrt(t^2 + h^2)
 * In similar triangles calculate similarity coefficient between hypotenuses
 * and apply it on the legs (answer + t) and t.
 * Similarity coefficient is a constant value (geometry rule)
 *
 * This solution gets AC with 0.203s of time and 3 188KB of memory
 */

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    // input
    val (h, H) = readln().split(' ').map { it.toDouble() }

    // solution
    // C = H / 2
    // ans(t) = t * C / sqrt(t^2 + h^2)
    // ans(t) = t * H / (2 * sqrt(t^2 + h^2)) - t

    // t = 0 ->
    // ans(t) = 0 * H / 2h - 0 = 0

    // t = sqrt(H^2/4 - h^2) ->
    // ans(t) = sqrt(H^2/4 - h^2) * H / (2 * sqrt(H^2/4 - h^2 + h^2) - sqrt(H^2/4 - h^2)
    // ans(t) = sqrt(H^2/4 - h^2) * H / H - sqrt(H^2/4 - h^2)
    // ans(t) = sqrt(H^2/4 - h^2) - sqrt(H^2/4 - h^2) == t - t = 0

    // derivative of ans by t:
    // ans'(t) = Hh^2 / 2 * (t^2 + h^2)^3/2 - 1 = 0

    // t = sqrt(-2^2/3*h^2 + H^2/3*h^4/3) / 2^1/3

    val t = sqrt(-(2.0).pow(2 / 3.0) * h.pow(2) + H.pow(2 / 3.0) * h.pow(4 / 3.0)) / 2.0.pow(1 / 3.0)
    val ans = if (t.isNaN()) 0 else t * H / (2 * sqrt(t.pow(2) + h.pow(2))) - t

    // output
    println(ans)
}