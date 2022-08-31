package baekjoon.solution11000

import java.io.BufferedReader
import java.io.InputStreamReader
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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    var room = PriorityQueue<Int>()

    val list = arrayListOf<Pair<Int, Int>>()

    for (i in 1..n) {
        val study = readLine().split(" ")
        val startTime = study[0].toInt()
        val endTime = study[1].toInt()
        list.add(Pair(startTime, endTime))
    }

    list.sortBy { it.first } // 시작시간으로
    for (i in 0 until n) {
        if (i == 0) {
            // 맨처음 강의 시간 넣기
            room.offer(list[i].second) // queue의 크기가 곧 강의실 갯수
        } else {
            if (room.peek() <= list[i].first) { // 끝나는 시간과 다음 강의 시작시간 비교
                // 다음 강의가 같은 강의실에서 할 수 있는 경우
                room.poll()
                room.offer(list[i].second) // 끝나는 시간 업데이트
                // poll => offer 강의실 갯수 +- 1 동일한 강의실 사용
            } else {
                room.offer(list[i].second)
            }
        }
    }
    println(room.size)
}
