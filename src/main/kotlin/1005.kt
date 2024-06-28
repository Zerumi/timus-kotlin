/**
 * №1005. Stone Pile
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1005
 *
 * Idea: NP-problem with brute-force piles.
 *
 * This solution gets TLE on the third test
 */

import java.util.Collections.swap
import kotlin.math.abs
import kotlin.math.min

fun main() {
    // input
    val n = readln().toInt()
    val stones = readln().split(' ').map { it.toInt() }.toMutableList()

    // solution
    val res = buildHeaps(stones, 0, n - 1)

    // output
    println(res)
}

fun buildHeaps(stones: MutableList<Int>, i: Int, n: Int) : Int {
    var minRes = Int.MAX_VALUE

    var j: Int
    if (i == n)
        minRes = min(minRes, diff(stones))
    else {
        j = i
        while (j <= n) {
            swap(stones, i, j)
            minRes = min(minRes, buildHeaps(stones, i + 1, n))
            swap(stones, i, j)
            j++
        }
    }

    return minRes
}

fun diff(stones: List<Int>) : Int {
    var res = Int.MAX_VALUE
    for (i in stones.indices) {
        val firstHeap = stones.take(i).sum()
        val secondHeap = stones.drop(i).sum()
        res = min(res, abs(secondHeap - firstHeap))
    }
    return res
}