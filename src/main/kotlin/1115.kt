/**
 * №1115. Ships
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1115
 *
 * Idea: Using recursion for filling each row with ships.
 * Firstly, we need to fill row by largest ships if possible.
 *
 * This solution gets AC with 0.218s of time and 6 592KB of memory.
 */
data class RowOrder(val row: Int, val order: Int)

fun main() {
    // input
    val nums = readln().split(" ").map { it.toInt() }
    val n = nums[0]
    val m = nums[1]

    val ships = buildList {
        repeat(n) {
            add(readln().toInt())
        }
    }.sorted().reversed().toMutableList()

    val rows = buildList {
        repeat(m) {
            add(RowOrder(readln().toInt(), it))
        }
    }.sortedBy { it.row }.reversed()

    // solution
    val answer = mutableMapOf<RowOrder, Pair<Int, String>>().toSortedMap(
        compareBy { it.order }
    )
    for (row in rows) {
        // try to fill row with ships
        val shipsToRemove = mutableListOf<Int>()
        fillRowWithShips(row.row, ships, shipsToRemove) // always true
        for (ship in shipsToRemove) ships.remove(ship)

        answer.putIfAbsent(row, Pair(shipsToRemove.size, shipsToRemove.joinToString(" ")))
    }


    // output
    for (ans in answer) {
        println(ans.value.first)
        println(ans.value.second)
    }
}

fun fillRowWithShips(row: Int, ships: List<Int>, shipsToRemove: MutableList<Int>): Boolean {
    if (row == 0) return true

    for (ship in ships) {
        if (ship <= row) {
            val updatedShips = ships.toMutableList()
            updatedShips.remove(ship)

            if (fillRowWithShips(row - ship, updatedShips, shipsToRemove)) {
                shipsToRemove.add(ship)
                return true
            }
        }
    }

    return false
}