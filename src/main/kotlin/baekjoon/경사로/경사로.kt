package baekjoon.경사로

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

lateinit var roadMap: Array<Array<Int>>
lateinit var bridgeArray: Array<BooleanArray>
var result = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, L) = readLine().split(" ").map { it.toInt() }

    roadMap = Array(N) { Array(N) { 0 } }
    bridgeArray = Array(N) { BooleanArray(N) { false } }

    for (i in 0 until N) {
        val rowHeightList = readLine().split(" ").map { it.toInt() }
        for (j in rowHeightList.indices) {
            roadMap[i][j] = rowHeightList[j]
        }
    }
    for (i in 0 until N) {
        // 십자로 갈수 있는 길이 있는지 확인한다.
        check(i, L)
    }
    rotate(N)
    bridgeArray = Array(N) { BooleanArray(N) { false } }
    for (i in 0 until N) {
        check(i, L)
    }

    println(result)
}
fun check(i: Int, L: Int) {
    var flag = true
    for (j in 0 until roadMap[i].size - 1) {
        val target = kotlin.math.abs(roadMap[i][j + 1] - roadMap[i][j])
        if (target == 1) {
            // 브릿지 건설을 해야함.
            if (roadMap[i][j + 1] > roadMap[i][j]) {
                // 오른쪽이 더 크다.

                if (j + 1 - L < 0) {
                    flag = false
                    break
                }

                var count = 0
                for (k in j - L + 1..j) {
                    if (k in roadMap[i].indices) {
                        // 범위에 속하는지 확인
                        if (!bridgeArray[i][k] && roadMap[i][k] == roadMap[i][j]) {
                            // 브릿지가 없고 같은 값으로 연속되어있는 갯수를 센다.
                            count++
                        }
                    }
                }
                if (count < L) {
                    // 연속된 갯수가 L보다 작은 경우
                    flag = false
                    break
                }

                // 위의 if를 통과했다면
                for (k in j - L + 1..j) {
                    bridgeArray[i][k] = true
                }
            } else {
                // 왼쪽이 더 크다

                if (roadMap.size <= j + L) {
                    flag = false
                    break
                }

                var count = 0
                for (k in j + 1..j + L) {
                    if (k in roadMap[i].indices) {
                        // 범위에 있는지
                        if (!bridgeArray[i][k] && roadMap[i][j + 1] == roadMap[i][k]) {
                            count++
                        }
                    }
                }
                if (count < L) {
                    flag = false
                    break
                }
                for (k in j + 1..j + L) {
                    bridgeArray[i][k] = true
                }
            }
        } else if (target > 1) {
            flag = false
            break
        }
    }
    if (flag) {
        result++
    }
}

fun rotate(n: Int) {
    for (r in 0 until n / 2) {
        for (c in r until n - 1 - r) {
            val temp = roadMap[r][c]
            roadMap[r][c] = roadMap[n - 1 - c][r]
            roadMap[n - 1 - c][r] = roadMap[n - 1 - r][n - 1 - c]
            roadMap[n - 1 - r][n - 1 - c] = roadMap[c][n - 1 - r]
            roadMap[c][n - 1 - r] = temp
        }
    }
}
/*
6 2
3 2 2 1 1 1
2 3 3 3 3 3
2 2 2 3 2 3
1 1 1 2 2 2
1 1 1 3 3 1
1 1 2 3 3 2
 */

/*
길을 지나가기 위해서 모든 칸의 높이가 같아야함.
또는  경사로를  놓아서 지나갈 수 있는 길을 만들수있다.
경사로의 높이는  1이며,  길이는 L이다.
경사로는 낮은 칸과 높은 칸을 연결하며  조건을 만족해야한다.
-  겨앗로는 낮은 칸에 놓으며,  L개의 연속된 칸에 경사로의 바닥이 모두 접해야한다.
- 낮은 칸과 높은칸의  차이는 1
- 경사로를  놓을 낮은 칸의 높이는 모두 같아야하고,  L개의 칸이 연속되어야한다.

------
0 경사로를 놓은 곳에  경사로를 또  놓을수는  없고
낮은  칸과 높은 칸의 높이 차이가 1을 넘으면 안됌.
낮은 지점의 칸의 높이가 모두 같지 않거나  L개의 연속되지 않은  경우
경사로가 범위를 넘어서는  경우

---
길이란  한 행 또는 한 열 전부를 나타난다.
 */
