/**
 * №1685. Orthography
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1685
 *
 * Idea: Reverse function:
 *      * s[0] is a middle;
 *      * s[1..<otherLeftHalf] is a left half. Should be recovered by reverse function
 *      * s[otherLeftHalf..end] is a right half. Should be recovered by reverse function
 *
 * Total: f^(-1) = f^(-1)(sLeftHalfAfterS0) + s[0] + f^(-1)(sRightHalfAfterS0)
 * If s contains 1 or 2 characters -> f^(-1) = s
 *
 * This solution gets AC with 0.156s of time and 5 400KB of memory
 */

fun main() {
    // input
    val input = readln()

    // solution
    val solution = transform(input)

    // output
    println(solution)
}

// f(s) = s[m] + f(s[0..m]) + f(s[m..end])
// f^(-1) = f^(-1)(s) + s[m] + f'(-1)(s)

// k[yaVs ali][sse uop.]

// y[aVs][ ali] -> Vasya li
// !! half's length ; 7 -> 3 + 4
// a[V][s]      -> Vas
// ‘ ‘[a][li]   -> a li
// li           -> li???
//
// s[se ][uop.] -> es soup.
// s[e][ ]      -> es’ ‘
// u[o][p.]     -> oup.
// p.           -> p.???

fun transform(s: String) : String {
    if (s.length == 1) return s
    if (s.length == 2) return s

    val middle = s[0]
    val other = s.substring(1)
    val leftHalf = other.substring(0..<other.length / 2)
    val rightHalf = other.substring(other.length / 2)

    return transform(leftHalf) + middle + transform(rightHalf)
}
