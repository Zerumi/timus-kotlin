/**
 * №1993. This cheeseburger you don't need
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1993
 *
 * Idea: Split simple sentences. In each simple sentence build right order.
 * After it, add articles and build result sentence.
 *
 * This solution gets AC with 0.156s of time and 3 116KB of memory
 */

fun main() {
    // input
    val sentence = readln()

    // solution
    val simpleSentences = sentence.split(',')

    val resultSentences = mutableListOf<String>()

    for (simpleSentence in simpleSentences) {
        val `object` = simpleSentence.substringAfter('{').substringBefore('}')
        val subject = simpleSentence.substringAfter('(').substringBefore(')')
        val verb = simpleSentence.substringAfter('[').substringBefore(']')

        val resultSentence = "${`object`.lowercase()} ${subject.lowercase()} ${verb.lowercase()}"
        resultSentences.add(resultSentence)
    }

    // output
    print(resultSentences.first().replaceFirstChar { it.uppercase() })

    var subsentence = sentence.substringAfter(',')

    for (i in 1..<resultSentences.size) {
        val article = subsentence.takeWhile { it != '{' && it != '[' && it != '(' }
        subsentence = sentence.substringAfter(',')

        print(",$article${resultSentences[i]}")
    }
}