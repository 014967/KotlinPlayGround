package baekjoon.solution1715

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
    val queue = PriorityQueue<Int>()
    for (i in 1..n) {
        queue.offer(readLine().toInt())
    }

    var result = 0
    while (queue.isNotEmpty()) {
        if (queue.size == 1) {
            queue.poll()
        } else {
            val top = queue.poll()
            val second = queue.poll()
            val sum = top + second
            result += sum
            queue.offer(sum)
        }
    }
    println(result)
}
