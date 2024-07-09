/**
 * №1014. Product of Digits
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1014
 *
 * Idea: Factorize N. If factorization contains number > 9 - answer didn't exist.
 * Otherwise, reduce amount of numbers: build as much as possible 9s, 8s, 6s and 4s.
 * Numbers 7 and 5 are prime, so we just put it in the answer.
 * Numbers 3 and 2 are important for us, because:
 * 3 * 3 = 9
 * 2 ^ 3 = 8
 * 3 * 2 = 6
 * 2 * 2 = 4
 * Remaining 2 and 3 (not more than 1) put in the answer.
 *
 * Build number in ascending order of digits: 23456789
 *
 * There are some edge case: 0 -> 10; 1-> 1.
 *
 * This solution gets AC with 0.218s of time and 4 116KB of memory
 */

fun factorize(num: Int): MutableList<Int> {
    val result = mutableListOf<Int>()
    var n = num

    var i = 2
    while (i * i <= n) {
        while (n % i == 0) {
            result.add(i)
            n /= i
        }
        i++
    }

    if (n != 1) result.add(n)
    if (num == 1) result.add(1)

    return result
}

fun main() {
    // input
    val n = readln().toInt()

    // solution
    val factorization = factorize(n)

    if (factorization.last() > 9) {
        println(-1)
        return
    }

    if (factorization.first() == 0) {
        println(10)
        return
    }

    val countMap = factorization.groupingBy { it }.eachCount()

    val answerCount = mutableMapOf(
        9 to 0,
        8 to 0,
        7 to 0,
        6 to 0,
        5 to 0,
        4 to 0,
        3 to 0,
        2 to 0,
        1 to 0,
    )

    answerCount[9] = (countMap[3] ?: 0) / 2
    val threeReminder = (countMap[3] ?: 0) % 2

    answerCount[8] = (countMap[2] ?: 0) / 3
    val twoReminder = (countMap[2] ?: 0) % 3

    answerCount[7] = countMap[7] ?: 0
    answerCount[6] = if (threeReminder == 1 && twoReminder >= 1) 1 else 0
    answerCount[5] = countMap[5] ?: 0
    answerCount[4] = if (answerCount[6] == 0 && twoReminder == 2) 1 else 0
    answerCount[3] = if (answerCount[6] == 0) threeReminder else 0
    answerCount[2] = if (answerCount[6] == 1) twoReminder - 1 else if (answerCount[4] == 1) 0 else twoReminder
    answerCount[1] = countMap[1] ?: 0

    val answer = mutableListOf<Int>()
    for (count in answerCount) {
        repeat(count.value) { answer.add(count.key) }
    }
    answer.reverse()

    // output
    println(answer.joinToString(""))
}