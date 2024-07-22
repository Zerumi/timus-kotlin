/**
 * №2142. Magic
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2142
 *
 * Idea: Fill red and blue mana for x and y constraints from universal mana.
 * Fill the remaining mana for z constraint and check if overflow occurs.
 *
 * This solution gets AC with 0.171s of time and 3 148KB of memory
 */

fun main() {
    // input
    val (a, b, c) = readln().split(' ').map { it.toLong() }
    val (x, y, z) = readln().split(' ').map { it.toLong() }

    // solution
    val redRemains = a - x
    val blueRemains = b - y

    val universalToRed = if (redRemains < 0) -redRemains else 0
    val universalToBlue = if (blueRemains < 0) -blueRemains else 0

    val universalRemains = c - universalToRed - universalToBlue

    val totalRed = a + universalToRed
    val totalBlue = b + universalToBlue
    val totalRemains =
        (if (redRemains > 0) redRemains else 0) + (if (blueRemains > 0) blueRemains else 0) + (if (universalRemains > 0) universalRemains else 0)

    val answer = totalRed >= x && totalBlue >= y && totalRemains >= z && universalRemains >= 0

    // output
    println(if (answer) "It is a kind of magic" else "There are no miracles in life")
}