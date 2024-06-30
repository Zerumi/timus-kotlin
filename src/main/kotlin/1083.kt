/**
 * №1083. Factorials!!!
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1083
 *
 * Idea: Use for loop for calculate factorial by definition. Not very efficient
 *
 * This solution gets AC with 0.156s of time and 2 072KB of memory
 */

fun main() {
    // input
    val (n, k) = readln().split(" ")

    val intN = n.toInt()
    val countK = k.length

    // solution
    var factN = intN
    var multiplier = intN
    while (multiplier > countK) {
        multiplier -= countK
        factN *= multiplier
    }

    // output
    println(factN)
}