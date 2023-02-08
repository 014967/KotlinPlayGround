package baekjoon.미로탈출하기

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

private data class Vertex(
    val x: Int,
    val y: Int
)

private var count = 0
private var flag = false
private val pathList = arrayListOf<Vertex>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val miro = Array(N) { Array(M) { ' ' } }
    for (i in 0 until N) {
        val row = readLine().toString().toList()
        for (j in row.indices) {
            miro[i][j] = row[j]
        }
    }
    val check = Array(N) { BooleanArray(M) { false } } // check만 있어도 될것 같다.

    for (i in miro.indices) {
        for (j in miro[i].indices) {
            if (!check[i][j]) {
                dfs(miro, Vertex(i, j), check)
                pathList.clear()
                flag = false
            } else {
                count++
            }
        }
    }
    println(count)
}
private fun dfs(miro: Array<Array<Char>>, vertex: Vertex, checked: Array<BooleanArray>) {
    val x = vertex.x
    val y = vertex.y

    if (x !in miro.indices || y !in miro[x].indices) {
        count++
        flag = true
        return
    }

    if (!checked[x][y]) {
        pathList.add(vertex)
        checked[x][y] = true
        val nextVertex = moveWithType(miro[x][y], vertex)
        dfs(miro, nextVertex, checked)
        if (!flag) {
            checked[x][y] = false
        }
    } else {
        // 지나온 길은 아니지만, checked라면 이미 다른 노드에서 갔을 때 탈출한 좌표다.
        if (pathList.indexOf(vertex) == -1) {
            count++
        }
    }
}
private fun moveWithType(type: Char, vertex: Vertex): Vertex {
    val x = vertex.x
    val y = vertex.y
    return when (type) {
        'U' -> {
            vertex.copy(x = x - 1, y = y)
        }
        'R' -> {
            vertex.copy(x = x, y = y + 1)
        }
        'D' -> {
            vertex.copy(x = x + 1, y = y)
        }
        else -> {
            vertex.copy(x = x, y = y - 1)
        }
    }
}
/*
메모이제이션을 사용하자

순환하는 좌표들을 저장해서
 */
