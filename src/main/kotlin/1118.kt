/**
 * №1118. Nontrivial Numbers
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1118
 *
 * Idea: Search the highest prime number in sequence.
 * Otherwise, calculate trivia by formula and find minimum.
 * There are edge case: 1 is the most non-trivial number (trivia = 0)
 *
 * This solution gets AC with 0.234s of time and 11 648KB of memory.
 */
import kotlin.system.exitProcess

fun factorizeUnique(n: Int): List<Int> {
    val result = mutableSetOf(1)

    var i = 2
    while (i * i <= n) {
        if (n % i == 0) {
            result.add(i)
            result.add(n / i)
        }
        i++
    }

    return result.toList()
}

fun eSieve(n: Int): Array<Boolean> {
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

    return a
}

fun main() {
    // input
    val (start, end) = readln().split(' ').map { it.toInt() }

    // solution
    if (start == 1) {
        println(start)
        exitProcess(0)
    }

    var minTrivia = Pair(Double.MAX_VALUE, Int.MAX_VALUE)

    val sieve = eSieve(end)
    var sequenceContainsPrimeNumber = false

    for (i in end downTo start) {
        if (sieve[i]) {
            minTrivia = Pair(Double.NaN, i)
            sequenceContainsPrimeNumber = true
            break
        }
    }

    if (!sequenceContainsPrimeNumber) {
        // no prime numbers
        for (i in start..end) {
            val trivia = factorizeUnique(i).sum() / i.toDouble()
            if (minTrivia.first > trivia) {
                minTrivia = Pair(trivia, i)
            }
        }
    }

    // output
    println(minTrivia.second)
}