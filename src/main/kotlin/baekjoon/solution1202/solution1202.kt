package baekjoon.solution1202

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
    val line = readLine().split(" ").map {
        it.toInt()
    }
    val n = line[0]
    val k = line[1]
    val bosuckList = arrayListOf<Pair<Int, Int>>()
    val begList = arrayListOf<Int>()
    for (i in 1..n) {
        val s = readLine().split(" ").map {
            it.toInt()
        }
        val m = s[0] // 보석 무게
        val v = s[1] // 보석 가격
        bosuckList.add(Pair(m, v))
    }
    for (i in 1..k) {
        val c = readLine().toInt() // 가방 용량
        begList.add(c)
    }
    var result = 0
    for (i in begList) {
        val queue = PriorityQueue<Int>()
        for (j in bosuckList) {
            if (i >= j.first) {
                if (queue.peek() != null) {
                    if (queue.peek() <= j.second) {
                        queue.poll()
                        queue.offer(j.second)
                    }
                } else {
                    queue.offer(j.second)
                }
            }
        }
        result += queue.poll()
    }
    println(result)
}
