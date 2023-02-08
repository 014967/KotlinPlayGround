package baekjoon.사다리게임

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

lateinit var arr: Array<Array<Int>>
var M: Int = 0
var H: Int = 0
var N: Int = 0
var finish = false
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (_N, _M, _H) = readLine().split(" ").map { it.toInt() }
    M = _M
    H = _H
    N = _N

    arr = Array(H + 1) { Array(N + 1) { 0 } }

    for (i in 0 until M) {
        val (startCol, endCol) = readLine().split(" ").map { it.toInt() }

        arr[startCol][ endCol] = 1

        arr[startCol][ endCol + 1] = 2
    }

    for (i in 0..3) {
        // 3까지 되니까 확인
        answer = i // 추가되는 선분의 갯수
        dfs(1, 0)
        if (finish) {
            break
        }
    }
    if (finish) {
        println(answer)
    } else {
        println(-1)
    }
}

fun dfs(x: Int, depth: Int) {
    if (finish) return // 재귀 타룿ㄹ

    if (answer == depth) {
        /*
        추가한 선분과 내가 지금 설치한 갯수가 같을 경우
         */
        if (check()) {
            finish = true
        }
        return
    }

    for (i in x..H) { // row
        for (j in 1 until N) {
            if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                // 연결된 선이 없으니까 연결해보기
                arr[i][j] = 1
                arr[i][j + 1] = 2
                dfs(i, depth + 1)

                arr[i][j] = 0 // 다시 취소
                arr[i][j + 1] = 0
            }
        }
    }
}

fun check(): Boolean {
    var flag = true
    for (i in 1..N) {
        /*
        다 설치하고 세로부터 내려오면서 가능한지 확인한다.
         */
        if (!flag) continue
        var x = 1
        var y = i
        for (j in 0 until H) {
            // 가로선은 H까지 주어짐
            if (arr[x][y] == 1) {
                y++
            } else if (arr[x][y] == 2) {
                y-- // 연결되어있다면 왼쪽과 연결되어있다는 뜻으로 y--
            }
            x++
        }
        if (y != i) {
            flag = false
        }
    }
    return flag
}
