/**
 * №2149. Pigeonhole Principle
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2149
 *
 * Idea: There are 4 ideal cases, compare source directions
 * with ideal cases and take minimum of it.
 *
 * This solution gets AC with 0.156s of time and 2 256KB of memory
 */

enum class Directions {
    RIGHT,
    LEFT
}

fun main() {
    // input
    val n = readln().toInt()
    val directionsRaw = readln()

    // solution
    val directions = directionsRaw.filter { it == '>' || it == '<' }  // >...<
        .map { if (it == '>') Directions.RIGHT else Directions.LEFT } //  UwU

    val idealDirections = arrayOf(
        Array(n) { if (it % 2 == 0) Directions.LEFT else Directions.RIGHT },
        Array(n) { if (it % 2 == 0) Directions.RIGHT else Directions.LEFT },
        Array(n) { if (it < n / 2) Directions.LEFT else Directions.RIGHT },
        Array(n) { if (it >= n / 2) Directions.LEFT else Directions.RIGHT }
    )

    val answer =
        idealDirections.map { it.mapIndexed { index, value -> if (directions[index] == value) 0 else 1 }.sum() }
            .minByOrNull { it }!!

    // output
    println(answer)
}