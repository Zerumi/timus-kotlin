/**
 * №1427. SMS
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1427
 *
 * Idea: Search for non-letter chars. If it exists, split messages by lower count.
 * In any other case, split messages by normal count.
 *
 * This solution gets AC with 0.218s of time and 2 960KB of memory
 */
fun main() {
    // input
    val firstStr = readln().split(' ')
    val secondStr = readln()

    val n = firstStr[0].toInt()
    val m = firstStr[1].toInt()

    // solution
    var ans = 0
    var chars = 0
    var foundNonStandardChar = false

    for (char in secondStr) {
        chars++
        if (!(char.isLetter() || char.isWhitespace())) {
            foundNonStandardChar = true
        }

        if (foundNonStandardChar && chars > n) {
            ans++
            chars = 1
        }

        if (chars == m || foundNonStandardChar && chars == n) {
            ans++
            foundNonStandardChar = false
            chars = 0
        }
    }

    if (chars > 0) ans++

    // output
    println(ans)
}
