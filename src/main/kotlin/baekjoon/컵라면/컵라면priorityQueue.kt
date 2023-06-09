package baekjoon.컵라면

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

data class Problem2(
    val deadLine: Int,
    val ramen: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    var arrList = ArrayList<Problem2>()
    for (i in 1..n) {
        val (deadLine, ramen) = readLine().split(" ").map { it.toInt() }
        arrList.add(Problem2(deadLine = deadLine, ramen = ramen))
    }
    // arrayList에  문제 객체를 넣고 , 데드라인으로 오름차순

    arrList.sortBy { it.deadLine }
    val queue = PriorityQueue<Int>()
    for (i in arrList) {
        queue.offer(i.ramen)
        // 6 큐에 6이 들어감
        //  7 ->
        if (i.deadLine < queue.size) {
            queue.poll()
        }
        // 7 ->
    }
    // 가장 큰 수만 남게 되서 나머지 sum 하면 되는 로직
    // O(n)
    println(queue.sum())
}
