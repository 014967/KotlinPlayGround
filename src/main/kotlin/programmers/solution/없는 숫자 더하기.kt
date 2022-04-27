package programmers.solution

/**
 * @desc
 *
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)
    val solution = Solution7()
    println(solution.solution(numbers))
}

class Solution7 {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0

        for (i in 0..9) {
            if (numbers.indexOf(i) == -1) {
                answer += i
            }
        }
        return answer
    }
}
