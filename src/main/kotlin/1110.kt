/**
 * №1110. Power
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1110
 *
 * Idea: Using BigInteger for power numbers.
 *
 * This solution gets AC with 0.328s of time and 5 900KB of memory.
 */
fun main() {
    val nums = readln().split(' ').map { it.toInt() }

    val n = nums[0]
    val m = nums[1]
    val y = nums[2]

    var found = false

    for (x in 0..<m) {
        val pow = x.toBigInteger().pow(n)
        if (pow.rem(m.toBigInteger()).toInt() == y) {
            print("$x ")
            found = true
        }
    }

    if (!found) print("-1")
}