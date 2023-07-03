package baekjoon.연료채우기

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

data class Station(
    val distance: Int,
    val weight: Int
)
var result = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val queue = PriorityQueue<Station>() { o1, o2 -> o2.weight - o1.weight } // 최대한 충전가능한 station부터
    val arr = Array(n) { Station(0, 0) }
    for (i in 0 until n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        arr[i] = arr[i].copy(distance = a, weight = b)
    }

    val (L, P) = readLine().split(" ").map { it.toInt() }

    arr.sortBy { it.distance }

    var index = 0
    var currentGas = P
    while (index < arr.size) {
        if (currentGas >= L) {
            break
        }
        if (arr[index].distance <= currentGas) {
            // 현재 가스로 갈 수 있는 주유소들
            queue.offer(arr[index++])
        } else {
            // 가스가 이제 부족해
            if (queue.isEmpty()) {
                break
            } else {
                val top = queue.poll()
                currentGas += top.weight
                result++
            }
        }
    }

    while (currentGas < L && queue.isNotEmpty()) {
        val top = queue.poll()
        currentGas += top.weight
        result++
    }

    if (currentGas >= L) {
        println(result)
    } else {
        println(-1)
    }
}
