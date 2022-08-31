package baekjoon.solution1707

import baekjoon.solution2667.arr
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
val RED = 1
val BLUE = -1
var bg = true
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val k = readLine().toInt()

    for (i in 1..k) {
        val input = readLine().split(" ")
        val v = input[0].toInt()
        val e = input[1].toInt()

        val arr = Array(v + 1) { mutableListOf<Int>() }
        val checked = Array(v + 1) { 0 }
        for (j in 1..e) {
            val info = readLine().split(" ")
            val u = info[0].toInt()
            val v = info[1].toInt()
            arr[u].add(v)
            arr[v].add(u)
        }
        for (j in 1 until v + 1) {

            if (bg == false)
                break
            if (checked[j] == 0) {
                dfs(arr, checked, j, RED)
            }
        }
        if (bg == false) println("NO")else println("YES")
        bg = true
    }
}

fun dfs(arr: Array<MutableList<Int>>, checked: Array<Int>, start: Int, color: Int) {
    checked[start] = color

    for (i in arr[start]) {
        if (checked[i] == color) { // 인접한 노드와 색이 같으면 이분그래프가 아니네
            bg = false
            break
        }
        if (checked[i] == 0) {
            dfs(arr, checked, i, -color)
        }
    }
}
