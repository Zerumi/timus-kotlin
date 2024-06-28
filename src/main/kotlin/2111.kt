/**
 * №2111. Plato
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2111
 *
 * Idea: Sort from the lowest price to higher and calculate the answer.
 *
 * This solution gets AC with 0.296s of time and 15 024KB of memory
 */
fun main() {
    // input
    val n = readln().toInt()
    val roads = readln().split(" ").map { it.toInt() }.sorted()

    // solution
    var total = 0L
    for (road in roads) total += road

    var result = 0L

    for (road in roads) {
        result += total * road + (total - road) * road
        total -= road
    }

    // output
    println(result)
}