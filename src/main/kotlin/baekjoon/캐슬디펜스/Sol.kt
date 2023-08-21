package baekjoon.캐슬디펜스

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs

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

val tempList = arrayListOf<Int>()
var enemyCount = 0

var ans = 0

lateinit var area: Array<Array<Int>>
lateinit var initArea: Array<Array<Int>>
lateinit var visited: BooleanArray
lateinit var visitedArea: Array<Array<Boolean>>
var n = 0
var m = 0
var d = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, D) = readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    d = D
    require(N in 3..15)
    require(M in 3..15) //
    require(D in 1..10) // 공격거리
    visited = BooleanArray(M) { false }

    area = Array(N + 1) { Array(M) { 0 } }
    initArea = Array(N + 1) { Array(M) { 0 } }

    for (i in 0 until N) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            enemyCount++
            area[i][j] = row[j]
            initArea[i][j] = row[j]
        }
    }

    getAchor(0, 3, M, 0)
    println(ans)
}
fun initArea() {
    area = initArea
}

fun getDistance(achorX: Int, achorY: Int, enemyX: Int, enemyY: Int): Int {
    return abs(enemyX - achorX) + abs(enemyY - achorY)
}

data class Achor(
    val x: Int,
    val y: Int
)
data class Vertex(
    val x: Int,
    val y: Int
)

val dx = listOf(-1, -1, -1)
val dy = listOf(-1, 0, 1)

fun dfs(achorList: List<Achor>): Int {
    var res = 0

    for (k in 0 until n) {
        visitedArea = Array(n) { Array(m) { false } }

        for (temp in achorList.indices) {
            var minD = Integer.MAX_VALUE // 최소 거리
            var minR = Integer.MAX_VALUE // 최소 거리의 y좌표
            var minC = Integer.MAX_VALUE // 최소 거리의 x좌표
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (area[i][j] == 1) { // 적이 있을 경우
                        if (minD >= getDistance(n, temp, i, j)) {
                            // 현재 구한 최소 거리보다 더 짧은 거리가 발생할 경우
                            // 최단거리와 좌표들을 다시 초기화.
                            if (minD > getDistance(n, temp, i, j)) {
                                minD = getDistance(n, temp, i, j)
                                minR = i
                                minC = j
                            } else {
                                // 현재 구한 최소 거리와 지금 구한 최소 거리가 같을 경우,
                                // 가장 왼쪽 적부터 처지해야하므로 x좌표가 더 작은지 검사해야 함.
                                if (minC > j) {
                                    minR = i
                                    minC = j
                                }
                            }
                        }
                    }
                }
            }

            if (minD <= d) {
                visitedArea[minR][minC] = true
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (visitedArea[i][j]) {
                    area[i][j] = 0
                    res++
                }
            }
        }

        // 성 바로 위 줄을 모두 0으로 초기화.
        for (i in 0 until m) {
            area[n - 1][i] = 0
        }

        // i번째 줄을 i-1번째 줄로 초기화.
        for (i in n - 1 downTo 1) {
            for (j in 0 until m) {
                area[i][j] = area[i - 1][j]
            }
        }
        ans = ans.coerceAtLeast(res)
    }
    return ans
}
fun getAchor(currentCount: Int, depth: Int, col: Int, startIndex: Int) {
    if (currentCount == depth) {
        initArea()
        dfs(
            achorList = tempList.map {
                Achor(
                    x = area.size - 1,
                    y = it
                )
            }

        )
        return
    }

    for (index in startIndex until col) {
        if (!visited[index]) {
            visited[index] = true
            tempList.add(index)
            getAchor(currentCount + 1, depth, col, index + 1)
            tempList.removeAt(tempList.lastIndex)
            visited[index] = false
        }
    }
}

/*
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
x x x x x

 */
