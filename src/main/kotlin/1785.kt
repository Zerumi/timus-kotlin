/**
 * №1785. Lost in Localization
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1785
 *
 * Idea: Kotlin when-expression is beautiful
 *
 * This solution gets AC with 0.125s of time and 536KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()

    // solution
    val localized = when (n) {
        in 1..4     -> "few"
        in 5..9     -> "several"
        in 10..19   -> "pack"
        in 20..49   -> "lots"
        in 50..99   -> "horde"
        in 100..249 -> "throng"
        in 250..499 -> "swarm"
        in 500..999 -> "zounds"
        else -> "legion"
    }

    // output
    println(localized)
}
