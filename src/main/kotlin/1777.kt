/**
 * №1777. Anindilyakwa
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1777
 *
 * Idea: Sort source array and build the difference array:
 * Array: 11 5 9
 *
 * Sorted: 11 9 5
 * Differences: 2 3
 *
 * (11 - 9 = 2; 9 - 5 = 3)
 * (11 - 5 is not possibly minimal difference, so we don't interested in this)
 *
 * On each iteration search minimum in the array of differences,
 * and add it in the sorted array:
 *
 * Min in [2, 3] is 2
 * Add in array: 11 9 5 2
 * Sort with O(n) (insertion sort with 1 element): 11 9 5 2
 * Rebuild differences: 2 3 -> 2 3 3 (see example below)
 *
 * Repeat until zero isn't exists in the array of differences.
 *
 * Another example:
 *
 * 20 10 0 (not actually correct, because input should be >1)
 * Differences: 10 10
 * Min is 10
 * Add in array: 20 10 0 10
 * Sort: 20 10 10 0
 * Rebuild differences: 10 ~~10~~ -> 10 x -> 10 0 10
 * (we've destroyed difference between 1-st and 2-nd element, because it was invalidated
 * (we've inserted 10 at 2-nd index), and add new differences between 1-st and 2-nd elements
 * and 2-nd and 3-rd elements. Now all arrays are valid, and we've done it just by linear time.)
 *
 * Honestly, I don't know why this solution hasn't got TLE.
 *
 * This solution gets AC with 0.25s of time and 7 172KB of memory
 */
fun main() {
    // input
    val heaps = readln().split(' ').map { it.toULong() }.sortedDescending().toMutableList()

    // solution
    val differences = mutableListOf(heaps[0] - heaps[1], heaps[1] - heaps[2])

    var count = 0
    var containsZero = differences.contains(0UL)

    while (!containsZero) {
        val minDiff = differences.minOrNull()!!
        heaps.add(minDiff)

        var minDiffIndex = heaps.size - 1

        // insertion sorting
        while (heaps[minDiffIndex] > heaps[minDiffIndex - 1]) {
            val temp = heaps[minDiffIndex]
            heaps[minDiffIndex] = heaps[minDiffIndex - 1]
            heaps[minDiffIndex - 1] = temp
            minDiffIndex--
        }

        // rebuild differences
        if (minDiffIndex == differences.size + 1) {
            differences.add(heaps[minDiffIndex - 1] - heaps[minDiffIndex])

            if (heaps[minDiffIndex - 1] - heaps[minDiffIndex] == 0UL) containsZero = true
        } else {
            differences.removeAt(minDiffIndex - 1)
            differences.add(minDiffIndex - 1, heaps[minDiffIndex] - heaps[minDiffIndex + 1])
            differences.add(minDiffIndex - 1, heaps[minDiffIndex - 1] - heaps[minDiffIndex])


            if (heaps[minDiffIndex - 1] - heaps[minDiffIndex] == 0UL) containsZero = true
            if (heaps[minDiffIndex] - heaps[minDiffIndex + 1] == 0UL) containsZero = true
        }

        count++
    }

    // output
    println(count + 1)
}