package programmers.키패드누르기

import java.lang.Math.abs

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
    val numbers = intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2)
    val hand = "left"
    val solution = Solution()
    println(solution.solution(numbers, hand))
}

data class LeftHand(
    override var x: Int,
    override var y: Int
) : Hand()

data class RightHand(
    override var x: Int,
    override var y: Int
) : Hand()

abstract class Hand {
    abstract var x: Int
    abstract var y: Int
}

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = StringBuilder()

        val leftList = listOf(1, 4, 7)
        val rightList = listOf(3, 6, 9)
        val leftHand = LeftHand(3, 0)
        val rightHand = RightHand(3, 2)
        for (i in numbers) {
            val pair = getXY(i)
            if (i in leftList) {
                answer.append("L")
                leftHand.x = pair.first
                leftHand.y = pair.second
            } else if (i in rightList) {
                answer.append("R")
                rightHand.x = pair.first
                rightHand.y = pair.second
            } else {
                val numberLo = getXY(i)
                when (calculateDistance(numberLo, leftHand, rightHand)) {
                    -1 -> {
                        answer.append("L")
                        leftHand.x = numberLo.first
                        leftHand.y = numberLo.second
                    }
                    1 -> {
                        answer.append("R")
                        rightHand.x = numberLo.first
                        rightHand.y = numberLo.second
                    }
                    0 -> {
                        if (hand == "right") {
                            answer.append("R")
                            rightHand.x = numberLo.first
                            rightHand.y = numberLo.second
                        } else {
                            answer.append("L")
                            leftHand.x = numberLo.first
                            leftHand.y = numberLo.second
                        }
                    }
                }
            }
        }
        return answer.toString()
    }
    fun calculateDistance(numberLo: Pair<Int, Int>, leftHand: LeftHand, rightHand: RightHand): Int {
        val leftDistance = abs(leftHand.x - numberLo.first) + abs(leftHand.y - numberLo.second)
        val rightDistance = abs(rightHand.x - numberLo.first) + abs(rightHand.y - numberLo.second)
        return if (leftDistance < rightDistance) {
            -1
        } else if (leftDistance > rightDistance) {
            1
        } else {
            0
        }
    }

    fun getXY(number: Int): Pair<Int, Int> {
        return when (number) {
            1 -> Pair(0, 0)
            2 -> Pair(0, 1)
            3 -> Pair(0, 2)
            4 -> Pair(1, 0)
            5 -> Pair(1, 1)
            6 -> Pair(1, 2)
            7 -> Pair(2, 0)
            8 -> Pair(2, 1)
            9 -> Pair(2, 2)
            else -> Pair(3, 1)
        }
    }
}
