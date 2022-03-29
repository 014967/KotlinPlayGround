package baekjoon.solution1655

import java.util.*

/**
 * @desc
 * 백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다.
 * 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다.
 * 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
 * 예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.
 * 백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.
 * @input
 * 첫째 줄에는 백준이가 외치는 정수의 개수 N이 주어진다.
 * N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다.
 * 그 다음 N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다.
 * 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.
 * @output
 * 한 줄에 하나씩 N줄에 걸쳐 백준이의 동생이 말해야 하는 수를 순서대로 출력한다.
 * @example
 *
 */

fun main() {
    val n = readLine()?.toInt()
    if (n != null) {
        require(n >= 1)
        require(n <= 100000)
        val maxQueue = PriorityQueue<Int>(reverseOrder())
        val minQueue = PriorityQueue<Int>()
        val str = StringBuilder()
        for (i in 1..n) {
            val input = readLine()?.toInt()
            if (input != null) {
                if (maxQueue.size == minQueue.size) {
                    maxQueue.offer(input)
                } else {
                    minQueue.offer(input)
                }
                if (maxQueue.isNotEmpty() && minQueue.isNotEmpty()) {
                    if (minQueue.peek() < maxQueue.peek()) {
                        swap(minQueue, maxQueue)
                    }
                }
            }
            str.append("${maxQueue.peek()}\n")
        }
        println(str)
    }
}

private fun swap(minQueue: PriorityQueue<Int>, maxQueue: PriorityQueue<Int>) {
    val minRoot = minQueue.poll()
    val maxRoot = maxQueue.poll()
    minQueue.offer(maxRoot)
    maxQueue.offer(minRoot)
}
fun solution() {
    val n = readLine()?.toInt()
    if (n != null) {
        require(n >= 1)
        require(n <= 100000)
        val minQueue = PriorityQueue<Int>(reverseOrder())
        val maxQueue = PriorityQueue<Int>()
        val str = StringBuilder()
        for (i in 1..n) {
            val input = readLine()?.toInt()
            if (input != null) {
                if (i == 1) {
                    minQueue.offer(input)
                } else if (i == 2) {
                    maxQueue.offer(input)
                    if (maxQueue.peek() < minQueue.peek()) {
                        swap(minQueue, maxQueue)
                    }
                } else {
                    if (i % 2 != 0) {
                        // 홀수 번 째 일 때
                        minQueue.offer(input)
                    } else {
                        // 짝수번째일 때
                        maxQueue.offer(input)
                    }

                    if (maxQueue.peek() < minQueue.peek()) {
                        swap(minQueue, maxQueue)
                    }
                }
                str.append("${minQueue.peek()} \n")
            }
        }
        println(str)
    }
}
/*
1  1 -> 1
1 5  -> 1
1 5 2 -> 1 2 5 -> 2
1 5 2 10  -> 2 5 -> 2
1 5 2 10 - 99 -> -99 1 2 5 10 -> 2
1 5 2 10 -99 7  -> -99 1 2 5 7 10 -> 2
1 5 2 10 -99 7 5  -> -99  1 2 5 5 7 10  -> 5
 */
