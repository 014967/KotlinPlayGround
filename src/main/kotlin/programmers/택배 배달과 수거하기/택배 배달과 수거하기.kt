package programmers.`택배 배달과 수거하기`

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
    println(
//        solution.solution(
//            cap = 2,
//            n = 7,
//            deliveries = intArrayOf(1, 0, 2, 0, 1, 0, 2),
//            pickups = intArrayOf(0, 2, 0, 1, 0, 2, 0)
//        )
        solution.solution(
            cap = 2,
            n = 2,
            deliveries = intArrayOf(0, 0),
            pickups = intArrayOf(0, 4)
        )
    )
}

class Solution {

    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = -1

        val dStack = Stack<Int>().apply {
            deliveries.forEach { add(it) }
        }
        val pStack = Stack<Int>().apply {
            pickups.forEach { add(it) }
        }

        var distance = 0L
        while (dStack.isNotEmpty() || pStack.isNotEmpty()) {
            var count = cap

            while (dStack.isNotEmpty() && dStack.peek() == 0) {
                dStack.pop()
            }
            while (pStack.isNotEmpty() && pStack.peek() == 0) {
                pStack.pop()
            }
            val maxDistance = maxOf(dStack.size, pStack.size)

            distance += maxDistance * 2 // 거리 추가
            while (count > 0 && dStack.isNotEmpty()) {
                val top = dStack.pop()
                if (top == 0) {
                    continue
                }
                if (top - count > 0) {
                    dStack.add(top - count)
                    count = 0
                } else {
                    count -= top
                }
            }

            var emptyCount = cap
            while (emptyCount > 0 && pStack.isNotEmpty()) {
                val top = pStack.pop()
                if (top == 0) {
                    continue
                }
                if (top - emptyCount > 0) {
                    pStack.add(top - emptyCount)
                    emptyCount = 0
                } else {
                    emptyCount -= top
                }
            }
        }
        answer = distance

        return answer
    }
}

/*
일렬로 나열된 n개의 집에 택배를 배달,
배달할 문건은 모두 크기가 같으 재활용 택배 상자에 담아 배달, 배달을 다니면서 빈 재활용 택배 상자 수거

트럭에는 재활용 택배 상자를 최대 cap개 실을 수 있다.

무조건 제일 뒤에 있는 것을 먼저 다녀와야 겠넹
 */
