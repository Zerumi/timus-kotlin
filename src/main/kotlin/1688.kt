/**
 * №1688. Team.GOV!
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1688
 *
 * Idea: Calculate integer part and remainder of Vanya's restaurant price
 * and validate the condition separately.
 *
 * This solution gets AC with 0.203s of time and 3 416KB of memory
 */

fun main() {
    // input
    val (n, m) = readln().split(' ').map { it.toInt() }
    val restaurants = List(m) {
        readln().toInt()
    }

    // solution
    var sum = 0L
    var remainder = 0L
    var current = 1
    var teamgov = true
    for (restaurant in restaurants) {
        val vanyaPrice = restaurant / 3
        val vanyaPriceRemainder = restaurant % 3
        sum += vanyaPrice
        remainder += vanyaPriceRemainder

        if (sum + remainder / 3 > n ||
            (sum + remainder / 3 == n.toLong() && remainder % 3 > 0)
        ) {
            teamgov = false
            break
        }
        current++
    }

    // output
    if (teamgov) {
        println("Team.GOV!")
    } else {
        println("Free after $current times.")
    }
}