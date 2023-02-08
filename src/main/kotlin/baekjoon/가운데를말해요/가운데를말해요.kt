package baekjoon.가운데를말해요

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
    val N = readLine().toInt()

    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    val minHeap = PriorityQueue<Int>()

    val str = StringBuilder()
    for (i in 1..N) {
        val input = readLine().toInt()
        if (i % 2 == 0) {
            // 짝수 순일 때
            minHeap.add(input)
        } else {
            maxHeap.add(input)
        }

        if (i >= 3) {
            val maxRoot = maxHeap.peek()
            val minRoot = minHeap.peek()
            if (maxRoot > minRoot) {
                val maxTop = maxHeap.poll()
                val minTop = minHeap.poll()
                // swap
                minHeap.add(maxTop)
                maxHeap.add(minTop)
            }
        }

        if (i == 2) {
            if (maxHeap.peek() > minHeap.peek()) {
                val maxTop = maxHeap.poll()
                val minTop = minHeap.poll()
                // swap
                minHeap.add(maxTop)
                maxHeap.add(minTop)
            }
        }
        str.append("${maxHeap.peek()} \n")
    }
    println(str.toString())
}
/*
정수를 하나씩 외칠때마다, 말한 수 들 중에서 중간값을 말해야한다.
외친수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야한다.
 */

/*
중간값 힙

1. 최대 힙의 크기는 최소 힙의 크기와 같거나, 하나 더 큼
2. 최대 힙의 root는 최소합의 root보다 작거나 같음

이 두가지 규칙을 유지한다면 항상 최대 힙 top이 중간값이래

 */
