/**
 * №1009. K-based Numbers
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1009
 *
 * Idea: DP, idea described below for 10-th based system
 *
 * This solution gets AC with 0.171s of time and 4 448KB of memory
 */

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
    val k = readln().toInt()

    // solution
    val number = Array(n) { 0 }
    number[0] = k - 1
    number[1] = k * (k - 1)

    for (i in 2..< n) {
        number[i] = (k - 1) * (number[i - 1] + number[i - 2])
    }

    // output
    println(number.last())
}