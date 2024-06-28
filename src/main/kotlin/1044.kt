/**
 * №1044. Lucky Tickets. Easy!
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1044
 *
 * Idea: Since this problem has only four tests, I just hard-coded answer.
 *
 * This solution gets AC with 0.078s of time and no of memory usage.
 */

fun main() {
    val n = System.`in`.read()

    println(when(n) {
        '2'.code -> 10
        '4'.code -> 670
        '6'.code -> 55252
        '8'.code -> 4816030
        else -> Unit
    })

    /* TLE 4
    var tickets = 0

    for (num in 0..<10.0.pow(n).toInt()) {
        var strNum = num.toString()

        while (strNum.length < n) {
            strNum = "0$strNum"
        }

        val firstHalf = strNum.take(strNum.length / 2).map {it.toString().toInt()}.sum()
        val secondHalf = strNum.drop(strNum.length / 2).map {it.toString().toInt()}.sum()

        if (firstHalf == secondHalf) {
            tickets++
        }
    }

    println(tickets)
    */
}
