/**
 * №1086. Cryptography
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1086
 *
 * Idea: Using Eratosthenes sieve for building a sequence of prime numbers.
 *
 * This solution gets AC with 0.25s of time and 12 072KB of memory.
 */

fun sieve(n: Int): List<Int> {
    val a = Array(n + 1) { it != 0 && it != 1 }
    var i = 2
    while (i * i <= n) {
        if (a[i]) {
            var j = i * i
            while (j <= n) {
                a[j] = false
                j += i
            }
        }
        i++
    }

    return a.mapIndexed { index, element -> Pair(index, element) }.filter { it.second }.map { it.first }
}

const val N = 163901
// how it was found:
/*
for (n in 1..Int.MAX_VALUE step 100) {
    println("${sieve(n).size} // $n")
    if (sieve(n).size >= 15000) {
        println(n)
        exitProcess(0)
    }
}
*/

fun main() {
    // input
    val k = readln().toInt()

    // solution
    val listOfSimpleNumbers = sieve(N)
    for (i in 1..k) {
        val n = readln().toInt()
        // output
        println(listOfSimpleNumbers[n - 1])
    }
}