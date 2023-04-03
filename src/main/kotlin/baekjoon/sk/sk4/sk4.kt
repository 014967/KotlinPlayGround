package baekjoon.sk.sk4

import java.io.BufferedReader
import java.io.InputStreamReader

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

data class Bang(
    val time: Int,
    val count: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
val bakery_schedule = arrayOf<String>("12:00 10", "12:30 10 ") // 빵이 나온다. 10개
    val current_time = "12:00" // 현재 시간이야
    val k = 11 // 우리가 구해야하는 빵의 갯수야

    println(solution(bakery_schedule, current_time, k))
}

fun solution(bakery_schedule: Array<String>, current_time: String, k: Int): Int {
    var answer = -2

    val (chh, cmm) = current_time.split(":").map { it.toInt() }

    val conVert_current_time = chh * 60 + cmm

    val bangList = arrayListOf<Bang>()
    for (i in bakery_schedule.indices) {
        val (time, count) = bakery_schedule[i].split(" ")
        val (hh, mm) = time.split(":").map { it.toInt() }
        val conVertTime = hh * 60 + mm
        bangList.add(Bang(conVertTime, count.toInt()))
    }

    var currentCount = 0

    var resultTime = 0


    for (i in bangList) {
        if (i.time >= conVert_current_time) {
            currentCount += i.count
            if (currentCount >= k) {
                resultTime = i.time
                break
            }
        }
    }
    answer = if (resultTime - conVert_current_time >= 0) {
        resultTime - conVert_current_time
    } else {
        -1
    }

    return answer
}
