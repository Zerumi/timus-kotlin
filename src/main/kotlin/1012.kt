/**
 * №1012. K-based Numbers. Version 2
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1012
 *
 * Idea: DP, idea described below for 10-th based system.
 * Using BigInteger (instead of Int in task 1009)
 * @see 1009.kt
 *
 * This solution gets AC with 0.218s of time and 6 900KB of memory
 */

import java.math.BigInteger

fun main() {
    // 1, 10: 1-9 - 9 numbers
    // 2, 10: 10-99
    // 2, 10: 9 * 10 = 90 - 90 numbers
    // 3, 10: 101-199 + 201-299 + 301-399 + ...
    // 3, 10: 9 * (90 + 9) = 891 numbers
    // 4, 10: 1010-1099 + 1101-1999 + 2010-2099 + 2101-2999 + ...
    // 4, 10: 9 * (891 + 90) = 8829 numbers
    // 5, 10: 10101-10199 + 10201-10299 + ...
    // 5, 10: 9 * (8829 + 891) = 87480 numbers

    // input
    val n = readln().toInt()
    val k = readln().toBigInteger()

    // solution
    val number = Array(n) { BigInteger.ZERO }
    number[0] = k - BigInteger.ONE
    number[1] = k * (k - BigInteger.ONE)

    for (i in 2..< n) {
        number[i] = (k - BigInteger.ONE) * (number[i - 1] + number[i - 2])
    }

    // output
    println(number.last())
}