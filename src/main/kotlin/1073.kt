/**
 * №1073. Square Country
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1073
 *
 * Idea: According to Lagrange's four-square theorem, max answer is 4,
 * so we just iterate over all possible numbers and the first ones will be minimal.
 * N = 60.000 is too small (√60000 ~= 245), so it is not overwhelmed by the time limit.
 *
 * There might be a faster algorithm, @see https://math.colgate.edu/~integers/sjs15/sjs15.pdf
 *
 * This solution gets AC with 0.125s of time and 508KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()

    // solution
    val result = arrayOf(false, false, false, true)

    for (i in 0..245) {
        for (j in 0..245) {
            for (k in 0..245) {
                for (l in 1..245) {
                    if (i * i + j * j + k * k + l * l == n) {
                        // output
                        println(result.count { it })
                        return
                    }
                }
                result[2] = true
            }
            result[1] = true
        }
        result[0] = true
    }
}