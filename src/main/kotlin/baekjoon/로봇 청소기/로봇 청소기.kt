package baekjoon.`로봇 청소기`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

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
// 청소영역 구하기

val direction = listOf(0, 1, 2, 3) // 위 오른 아래 왼
data class Robot(
    val x: Int,
    val y: Int,
    val direction: Int
)
lateinit var area: Array<Array<Int>>
lateinit var check: Array<Array<Boolean>>
var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    area = Array(N) { Array(M) { 0 } }
    check = Array(N) { Array(M) { false } }

    val (x, y, d) = readLine().split(" ").map { it.toInt() }
    val startLocation = Robot(x, y, d)
    for (i in 0 until N) {
        val floorState = readLine().split(" ").map { it.toInt() }
        for (j in floorState.indices) {
            area[i][j] = floorState[j]
        }
    }

    test(startLocation, 1)
    println(count)
}

val dx = listOf(-1, 0, 1, 0) // 위 오 아 왼
val dy = listOf(0, 1, 0, -1)

fun test(robot: Robot, count: Int) {
    check[robot.x][robot.y] = true

    for (i in 0..3) {
        val nextDirection = (robot.direction + 3 - i) % 4 // 반시계 방향 확인
        val x = robot.x + dx[nextDirection]
        val y = robot.y + dy[nextDirection]
        if (x !in area.indices || y !in area[x].indices || area[x][y] == 1) {
            continue
        }
        if (!check[x][y] && area[x][y] == 0) {
            check[x][y] = true
            test(Robot(x, y, nextDirection), count + 1)
        }
    }

    // 4가지 방향에서 갈곳이 없는 경우
    val backIndex = when (robot.direction) {
        0 -> { 2 }
        1 -> { 3 }
        2 -> { 0 }
        else -> { 1 }
    }
    val x = robot.x + dx[backIndex]
    val y = robot.y + dy[backIndex]
    if (x in area.indices && y in area[x].indices) {
        if (area[x][y] == 0) {
            test(Robot(x, y, robot.direction), count)
        } else {
            println(count)
            exitProcess(0)
        }
    }
}
