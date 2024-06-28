/**
 * №1293. Eniya
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1293
 *
 * Idea: Calculate 2 * A * B * C. Easiest task by difficulty on Timus.
 *
 * This solution gets AC with 0.125s of time and 3 080KB of memory
 */
fun main() {
    // input
    val nums = readln().split(" ").map { it.toInt() }

    // output
    println(2 * nums[0] * nums[1] * nums[2])
}