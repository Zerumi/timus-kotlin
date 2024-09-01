/**
 * №1910. Titan Ruins: Hidden Entrance
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1910
 *
 * Idea: Fold the list (size will be reduced by 2) and find the maximum in it.
 *
 * This solution gets AC with 0.187s of time and 7 024KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val wall = readln().split(' ').map { it.toInt() }

    // solution
    val power = (1..<wall.lastIndex).map { wall[it - 1] + wall[it] + wall[it + 1] }
    val (max, position) = listOf(power.max(), power.indexOf(power.max()) + 2)

    // output
    println("$max $position")
}