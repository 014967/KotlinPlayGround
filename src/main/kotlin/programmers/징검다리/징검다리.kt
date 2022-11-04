package programmers.징검다리

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
    val solution = Solution()
    val distance = 23
    val rocks = intArrayOf(3, 6, 9, 10, 14, 17)
    val n = 2
    println(solution.solution(distance, rocks, n))
}

class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0
        rocks.sort()

        var low = 1
        var high = distance
        while (low <= high) {
            val mid = (low + high) / 2 // 최대 거리
            var count = 0
            var prevRock = 0
            for (i in rocks.indices) {
                if (rocks[i] - prevRock < mid) {
                    count++ // 제거 카운트
                } else {
                    prevRock = rocks[i]
                }
            }
            if (distance - prevRock < mid) {
                count++
            }

            if (count > n) { // count가 제거 돌 수
//                제거 돌수가 n보다 많을 때, 줄이는게 맞지  않나
                high = mid - 1
            } else {
                low = mid + 1
                answer = answer.coerceAtLeast(mid)
            }
        }

        return answer
    }
}
/*
출발지점으로부터 distacne만큼 떨어진 곳에 도착지점이 있다.  그리고 그 사이에는 바위들이 놓여있다.
바위 중에 몇개를 제거하려고한다.
도착지점이 25만큼 떨어져 있고, 바위가 [2,14,11,21,17] 지점에 놓여있을 때
 */
