package baekjoon.드래곤커브

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

val table = Array(101) { Array(101) { false } }
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    for (i in 1..n) {
        val (x, y, d, g) = readLine().split(" ").map { it.toInt() }
        table[y][x] = true
        moving(g, d, x, y)
    }
    var count = 0
    for (i in table.indices) {
        for (j in table[i].indices) {
            var flag = true
            val current = table[i][j]
            if (!current) {
                flag = false
                continue
            }
            if (j + 1 in table[i].indices) {
                val currentRight = table[i][j + 1]
                if (!currentRight) {
                    flag = false
                    continue
                }
            } else {
                flag = false
                continue
            }
            if (i + 1 in table.indices) {
                val currentBottom = table[i + 1][j]
                if (!currentBottom) {
                    flag = false
                    continue
                }
            } else {
                flag = false
                continue
            }

            if (i + 1 in table.indices && j + 1 in table[i].indices) {
                val currentBottomRight = table[i + 1][j + 1]
                if (!currentBottomRight) {
                    flag = false
                    continue
                }
            }else{
                flag =false
                continue
            }
            count++
        }
    }
    println(count)
}

fun moving(g: Int, firstDirection: Int, x: Int, y: Int) {
    val arrayList = arrayListOf<Int>()

    for (k in 0..g) {
        if (k == 0) {
            arrayList.add(firstDirection)
        } else {
            val lastIndex = arrayList.lastIndex
            for (i in lastIndex downTo 0) {
                var nextDirection = arrayList[i] + 1
                if (nextDirection == 4) {
                    nextDirection = 0
                }
                arrayList.add(nextDirection)
            }
        }
    }
    var currentX = x
    var currentY = y
    for (i in arrayList) {
        val nextVertex = getDirection(i)
        currentX += nextVertex.first
        currentY += nextVertex.second
        table[currentY][currentX] = true
    }
}

fun getDirection(d: Int): Pair<Int, Int> {
    return when (d) {
        0 -> { Pair(1, 0) }
        1 -> { Pair(0, -1) }
        2 -> { Pair(-1, 0) }
        else -> { Pair(0, 1) }
    }
}

/*
드래곤 커브는 세가지 속성으로 이루어짐
1. 시작점
2. 시작방향
3. 세대

k 세대 드래곤 커브는 K-1 드래곤 커브를 끝 점을 기준으로 90도 돌려서, 긑점에 붙인것.
크기가 1 * 1 인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 개수를 구해.

x ,y , d , g
 */
