package leetcode.TaskSchedular

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
    val sol = Solution()
    val tasks = charArrayOf(
        'A', 'A', 'A', 'B','B','B'
    )
    val n = 2

    println(sol.leastInterval(tasks, n))
}
/*
여러개의 테스크가 존재한다.
작업은 어떤 순서로든 수행할 수 있다.
각 작업은 하나의 시간 단위로 수행된다
각 시간단위에 대해 CPU는 하나의 작업을 완료하거나 유휴상태일 수있다

두개의 동일한 작업 사이에는 최소 n단위의 시간이 있다.
주어진 모든  작업을 완료한느데 걸리는 최소 시간 단위 수를 반환
 */

/*
idle이 적게 나기 위해서는, 가장 많이 남은 수가 idle이 나지 않게 해소되어야한다.

그렇지 않은 경우 A - > idle -> A -> idle 이런 경우가 나올 수 있다

남은 수가 가장 많은 경우를 우선순위 위로, 그리고 현재 유휴기간이 남지 않은 수로 해야할 것이다,

 */

data class AlphaBet(
    val alphaBet: Char,
    val count: Int,
    val time: Int
)
class Solution {
    val queue = PriorityQueue(
        Comparator { o1: AlphaBet, o2: AlphaBet -> o1.time - o2.time }
            .thenComparing { o1, o2 -> o2.count - o1.count }
    )

    val tempQueue = LinkedList<AlphaBet>()
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val map = tasks.toTypedArray().groupingBy { it }.eachCount()
        for (i in map) {
            queue.offer(AlphaBet(i.key, i.value, 0))
        }

        var count = 0

        while (queue.isNotEmpty() || tempQueue.isNotEmpty()) {
            if (queue.isEmpty() && tempQueue.isNotEmpty()) {
                // idle이 발생하는 상황
                while (tempQueue.isNotEmpty()) {
                    val currentTempTask = tempQueue.poll()
                    queue.offer(
                        currentTempTask.copy(
                            time = currentTempTask.time
                        )
                    )
                }
                println("idle")
                count++

                continue
            }
            val currentTask = queue.poll()
            val currentChar = currentTask.alphaBet
            val currentCount = currentTask.count
            val currentTime = currentTask.time

            if (currentTime > 0) {
                val updatedTask = currentTask.copy(
                    time = currentTime - 1
                )
                tempQueue.offer(updatedTask)
            } else {
                println("$currentChar")
                val updatedTask = currentTask.copy(
                    count = currentCount - 1,
                    time = n
                )
                if (updatedTask.count > 0) {
                    queue.offer(updatedTask)
                }
                while (tempQueue.isNotEmpty()) {
                    val currentTempTask = tempQueue.poll()
                    queue.offer(currentTempTask.copy(time = currentTempTask.time))
                }
                count++
            }
        }
        return count
    }
}
