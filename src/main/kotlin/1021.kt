/**
 * №1021. Sacrament of the Sum
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1021
 *
 * Idea: Use two HashSets. Iterate over one of them,
 * and search (10000 - num) in another set by constant time.
 *
 * This solution gets AC with 0.203s of time and 7 328KB of memory,
 * which is the fastest Kotlin solution at the time it was written
 */

fun main() {
    // input
    val n1 = readln().toInt()
    val set1 = hashSetOf<Int>()
    repeat(n1) { set1.add(readln().toInt()) }

    val n2 = readln().toInt()
    val set2 = hashSetOf<Int>()
    repeat(n2) { set2.add(readln().toInt()) }

    // solution
    for (num in set1) {
        val target = 10000 - num
        if (set2.contains(target)) {
            // output
            println("YES")
            return
        }
    }

    println("NO")
}