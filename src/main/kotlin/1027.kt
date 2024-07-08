/**
 * №1027. D++ Again
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1027
 *
 * Idea: Calculate nesting level in arithmetic expression.
 * If it becomes negative, or we faced with non-whitelist character in expression,
 * abort validation with fail. Also, at the end of the checking, if program
 * still valid, additionally checking if we missed comment close or end of arithmetic expression.
 *
 * This solution gets AC with 0.203s of time and 3 128KB of memory
 */

fun main() {
    // input
    val str = generateSequence { readlnOrNull() }.takeWhile { true }.joinToString("\n") { it }

    // solution
    var validProgram = true

    var nestingLevel = 0
    var inComment = false
    var i = 0
    while (i < str.length) {
        if (!validProgram) break

        if (inComment) {
            if (i + 1 != str.length /* RE #7 */ && str[i] == '*' && str[i + 1] == ')') {
                inComment = false
                i += 2
                continue
            }
        } else {
            if (i + 1 != str.length /* RE #7 */ && str[i] == '(' && str[i + 1] == '*') {
                inComment = true
                i += 2
                continue
            }

            if (str[i] == '(') nestingLevel++
            if (str[i] == ')') nestingLevel--

            if (nestingLevel < 0) validProgram = false

            if (nestingLevel > 0) {
                if (str[i] !in "=+-*/0123456789)(\n") {
                    validProgram = false
                }
            }
        }

        i++
    }

    if (validProgram) {
        validProgram = !inComment && nestingLevel == 0
    }

    // output
    println(if (validProgram) "YES" else "NO")
}