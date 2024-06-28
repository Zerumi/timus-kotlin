/**
 * №1607. Taxi
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1607
 *
 * Idea: Search answer with binary search.
 *
 * This solution gets AC with 0.156s of time and 2 052KB of memory
 */
fun main() {
    // input
    val numbers = readln().split(' ')
    val a = numbers[0].toInt()
    val b = numbers[1].toInt()
    val c = numbers[2].toInt()
    val d = numbers[3].toInt()

    // solution
    var leftBorder = 0
    var rightBorder = 10000
    while (leftBorder < rightBorder - 1) {
        val target = (leftBorder + rightBorder) / 2

        val petyaPrice = a + b * target
        val taxiDriverPrice = c - d * target

        if (taxiDriverPrice > petyaPrice) {
            leftBorder = target
        } else {
            rightBorder = target
        }
    }

    // output
    val rightBorderPetyaPrice = a + b * rightBorder
    val rightBorderTaxiPrice = c - d * rightBorder
    val leftBorderPetyaPrice = a + b * leftBorder
    val leftBorderTaxiPrice = c - d * leftBorder

    if (rightBorderPetyaPrice > leftBorderTaxiPrice) {
        // we should choose left border
        if (leftBorderPetyaPrice > leftBorderTaxiPrice) println(leftBorderPetyaPrice)
        else println(leftBorderTaxiPrice)
    } else {
        // we should choose right border
        if (rightBorderTaxiPrice > rightBorderPetyaPrice) println(rightBorderTaxiPrice)
        println(rightBorderPetyaPrice)
    }
}
