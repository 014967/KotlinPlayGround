package programmers.`두 큐 합 같게 만들기`

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
    val queue1 = intArrayOf(1, 1)
    val queue2 = intArrayOf(1, 2)
    println(solution.solution(queue1, queue2))
}

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0

        val q1 = LinkedList(queue1.toList().map { it.toLong() })
        val q2 = LinkedList(queue2.toList().map { it.toLong() })

        var q1Sum = q1.sum()
        var q2Sum = q2.sum()
        val total = (q1Sum + q2Sum) / 2

        if (q1.any { it > total } || q2.any { it > total }) {
            // true를 반환하는게 하나라도 있을 경우
            answer = -1
        } else if ((q1Sum + q2Sum) % 2 != 0L) {
            answer = -1
        } else {
            var count = 0
            var flag = false
            while (q1Sum != q2Sum) {
                if (q1Sum > q2Sum) {
                    val pop = q1.pop()
                    q1Sum -= pop
                    q2Sum += pop
                    q2.offer(pop)
                } else {
                    val pop = q2.pop()
                    q2Sum -= pop
                    q1Sum += pop
                    q1.offer(pop)
                }
                count++

                if (count > (queue1.size + queue2.size) * 2) {
                    flag = true
                    break
                }
            }
            if (flag) {
                answer = -1
            } else {
                answer = count
            }
        }

        return answer
    }
}

/*
길이 같은 큐가 두개 주어진다.
하나의 큐를 골라 원소를 추출하고, 추출된 원소를 다른 큐에 집어넣는 작업을 함
각 큐의 원소의 합이 같도록 만들려고 한다.
이때 필요한 작업의 최소 횟수를 구하고자한다.
한번의 pop과 한번의 insert를 합쳐서 작업을 1회 수행한것으로 한다.


11, 14, 19~24, 28, 30 시간초과

처음에 sum을 사용해 두 큐의 합을 가지는 변수를 선언한 후
이동하는 값만 해당 변수들에서 덧셈, 뺄셈하시면 O(1)의 시간으로 해결가능합니다.
 */
