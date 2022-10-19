package baekjoon.solution1697

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
수빈이 동생과 숨바꼭질을 하고 있다.
수빈은 현재 점 N( 0 <= N <= 100,000)에 있고,
동생은 점 K(0<=K <=100,000)에 있다.
수빈이는 걷거나 순간이동을 할 수 있다.
만약 수빈이의 위치가 X일때 걷는다면 1초후에 X-1 또는 X+1로 이동하게 된다
순간이동을 하는 경우에는 1초 후에 2 * X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는
가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 구하시오.

 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    val n = input[0]
    val k = input[1]
    bfs(n, k)
}
private fun bfs(n: Int, k: Int) {

    val arr = Array(100001) { false }

    var currentPosition = n
    var queue = LinkedList<Int>()
    val tempQueue = LinkedList<Int>()
    queue.offer(currentPosition)

    var count = 0
    if (n > k) {
        count = n - k // 동생 이 내 뒤에 잇는 경우
    } else if (n == k) {
    } else {
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (!arr[current]) {
                arr[current] = true
                if (current != k) {
                    val moveLeft = current - 1
                    val moveRight = current + 1
                    val jump = current * 2
                    if (moveLeft in 0..100000) {
                        if (!arr[moveLeft]) {
                            tempQueue.offer(moveLeft)
                        }
                    }
                    if (moveRight in 0..100000) {
                        if (!arr[moveRight]) {
                            tempQueue.offer(moveRight)
                        }
                    }

                    if (jump in 0..100000) {
                        if (!arr[jump]) {
                            tempQueue.offer(jump)
                        }
                    }
                } else {
                    break
                }

            }
            if (queue.isEmpty()) {
                queue = LinkedList<Int>(tempQueue)
                tempQueue.clear()
                count++
            }
        }
    }

    println(count)
}
