package baekjoon.solution11000

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @desc
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데,
최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우
i 수업과 j 수업은 같이 들을 수 있다.)
수강신청 대충한 게 찔리면, 선생님을 도와드리자!
 * @input
첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)
 * @output
강의실의 개수를 출력하라.
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val classList = arrayListOf<Pair<Int, Int>>()
    val classQueue = PriorityQueue<Int>()

    for (i in 1..N) {
        var s = readLine().split(" ")
        var startTime = s[0].toInt()
        var endTime = s[1].toInt()
        classList.add(Pair(startTime, endTime))
    }
    val sortedClassList = classList.sortedBy { it.first }

    for (i in 0 until N) {
        if (i == 0) {
            classQueue.offer(sortedClassList[0].second) // 첫번째 수업의 끝나는 시간을 넣음
        } else {
            if (sortedClassList[i].first < classQueue.peek()) {
                // 만약 다음 수업의 시작이 현재 클래스의 끝나는 시간보다 빠르다면
                // 강의실을 하나 더 늘려
                classQueue.offer(sortedClassList[i].second) // 강의실에 끝나는 시간을 추가함
            } else {
                classQueue.poll()
                classQueue.offer(sortedClassList[i].second)
            }
        }
    }
    println(classQueue.size)
}
