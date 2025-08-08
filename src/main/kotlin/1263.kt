/**
 * №1263. Elections
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1263
 *
 * Idea: Group votes and calculate average of them.
 * Don't forget to associate with candidates which have no votes in list
 *
 * This solution gets AC with 0.453s of time and 9 396KB of memory
 */

fun main() {
    // input
    val (n, m) = readln().split(' ').map { it.toInt() }
    val votes = List(m) {
        readln().toInt()
    }

    // solution
    val votesPercentage = votes.groupingBy { it }.eachCount()
        .mapValues { it.value.toDouble() / m * 100 }

    val answer = (1..n).associateWith {
        votesPercentage[it] ?: 0.0
    }


    // output
    answer.forEach { println("${String.format("%.2f", it.value)}%") }
}
