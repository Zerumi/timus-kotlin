/**
 * №1000. A+B Problem
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1000
 *
 * Idea: Calculate A + B. Solution taken from tutorial.
 *
 * This solution gets AC with 0.14s of time and 1 972KB of memory
 */

fun main() {
    val nums = readln().split(' ')
    val a = nums[0].toInt()
    val b = nums[1].toInt()

    print(a + b)
}

/*
 * Note: another solution
 *
 * fun main(args: Array<String>) =
 *     print(readln().split(' ').map(String::toInt).sum())
 *
 * gets AC with 0.171s of time and 3 052 KB of memory for some reason I don't know
 */