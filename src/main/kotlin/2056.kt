/**
 * №2056. Scholarship
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2056
 *
 * Idea: Throw out scholarship if input contains 3. Otherwise, calculating average.
 *
 * This solution gets AC with 0.109s of time and 528KB of memory
 */
fun main() {
    val n = readln().toInt()

    var sum = 0

    repeat(n) {
        val mark = readln().toInt()

        if (mark == 3) {
            println("None")
            return
        }

        sum += mark
    }

    val avg = sum / n.toDouble()

    if (avg == 5.0)
        println("Named")
    else if (avg >= 4.5)
        println("High")
    else
        println("Common")
}