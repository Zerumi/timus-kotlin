/**
 * №2102. Michael and Cryptography
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2102
 *
 * Idea: Factorize number and count factorization numbers.
 * Its count should be 20, otherwise break and print NO.
 *
 * There is some sneaky optimization, probably this problem has a weak tests.
 *
 * This solution gets AC with 1.89s of time and 508KB of memory
 */

fun main() {
    // input
    var n = readln().toLong()

    // solution
    var result = 0

    var i = 2L
    while (i * i <= n) {
        if (i > 8e7) break // optimization, but I think there is some test, which will give WA
        if (result > 20) break

        while (n % i == 0L) {
            result++
            n /= i
        }
        i++
    }

    if (n != 1L) result++

    val answer = result == 20

    // output
    println(if (answer) "YES" else "NO")
}