/**
 * №1193. Queue at the Exam
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1193
 *
 * Idea: Form the queue by t1, then by t2 of each student.
 * Simulate current time after each student submission, and compare currentTime with t3
 * Maximum delta of current time and t3 is an answer.
 *
 * This solution gets AC with 0.234s of time and 7 592KB of memory
 */

import java.util.Comparator
import kotlin.math.max

data class Student(
    val t1: Int,
    val t2: Int,
    val t3: Int,
)

fun main() {
    // input
    val n = readln().toInt()
    val students = List(n) {
        val (t1, t2, t3) = readln().split(' ').map { it.toInt() }
        return@List Student(t1, t2, t3)
    }

    // solution
    val queue = students.sortedWith(
        Comparator.comparingInt<Student> { it.t1 }.thenComparingInt { it.t2 }
    )

    var answer = 0
    var currentTime = 0

    for (student in queue) {
        if (student.t1 <= currentTime) {
            // stand in queue
            currentTime += student.t2
        } else {
            currentTime = student.t1 + student.t2
        }
        // println("$student finished answer. Current time: $currentTime")

        if (currentTime > student.t3) {
            answer = max(answer, currentTime - student.t3)
            // println("Zachet should be started $answer minutes earlier")
        }
    }

    // output
    println(answer)
}
