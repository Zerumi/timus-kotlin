/**
 * №1026. Questions and Answers
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1026
 *
 * Idea: Sort database, print answer for each request.
 *
 * This solution gets AC with 0.265s of time and 8 780KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val db = Array(n) {
        readln().toInt()
    }
    val splitLine = readln() // assert(splitLine == "###")
    val k = readln().toInt()
    val requests = List(k) {
        readln().toInt() - 1
    }

    // solution
    db.sort()

    // output
    for (request in requests) {
        println(db[request])
    }
}