package baekjoon.테트로미노

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

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)

lateinit var paper: Array<IntArray>
lateinit var check: Array<BooleanArray>

var result = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }

    paper = Array(N) { IntArray(M) { 0 } }
    check = Array(N) { BooleanArray(M) { false } }

    for (i in 1..N) {
        val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
        paper[i - 1] = arr
    }

    for (i in paper.indices) {
        for (j in paper[i].indices) {
            check[i][j] = true
            dfs(i, j, paper[i][j], 1)
        }
    }

    println(result)
}

fun dfs(i: Int, j: Int, sum: Int, count: Int) {
    if (count == 4) {
        result = result.coerceAtLeast(sum)
    }
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in paper.indices && y in paper[x].indices) {
            if (!check[x][y]) {
                if (count == 2) {
                    check[x][y] = true
                    dfs(x, y, sum + paper[x][y], count + 1)
                    check[x][y] = false
                }

                check[x][y] = true
                dfs(x, y, sum + paper[x][y], count + 1)
                check[x][y] = false
            }
        }
    }
}

/*
폴리오미노는 크기가 1*1인 정사각형을 여러개 이어서 붙인 도형
- 정사각형은 서로 겹치면안됨
- 도형은 모두 연결되어있어야함
- 정사각형의 변끼리 연결되어야한다. 꼭짓점과 꼭짓점만 맞닿아있으면안된다.

정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며 5가지가 있다.

아름이는 N * M 인 종이 위에 테트로미노 하나를 놓으려고한다. 종이는 1 * 1 크기의 칸으로 나뉨.
각각의 칸에는 정수가 쓰임
테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여있눈 수들의 합을 최대로 한느 프로그램

 */
