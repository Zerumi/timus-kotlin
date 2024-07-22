/**
 * №2019. Pair: normal and paranormal
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=2019
 *
 * Idea: Hold read traps and hunters. We should destroy neighbor traps and hunters
 * if we found an intersection (ABab), where we cannot destroy a neighbor pair,
 * a solution is impossible.
 *
 * This solution gets AC with 0.296s of time and 3 324KB of memory
 */

import kotlin.math.abs

private const val ASCII_DELTA = 32

fun main() {
    // input
    val n = readln().toInt()
    val input = readln()

    // solution
    val result = List(input.length / 2) { 0 }.toMutableList()
    var huntersIndex = 1
    var trapsIndex = 0

    val trapsIndexes = mutableMapOf<Char, MutableList<Int>>()
    val huntersIndexes = mutableMapOf<Char, MutableList<Int>>()

    val accumulator = mutableListOf<Char>()

    for (currentChar in input) {
        if (currentChar.isUpperCase()) {
            // it's a trap
            trapsIndexes.getOrPut(currentChar) { mutableListOf() }.add(trapsIndex++)
        }

        if (currentChar.isLowerCase()) {
            // it's an hunter
            huntersIndexes.getOrPut(currentChar) { mutableListOf() }.add(huntersIndex++)
        }

        if (accumulator.isNotEmpty() && abs(accumulator.last() - currentChar) == ASCII_DELTA) {
            val currentTrapIndex = trapsIndexes[currentChar.uppercaseChar()]!!.last()
            val currentAnimalIndex = huntersIndexes[currentChar.lowercaseChar()]!!.last()

            result[currentTrapIndex] = currentAnimalIndex
            trapsIndexes[currentChar.uppercaseChar()]?.removeLast()
            huntersIndexes[currentChar.lowercaseChar()]?.removeLast()
            accumulator.removeLast()
        } else {
            accumulator.add(currentChar)
        }
    }

    // output
    if (accumulator.isEmpty()) {
        result.forEach { print("$it ") }
    } else {
        println("Impossible")
    }
}
