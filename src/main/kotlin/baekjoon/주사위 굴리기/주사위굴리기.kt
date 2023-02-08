package baekjoon.`주사위 굴리기`

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

data class CurrentVertex(
    var x: Int,
    var y: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, x, y, k) = readLine().split(" ").map { it.toInt() }
    val dice = Array(7) { 0 }
    val map = Array(N) { Array(M) { 0 } }
    for (i in 0 until N) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }

    var currentVertex = baekjoon.`주사위 굴리기`.CurrentVertex(
        x = x,
        y = y
    )

    val cmd = readLine().split(" ").map { it.toInt() }
    for (i in cmd) {
        when (i) {
            1 -> { // 동쪽
                val next = CurrentVertex(currentVertex.x, currentVertex.y + 1)
                if (check(next, N, M)) {
                    currentVertex = next

                    val temp2 = dice[2]
                    val temp6 = dice[6]
                    val temp4 = dice[4]
                    val temp3 = dice[3]

                    dice[6] = temp2
                    dice[2] = temp3
                    dice[3] = temp4
                    dice[4] = temp6

                    if (map[next.x][next.y] == 0) {
                        map[next.x][next.y] = dice[3]
                    } else {
                        dice[3] = map[next.x][next.y]
                        map[next.x][next.y] = 0
                    }
                    println(dice[6])
                }
            }
            2 -> {
                val next = CurrentVertex(currentVertex.x, currentVertex.y - 1)
                if (check(next, N, M)) {
                    currentVertex = next
                    val temp4 = dice[4]
                    val temp6 = dice[6]
                    val temp2 = dice[2]
                    val temp3 = dice[3]
                    dice[6] = temp4
                    dice[4] = temp3
                    dice[3] = temp2
                    dice[2] = temp6

                    if (map[next.x][next.y] == 0) {
                        map[next.x][next.y] = dice[3]
                    } else {
                        dice[3] = map[next.x][next.y]
                        map[next.x][next.y] = 0
                    }
                    println(dice[6])
                }
            }
            3 -> {
                val next = CurrentVertex(currentVertex.x - 1, currentVertex.y)
                if (check(next, N, M)) {
                    currentVertex = next
                    val temp5 = dice[5]
                    val temp6 = dice[6]
                    val temp1 = dice[1]
                    val temp3 = dice[3]

                    dice[6] = temp5
                    dice[5] = temp3
                    dice[3] = temp1
                    dice[1] = temp6

                    if (map[next.x][next.y] == 0) {
                        map[next.x][next.y] = dice[3]
                    } else {
                        dice[3] = map[next.x][next.y]
                        map[next.x][next.y] = 0
                    }
                    println(dice[6])
                }
            }
            else -> {
                val next = CurrentVertex(currentVertex.x + 1, currentVertex.y)
                if (check(next, N, M)) {
                    currentVertex = next
                    val temp1 = dice[1]
                    val temp3 = dice[3]
                    val temp5 = dice[5]
                    val temp6 = dice[6]

                    dice[1] = temp3
                    dice[6] = temp1
                    dice[5] = temp6
                    dice[3] = temp5

                    if (map[next.x][next.y] == 0) {
                        map[next.x][next.y] = dice[3]
                    } else {
                        dice[3] = map[next.x][next.y]
                        map[next.x][next.y] = 0
                    }
                    println(dice[6])
                }
            }
        }
        // 최상단 출력
    }
}

fun check(currentVertex: baekjoon.`주사위 굴리기`.CurrentVertex, N: Int, M: Int): Boolean {
    var flag = true
    val x = currentVertex.x
    val y = currentVertex.y
    if (x !in 0 until N || y !in 0 until M) {
        flag = false
    }
    return flag
}
/*
주사위를 놓은 곳의 좌표와 이동 시키는 명령이 주어졌을때 주사위가 이동했을때마다 상단에 쓰여있는 값을 구해

 */
