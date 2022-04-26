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
    val numbers = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
    val hand = "right"
    val solution = Solution5()
    println(solution.solution(numbers, hand))
}
class Solution5 {
    fun solution(numbers: IntArray, hand: String): String {

        var answer = StringBuilder()
        var leftIdx = 0
        var rightIdx = 0

        for (i in numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer.append("L")
                leftIdx = i
            } else if (i == 3 || i == 6 || i == 9) {
                answer.append("R")
                rightIdx = i
            } else {
                var right_distance = 0
                var left_distance = 0

                if (left_distance == right_distance) {
                    if (hand == "right") {
                        answer.append("R")
                        rightIdx = i
                    } else {
                        answer.append("L")
                        leftIdx = i
                    }
                }
            }
        }
        return answer.toString()
    }
}
