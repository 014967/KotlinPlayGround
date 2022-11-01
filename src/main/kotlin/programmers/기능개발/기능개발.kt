package programmers.기능개발

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
    val progresses = intArrayOf(95, 90, 99, 99, 80, 99) // intArrayOf(93, 30, 55)
    val speeds = intArrayOf(1, 1, 1, 1, 1, 1) // intArrayOf(1, 30, 5)
    val solution = Solution()
    println(solution.solution(progresses, speeds))
}

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val queue = LinkedList<Pair<Int, Int>>()
        progresses.forEachIndexed { index, it ->
            queue.offer(Pair(it, speeds[index]))
        }
        var day = 1
        var count = 0
        val countList = arrayListOf<Int>()
        while (queue.isNotEmpty()) {
            val currentTask = queue.peek()
            if (currentTask.first + currentTask.second * day >= 100) {
                queue.poll()
                count++
            } else {
                if (count != 0) {
                    countList.add(count)
                    count = 0
                }
                day++
            }
        }
        if (count != 0) {
            countList.add(count)
            count = 0
        }
        answer = countList.toIntArray()
        return answer
    }
}
/*
progresses : 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
speeds : 각 작업의 개발 속도가 적힌 정수 배열

뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

각 배포마다 몇개의 기능이 배포되는지 return
배포는 하루에 한번, 하루의 끝에 이루어진다.
 */
