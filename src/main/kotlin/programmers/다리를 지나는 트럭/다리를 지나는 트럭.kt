package programmers.`다리를 지나는 트럭`

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
    val bridge_length = 2
    val weight = 10
    val truck_weights = intArrayOf(7, 4, 5, 6)
    val solution = Solution()
    println(solution.solution(bridge_length, weight, truck_weights))
}

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        var bridgeArr = LinkedList<Pair<Int, Int>>()
        val startQueue = LinkedList<Int>()
        truck_weights.forEach {
            startQueue.offer(it)
        }
        var time = 1
        while (startQueue.isNotEmpty() || bridgeArr.isNotEmpty()) {
            bridgeArr = LinkedList(
                bridgeArr.map {
                    Pair(first = it.first, second = it.second + 1)
                }
            )
            if (bridgeArr.isNotEmpty() && bridgeArr.peek().second > bridge_length) {
                bridgeArr.poll()
            }
            if (startQueue.isNotEmpty()) {
                val onboarding = startQueue.peek() ?: 0
                val sum = bridgeArr.sumOf { it.first }
                if (sum + onboarding <= weight) {
                    bridgeArr.offer(Pair(startQueue.poll(), 1))
                }
            }

            time++
        }
        answer = time -1

        return answer
    }
} /*
모든 트럭이 다리를 건너렬면 최소 몇 초가 걸리는지 알아내자.
다리에는 최대 bridge_length 대 오라갈 수 있다, 다리는 weight이하까지 무게를 견딤.
다리를 완전히 오르지 않는 트럭의 무게는 무시.

 */
