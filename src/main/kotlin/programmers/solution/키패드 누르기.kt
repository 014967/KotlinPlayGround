package programmers.solution

import kotlin.math.abs

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
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0) // intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
    val hand =  "right"
    val solution = Solution5()
    println(solution.solution(numbers, hand))
}
class Solution5 {
    fun solution(numbers: IntArray, hand: String): String {

        var answer = StringBuilder()

        var leftIdx = Pair(3, 0)
        var rightIdx = Pair(3, 2)
        for (i in numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer.append("L")
                when (i) {
                    1 -> leftIdx = Pair(0, 0)
                    4 -> leftIdx = Pair(1, 0)
                    7 -> leftIdx = Pair(2, 0)
                }
            } else if (i == 3 || i == 6 || i == 9) {
                answer.append("R")
                when (i) {
                    3 -> rightIdx = Pair(0, 2)
                    6 -> rightIdx = Pair(1, 2)
                    9 -> rightIdx = Pair(2, 2)
                }
            } else { // 가운데 숫자가 눌릴 때
                var leftDistance = 0
                var rightDistance = 0
                var inputX = 0
                var inputY = 0
                if (i == 0) {
                    inputX = 3
                    inputY = 1
                } else {
                    inputX = i / 4
                    inputY = 1
                    if (i % 3 == 0) {
                        inputX = i / 3 - 1
                    }
                }

                leftDistance = abs(leftIdx.first - inputX) + abs(leftIdx.second - inputY)
                rightDistance = abs(rightIdx.first - inputX) + abs(rightIdx.second - inputY)

                if (leftDistance> rightDistance) {
                    answer.append("R")
                    rightIdx = Pair(inputX, inputY)
                } else if (rightDistance > leftDistance) {
                    answer.append("L")
                    leftIdx = Pair(inputX, inputY)
                } else {
                    if (hand == "right") {
                        answer.append("R")
                        rightIdx = Pair(inputX, inputY)
                    } else {
                        answer.append("L")
                        leftIdx = Pair(inputX, inputY)
                    }
                }
            }
        }
        return answer.toString()
    }
}
