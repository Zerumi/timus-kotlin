/**
 * №1196. History Exam
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1196
 *
 * Idea: Use HashSet as a source storage for date comparison.
 *
 * This solution gets AC with 0.906s of time and 30 188KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val sourceList = HashSet<Int>()
    repeat(n) {
        sourceList.add(readln().toInt())
    }

    val k = readln().toInt()
    val targetList = Array(k) { readln().toInt() }

    // solution
    val answer = targetList.count { it in sourceList }

    // output
    println(answer)
}
