package programmers.디스크컨트롤러

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
    val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))
    val solution = Solution()
    println(solution.solution(jobs))
}

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0

        val queue1 = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] })) // 요청 시간으로 같다면 소요시간으로
        val queue2 = PriorityQueue<IntArray>(compareBy({ it[1] }, { it[0] })) // 소요 시간 순으로 같다면 요청

        queue1.addAll(jobs) // 작업들을 모두 요청 시간 순으로 정렬

        var time = 0
        while (queue1.isNotEmpty() || queue2.isNotEmpty()) {
            while (queue1.isNotEmpty() && queue1.peek()[0] <= time) {
                // 요청 시간이 현재 시간보다 이전인 경우에 queue2에 넣는다.
                queue2.offer(queue1.poll())
            }
            if (queue2.isNotEmpty()) {
                time += queue2.peek()[1]

                answer += time - queue2.peek()[0]
                queue2.poll()
            } else if (queue1.isNotEmpty()) {
                time = queue1.peek()[0]
            }
        }

        return answer / jobs.size
    }
}

/*
대기 시간 + 실행 시간의 평균을 구하는 문제
실행 시간은 동일하므로 대기 시간을 줄여야 평균적으로 최소한의 작업 완료 시간을 가진다.
 */
