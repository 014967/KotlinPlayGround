package baekjoon.solution11000

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @desc
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
수강신청 대충한 게 찔리면, 선생님을 도와드리자!
 * @input
첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)
 * @output
 *강의실의 개수를 출력하라.
 * @example
3
1 3
2 4
3 5
2
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    var queue = PriorityQueue<Pair<Int, Int>>(
        compareBy<Pair<Int, Int>> {
            it.first
        }.thenBy { it.second - it.first }
    )

    val tempQueue = PriorityQueue<Pair<Int, Int>>(
        compareBy<Pair<Int, Int>> {
            it.first
        }.thenBy { it.second - it.first }
    )

    for (i in 1..n) {
        val study = readLine().split(" ")
        val startTime = study[0].toInt()
        val endTime = study[1].toInt()
        queue.offer(Pair(startTime, endTime))
    }

    var currentTime = queue.poll()
    var count = 1

    while (queue.isNotEmpty() || tempQueue.isNotEmpty()) {
        if (queue.isNotEmpty()) {
            if (currentTime.second <= queue.peek().first) {
                // 강의실 배정
                currentTime = queue.poll()
            } else {
                tempQueue.offer(queue.poll())
            }
        } else {
            queue = PriorityQueue(tempQueue)
            currentTime = queue.poll()
            tempQueue.clear()
            count++
        }
    }
    println(count)
}

