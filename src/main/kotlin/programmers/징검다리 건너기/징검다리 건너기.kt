package programmers.`징검다리 건너기`

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
    val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
    val k = 3
    val solution = Solution()
    println(solution.solution(stones, k))
}

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var low = 1
        var high = Integer.MAX_VALUE - 1

        while (low <= high) {
            val mid = (low + high) / 2
            // 친구들 수 해당 하는 친구들수로 다리를 건널 수 있는가?

            var flag = true
            var count = 0
            for (i in stones.indices) {
                if (stones[i] <= mid) {
                    count++
                    if (count == k) {
                        flag = false
                        break
                    }
                } else {
                    count = 0
                }
            }
            if (flag) {
                // 건널 수 있다
                low = mid + 1
            } else {
                // 건널 수 없다.
                // 친수 수를 줄여
                high = mid - 1
            }
            // 없다면 줄여
        }
        answer = low

        return answer
    }
}
