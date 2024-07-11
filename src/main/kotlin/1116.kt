/**
 * №1116. Piecewise Constant Function
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1116
 *
 * Idea: Iterate from left to right of the functions.
 * There are 6 cases, which needed to be handled.
 *
 * This solution gets AC with 0.328s of time and 10 680KB of memory
 */

fun addToAnswer(answer: MutableList<Int>, start: Int, end: Int, value: Int) {
    if (start != end) {
        answer.add(start)
        answer.add(end)
        answer.add(value)
    }
}

fun main() {
    // input
    val f1 = readln().split(' ').map { it.toInt() }.toTypedArray()
    val f2 = readln().split(' ').map { it.toInt() }.toTypedArray()

    // solution
    val answer = mutableListOf<Int>()

    var pointer1 = 1
    var pointer2 = 1

    while (pointer1 < f1.size && pointer2 < f2.size) {
        val f1start = f1[pointer1]
        val f1end = f1[pointer1 + 1]
        val f2start = f2[pointer2]
        val f2end = f2[pointer2 + 1]

        val f1value = f1[pointer1 + 2]

        // 6 cases:
        // [1s; [2s; 2e); 1e) -> [1s; 2s) is answer, redefine f1 to [2e; 1e), move p2
        // [2s; [1s; 1e); 2e) -> undefined, move p1
        // [1s; [2s; 1e); 2e) -> [1s; 2s) is answer, move p1
        // [2s; [1s; 2e); 1e) -> redefine f1 to [2e; 1e), move p2
        // [1s; 1e) [2s; 2e)  -> [1s; 1e) is answer, move p1
        // [2s; 2e) [1s; 1e)  -> move p2

        if (f2start in f1start..f1end && f2end in f1start..f1end) {
            addToAnswer(answer, f1start, f2start, f1value)
            f1[pointer1] = f2end
            pointer2 += 3
            if (pointer2 == f2.size) {
                addToAnswer(answer, f2end, f1end, f1value)
                pointer1 += 3
            }
        } else if (f1start in f2start..f2end && f1end in f2start..f2end) {
            pointer1 += 3
        } else if (f2start in f1start..f1end && f1end in f2start..f2end) {
            addToAnswer(answer, f1start, f2start, f1value)
            pointer1 += 3
        } else if (f1start in f2start..f2end && f2end in f1start..f1end) {
            f1[pointer1] = f2end
            pointer2 += 3
            if (pointer2 == f2.size) {
                addToAnswer(answer, f2end, f1end, f1value)
                pointer1 += 3
            }
        } else if (f1end <= f2start) {
            addToAnswer(answer, f1start, f1end, f1value)
            pointer1 += 3
        } else if (f2end <= f1start) {
            pointer2 += 3
            if (pointer2 == f2.size) {
                addToAnswer(answer, f1start, f1end, f1value)
                pointer1 += 3
            }
        } else {
            throw RuntimeException("Found uncovered case")
        }
    }

    while (pointer1 < f1.size) {
        addToAnswer(answer, f1[pointer1], f1[pointer1 + 1], f1[pointer1 + 2])
        pointer1 += 3
    }

    // output
    print("${answer.size / 3} ${answer.joinToString(" ")}")
}