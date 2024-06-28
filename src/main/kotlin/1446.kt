/**
 * №1446. Sorting Hat
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1446
 *
 * Idea: Using a Map<String, List<String>>. Then output.
 *
 * This solution gets AC with 0.156s of time and 6 072KB of memory
 */
fun main() {
    // input
    val n = readln().toInt()

    // solution
    val faculties = mapOf<String, MutableList<String>>(
        Pair("Slytherin", mutableListOf()),
        Pair("Hufflepuff", mutableListOf()),
        Pair("Gryffindor", mutableListOf()),
        Pair("Ravenclaw", mutableListOf()),
    )

    repeat(n) {
        val name = readln()
        val faculty = readln()

        faculties[faculty]!!.add(name)
    }

    for (faculty in faculties) {
        println("${faculty.key}:")
        println(faculty.value.joinToString("\n"))
        println()
    }
}