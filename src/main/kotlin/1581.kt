/**
 * №1581. Teamwork
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1581
 *
 * Idea: Iterate over the sequence, remember prev element,
 * and compare it with current with increasing or resetting counter.
 *
 * This solution gets AC with 0.171s of time and 3 396KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val sequence = readln().split(' ').map { it.toInt() }

    // solution
    val resultSequence = mutableListOf<Int>()

    var currentNum = sequence.first()
    var counter = 1
    for (num in sequence.drop(1)) {
        if (num == currentNum) counter++
        else {
            resultSequence.add(counter)
            resultSequence.add(currentNum)

            currentNum = num
            counter = 1
        }
    }

    resultSequence.add(counter)
    resultSequence.add(currentNum)

    // output
    println(resultSequence.joinToString(" "))
}