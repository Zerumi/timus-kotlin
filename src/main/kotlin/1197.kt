/**
 * №1197. Lonesome Knight
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1197
 *
 * Idea: Simulate all of 8 of possible positions the knight and check
 * if the knight was on board. Pretty head-on solution, but the compiler optimizes it well!
 *
 * This solution gets AC with 0.093s of time and 464KB of memory
 */

fun validConstraints(a: Char, b: Char) = (a >= 'a') && (a <= 'h') && (b >= '1') && (b <= '8')

fun main() {
    // input
    val n = readln().toInt()

    repeat(n) {
        val pos = readln()

        // solution
        var ans = 0

        val pos1x = pos[0] + 2
        val pos1y = pos[1] + 1

        if (validConstraints(pos1x, pos1y)) ans++

        val pos2x = pos[0] + 2
        val pos2y = pos[1] - 1

        if (validConstraints(pos2x, pos2y)) ans++

        val pos3x = pos[0] + 1
        val pos3y = pos[1] + 2

        if (validConstraints(pos3x, pos3y)) ans++

        val pos4x = pos[0] + 1
        val pos4y = pos[1] - 2

        if (validConstraints(pos4x, pos4y)) ans++

        val pos5x = pos[0] - 1
        val pos5y = pos[1] + 2

        if (validConstraints(pos5x, pos5y)) ans++

        val pos6x = pos[0] - 1
        val pos6y = pos[1] - 2

        if (validConstraints(pos6x, pos6y)) ans++

        val pos7x = pos[0] - 2
        val pos7y = pos[1] + 1

        if (validConstraints(pos7x, pos7y)) ans++

        val pos8x = pos[0] - 2
        val pos8y = pos[1] - 1

        if (validConstraints(pos8x, pos8y)) ans++

        // output
        println(ans)
    }
}