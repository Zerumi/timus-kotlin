/**
 * №1601. AntiCAPS
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1601
 *
 * Idea: Lowercase all chars and use a boolean flag,
 * after which the next char should be uppercase.
 *
 * This solution gets AC with 0.203s of time and 2 644KB of memory
 */
fun main() {
    // input
    var source = readln() + "\n"
    while (true) source = source.plus((readlnOrNull() ?: break) + "\n")

    // solution
    var prevSentenceEnd = true
    for (char in source) {
        if (prevSentenceEnd) {
            print(char.uppercaseChar())
            if (char.isLetter()) prevSentenceEnd = false
        } else
            print(char.lowercaseChar())
        if (char == '!' || char == '?' || char == '.')
            prevSentenceEnd = true
    }
}
