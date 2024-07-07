/**
 * №1728. Curse on Team.GOV
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1728
 *
 * Idea: Sort possible members by rating.
 * Possible member shouldn't be in team with Lyosha and Vadik.
 * If it's, he mustn't be in team with Vadik. Otherwise, we don't pick him.
 * If we found possible member which don't participate with Lyosha and Vadik,
 * we should check, if we already found a team w/o Lyosha, and if it is, compare
 * rating between 2 teams, and select team with max rating. Otherwise, output
 * team w/o Lyosha, or we don't found any possible members.
 *
 * This solution gets AC with 0.203s of time and 7 132KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()
    val contests2 = HashSet<String>()
    val contests3 = HashSet<String>()
    repeat(n) {
        val line = readln()
        val contestUsers = line[0]
        when (contestUsers) {
            '2' -> contests2.addAll(line.drop(2).split(' '))
            '3' -> contests3.addAll(line.drop(2).split(' '))
            else -> Unit
        }
    }
    val leaderRatings = readln()
    val rE = leaderRatings.substringBefore(' ').toInt()
    val rK = leaderRatings.substringAfter(' ').toInt()
    val m = readln().toInt()
    val possibleMembers = Array(m) {
        val line = readln()
        return@Array Pair(line.substringBefore(' '), line.substringAfter(' ').toInt())
    }

    // solution
    contests2.remove("Kantorov")
    contests2.remove("Efremov")
    contests3.remove("Kantorov")
    contests3.remove("Efremov")
    possibleMembers.sortByDescending { it.second }

    var foundTeam = false
    var answerMember: String? = null
    // Possible member shouldn't be in contest3. If it's, he mustn't be in contest2.
    // Otherwise, go next.
    // We should find 1 not in contest3 or 1 in contest3 but not in contest2 and compare them.

    var foundTeamWOEfremov = false
    var possibleMemberWOEfremov: Pair<String, Int>? = null

    for (possibleMember in possibleMembers) {
        if (possibleMember.first in contests3) {
            if (possibleMember.first !in contests2 && !foundTeamWOEfremov) {
                // we found team w/o Efremov, but we should continue
                // maybe we will find better alternative with Efremov
                foundTeam = true
                answerMember = possibleMember.first

                foundTeamWOEfremov = true
                possibleMemberWOEfremov = possibleMember
            }
        } else {
            foundTeam = true
            // compare
            if (foundTeamWOEfremov) {
                val ratioWOEfremov = rK + possibleMemberWOEfremov!!.second
                val ratioWithEfremov = rK + rE + possibleMember.second
                answerMember = if (ratioWOEfremov >= ratioWithEfremov) {
                    possibleMemberWOEfremov.first
                } else {
                    possibleMember.first
                }
            } else {
                answerMember = possibleMember.first
            }
            break
        }
    }

    // output
    if (foundTeam) {
        println("Win")
        println(answerMember)
    } else {
        println("Fail")
    }
}