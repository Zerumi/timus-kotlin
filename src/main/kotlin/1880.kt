/**
 * №1880. Psych Up's Eigenvalues
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1880
 *
 * Idea: Iterate over three arrays and find the maximum on each iteration.
 * If some value is lower than the maximum, it's not an eigenvalue, skip it.
 * If all values are equal to the maximum, we found eigenvalue,
 * move pointer of every array by 1.
 *
 * This solution gets AC with 0.25s of time and 5 676KB of memory
 */

import kotlin.math.max

fun main() {
    // input
    val a1 = readln().toInt()
    val arr1 = readln().split(' ').map { it.toInt() }
    val a2 = readln().toInt()
    val arr2 = readln().split(' ').map { it.toInt() }
    val a3 = readln().toInt()
    val arr3 = readln().split(' ').map { it.toInt() }

    // solution
    var answer = 0

    var pointer1 = 0
    var pointer2 = 0
    var pointer3 = 0

    while (pointer1 != a1 && pointer2 != a2 && pointer3 != a3) {
        val e1 = arr1[pointer1]
        val e2 = arr2[pointer2]
        val e3 = arr3[pointer3]

        val max = max(e1, max(e2, e3))
        if (e1 == max && e2 == max && e3 == max) {
            answer += 1
            pointer1++
            pointer2++
            pointer3++
        }

        if (e1 < max) {
            pointer1++
        }

        if (e2 < max) {
            pointer2++
        }

        if (e3 < max) {
            pointer3++
        }
    }

    // output
    println(answer)
}