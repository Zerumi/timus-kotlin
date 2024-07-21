/**
 * №1094. E-screen
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1094
 *
 * Idea: Build a display and simulate control over it with 1 mutable pointer.
 *
 * This solution gets AC with 0.14s of time and 568KB of memory
 */

fun main() {
    // input
    val program = readln()

    // solution
    val displaySize = 80

    val display = CharArray(displaySize) { ' ' }

    var pointer = 0

    for (symbol in program) {
        if (symbol == '<') pointer -= 1
        if (symbol == '>') pointer += 1

        if (!(symbol == '>' || symbol == '<')) display[pointer++] = symbol

        if (pointer < 0 || pointer >= displaySize) pointer = 0
    }

    println(String(display)) // use joinToString - AC 0.171s / 5 608KB
}

// >><<<Look for clothes at the <<<<<<<<<<<<<<<second floor. <<<<<<<Fresh pizza and <<<<<<<<<<<<<<<<hamburger at a shop right to <<<<<<<<<<<<<the entrance. Call <<<<<<<<<< 123<-456<-8790 <<<<<<<<<<<<<<<<to order <<<<<<<<<<<<<<<<<computers< and office<<<<<<< chairs.