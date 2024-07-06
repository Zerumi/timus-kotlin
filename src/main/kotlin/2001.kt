/**
 * №2001. Mathematicians and Berries
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2001
 *
 * Idea: When mass of berries is 0 (in 2nd test for 2nd mathematician and 3rd test fot 1st mathematician)
 * the weight of basket remains, and we should subtract it from data of first test.
 *
 * This solution gets AC with 0.171s of time and 2 040KB of memory
 */

fun main() {
    // input
    val firstTest = readln()
    val secondTest = readln()
    val thirdTest = readln()

    val a1 = firstTest.substringBefore(' ').toInt()
    val a3 = thirdTest.substringBefore(' ').toInt()

    val b1 = firstTest.substringAfter(' ').toInt()
    val b2 = secondTest.substringAfter(' ').toInt()

    // solution
    val initA = a1 - a3
    val initB = b1 - b2

    // output
    println("$initA $initB")
}