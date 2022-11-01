package programmers.섬연결하기

import java.util.*

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
    val n = 4
    val costs = arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 2, 2), intArrayOf(1, 2, 5), intArrayOf(1, 3, 1), intArrayOf(2, 3, 8))
    val solution = Solution()
    val testCase = listOf(
        listOf(5, arrayOf(intArrayOf(0, 1, 1), intArrayOf(3, 4, 1), intArrayOf(1, 2, 2), intArrayOf(2, 3, 4))),
        listOf(4, arrayOf(intArrayOf(0, 1, 5), intArrayOf(1, 2, 3), intArrayOf(2, 3, 3), intArrayOf(1, 3, 2), intArrayOf(0, 3, 4))),
        listOf(5, arrayOf(intArrayOf(0, 1, 1), intArrayOf(3, 1, 1), intArrayOf(0, 2, 2), intArrayOf(0, 3, 2), intArrayOf(0, 4, 100))),
        listOf(
            6,
            arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(0, 3, 2),
                intArrayOf(0, 4, 3),
                intArrayOf(1, 4, 1),
                intArrayOf(3, 4, 10),
                intArrayOf(1, 2, 2),
                intArrayOf(2, 5, 3),
                intArrayOf(4, 5, 4)
            )
        )

    )
    testCase.forEach {
        println(solution.solution(it[0]as Int, it[1] as Array<IntArray>))
    }
}

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0

        val sortedCosts = costs.sortedBy { it[2] }
        val visited = mutableSetOf(sortedCosts[0][0]) // 노드의 방문처리
        while (visited.size < n) {
            for (i in sortedCosts) {
                val start = i[0]
                val end = i[1]
                val cost = i[2]
                if (visited.contains(start) or visited.contains(end)) { // 둘중하나라도 방문했다면
                    if (visited.contains(start) and visited.contains(end)) { // 둘다 방문했다면
                        continue
                    }
                    visited.add(start)
                    visited.add(end)
                    answer += cost
                    break
                }
            }
        }
        return answer
    }
}

/*

 */
