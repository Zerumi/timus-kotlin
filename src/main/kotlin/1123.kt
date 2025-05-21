/**
 * №1123. Salary
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1123
 *
 * Idea: In general - take the first half of the number and reverse it.
 *
 * There are 2 cases:
 * Even length: 12345678 -> 1234
 * Odd length: 123456789 -> 1234(5)
 *
 * Compare halves between themselves. If we can't just reverse first half, for example:
 * 123000 -> 123321
 * 123400 -> 123321!!! is lower than 123400, is not an answer,
 * but then we should add "1" to the half and reverse the result
 *
 * 123400 -> 123 + 1 = 124 -> 124421
 *
 * For odd length:
 * 1234900 -> 1234 + 1 -> 1235321
 * 8999999 -> 8999 + 1 -> 9000009
 *
 * This solution gets AC with 0.14s of time and 2 372 of memory.
 */

fun main() {
    // input
    val input = readln()

    // solution
    val palindrome = if (input.length % 2 == 0) {
        // 1990 -> 1991
        // 1999 -> 2002
        val firstHalf = input.take(input.length / 2)
        val secondHalf = input.drop(input.length / 2)

        if (secondHalf > firstHalf.reversed()) {
            val ninesFromFirstHalf = firstHalf.reversed().takeWhile { it == '9' }.replace('9', '0')
            val otherFirstHalf = firstHalf.reversed().drop(ninesFromFirstHalf.length).replaceFirstChar { it + 1 }
            val updatedHalf = (ninesFromFirstHalf + otherFirstHalf)
            updatedHalf.reversed() + updatedHalf
        } else {
            firstHalf + firstHalf.reversed()
        }
    } else {
        // 19999 -> 20002
        // 19899 -> 19991
        // 19890 -> 19891
        val firstHalf = input.take(input.length / 2)
        val middleChar = input[input.length / 2]
        val secondHalf = input.drop(input.length / 2 + 1)

        if (secondHalf > firstHalf.reversed()) {
            if (middleChar == '9') {
                val ninesFromFirstHalf = firstHalf.reversed().takeWhile { it == '9' }.replace('9', '0')
                val otherFirstHalf = firstHalf.reversed().drop(ninesFromFirstHalf.length).replaceFirstChar { it + 1 }
                val updatedHalf = (ninesFromFirstHalf + otherFirstHalf)
                updatedHalf.reversed() + "0" + updatedHalf
            } else {
                firstHalf + (middleChar + 1) + firstHalf.reversed()
            }
        } else {
            firstHalf + middleChar + firstHalf.reversed()
        }
    }

    // output
    println(palindrome)
}
