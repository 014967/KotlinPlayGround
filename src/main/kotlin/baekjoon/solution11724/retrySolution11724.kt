package baekjoon.solution11724

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
방향 없는 그래프가 주어졌을 때, 연결 요소 ( Connected Component )의
개수를 구하는 프로그램을 작성하세요.

정점의 갯수 n, 간선의 갯수 m이 주어진다.
둘째 줄부터 m개의 줄에 간서의 양끝점 u와 v가 주어짐.

 */

val queue = LinkedList<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map { it.toInt() }
    val n = str[0]
    val m = str[1]
    val arr = Array(n + 1) { Stack<Int>() }
    val check = Array(n + 1) { false }
    var count = 0

    for (i in 1..m) {
        val s = readLine().split(" ").map {
            it.toInt()
        }
        arr[s[0]].add(s[1])
        arr[s[1]].add(s[0])
    }

    for (i in 1 until arr.size) {
        if (!check[i]) {
            bfs(check, arr, i)
            count++
        }
    }
    for (i in 1 until check.size) {
        if (!check[i]) {
            count++
        }
    }

    println(count)
}
private fun bfs(check: Array<Boolean>, arr: Array<Stack<Int>>, i: Int) {
    queue.offer(i)
    check[i] = true
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (k in arr[current].indices) {
            if (!check[arr[current][k]]) {
                queue.offer(arr[current][k])
                check[arr[current][k]] = true
            }
        }
    }
}
