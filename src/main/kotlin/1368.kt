/**
 * №1368. Goat in the Garden 3
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1368
 *
 * Idea: The most optimal area is square (sqrt(k) x sqrt(k)),
 * rotated by 45 degrees. So we should build it by adding to each
 * square in the current borderline new square in all of 4 directions.
 * Remove duplicates, which we faced in the current and previous
 * borderline, and built border becomes current borderline,
 * and the last one becomes previous. Do until total area < k
 *
 * After we build full square, we should remove extra squares for
 * match condition: total area == k. Attention: removing from start
 * gives not-optimal square, something like this (k = 6, wa = 10):
 *    ~
 *  ~~x~
 * ~xxxx~
 *  ~~x~
 *    ~
 * , but more optimal solution there would be (k = 6, ans = 9):
 *   ~
 *  ~x~
 * ~xxx~
 *  ~xx~
 *   ~~
 * so we should prevent this, and remove in reverse order:
 * from the last borderline element.
 *
 * For remembering order, define the next iterator, and linked sets,
 * so it supports order in data structure. After finishing
 * modifying a set, sort elements by order and print it. It's
 * a very time-cost operation due to not very efficient usage of sets.
 * All of my optimizations aimed firstly (and only) for the hash function.
 * Honestly, I have instantly written this code for correct ordering
 * and forget how it works, rly…
 *
 * This solution gets AC with 0.968s of time and 10 936KB of memory
 */

data class Point1368(val x: Int, val y: Int, val order: Int) : Comparable<Point1368> {
    operator fun plus(other: Point1368) = Point1368(x + other.x, y + other.y, other.order)

    override fun equals(other: Any?): Boolean = if (other is Point1368)
        other.x == x && other.y == y else false

    override fun hashCode(): Int {
        var hashCode: Int = 0 xor x.hashCode()
        hashCode = (hashCode * 397) xor y.hashCode()
        return hashCode
    } // fast 2d-point hash function, because tle #28 with java Objects.hash(...)

    fun withOrder(order: Int) = Point1368(x, y, order)

    override fun compareTo(other: Point1368): Int = if (order == other.order) 0 else order.compareTo(other.order)
}

fun main() {
    // input
    val k = readln().toInt()

    // solution
    val directions = arrayOf(
        Point1368(0, -1, -1),
        Point1368(1, 0, -1),
        Point1368(0, 1, -1),
        Point1368(-1, 0, -1)
    )

    var total = 1
    var next = 2
    var areaToAdd = mutableSetOf<Point1368>()
    var area = mutableSetOf(Point1368(0, 0, 1))
    var prev = mutableSetOf<Point1368>()

    while (total < k) {
        for (a in area) {
            var startIndex = 0
            for (di in directions.indices) {
                if (a + directions[di] in prev) {
                    startIndex = di
                    break
                }
            }

            repeat(4) {
                areaToAdd.add(a + directions[startIndex].withOrder(next++))
                startIndex = ++startIndex % 4
            }
        }
        areaToAdd.removeAll(area)
        areaToAdd.removeAll(prev)
        total += areaToAdd.size
        prev = area
        area = areaToAdd
        areaToAdd = mutableSetOf()
    }

    val border = mutableSetOf<Point1368>()

    while (total > k) {
        border.add(area.last())
        area.remove(area.last())
        total--
    }

    for (a in area) {
        var startIndex = 0
        for (di in directions.indices) {
            if (a + directions[di] in prev) {
                startIndex = di
                break
            }
        }

        repeat(4) {
            border.add(a + directions[startIndex].withOrder(next++))
            startIndex = ++startIndex % 4
        }
    }

    border.removeAll(prev)

    // output
    println(border.size)
    border.sorted().forEach { println("${it.x} ${it.y}") }
}