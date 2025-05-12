/**
 * №1370. Magician
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1370
 *
 * Idea: Double "ring list" and pick 10 numbers from position M, which is an answer
 *
 * This solution gets AC with 0.14s of time and 3 296KB of memory
 */

fun main() {
    // input
    val (n, m) = readln().split(' ').map { it.toInt() }
    val ring = List(n) { readln().toInt() }

    // solution
    val newPos = m % n
    val window = ring.plus(ring).drop(newPos).take(10).joinToString("")
    
    // output
    println(window)
}
