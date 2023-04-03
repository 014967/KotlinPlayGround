package baekjoon.컬러볼

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

data class Ball(
    val c: Int,
    val s: Int,
    val originIndex: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n) { Ball(0, 0, 0) }

    for (i in 0 until n) {
        val (c, s) = readLine().split(" ").map { it.toInt() }
        arr[i] = arr[i].copy(c = c, s = s, originIndex = i)
    }

    arr.sortWith(
        comparator = Comparator { o1, o2 ->
            o1.s - o2.s
        }
    )

    val colors = IntArray(n + 1)
    var ball_idx = 0
    var sum = 0
    val result = IntArray(n) { 0 }
    for (i in 0 until n) {
        val current: Ball = arr[i]
        while (arr[ball_idx].s < current.s) {
            // 이전에 sum 더해준 값을 더 더해주지 않음. ball_index++ 해주면
            sum += arr[ball_idx].s
            colors[arr[ball_idx].c] += arr[ball_idx].s
            ball_idx++
        }
        result[current.originIndex] = sum - colors[current.c]
//
    }
    val str = StringBuilder()
    for (i in result) {
        str.append(i.toString() + "\n")
    }
    println(str.toString())
}
/*
특정한 색과 크기를 가진 자기 공하나를 조정하여 게임에 참여한다.
각 플레이어는 자기 공보다 크기가 작고 색이 다른 공을 사로잡아 그 공의 크기만큼의 점수를 얻는다.
다른 공을 사로잡은 이후에도 본인의 공의 색과 크기는변하지 않음.

 */
