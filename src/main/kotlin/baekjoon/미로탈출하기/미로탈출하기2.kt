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

data class Vertex2(
    val x: Int,
    val y: Int
)

private var count = 0
private var flag = false
private val pathList = arrayListOf<Vertex2>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val miro = Array(N) { Array(M) { ' ' } }
    for (i in 0 until N) {
        val row = readLine().toString().toList()
        for (j in row.indices) {
            miro[i][j] = row[j]
        }
    }
    val dp = Array(N) { Array(M) { -1 } } // check만 있어도 될것 같다.

    for (i in miro.indices) {
        for (j in miro[i].indices) {
            if (dp[i][j] == -1) {
                dfs(miro, Vertex2(i, j), dp)
            }
        }
    }
    for (i in miro.indices) {
        for (j in miro[i].indices) {
            count += dp[i][j]
        }
    }
    println(count)
}
private fun dfs(miro: Array<Array<Char>>, vertex: Vertex2, dp: Array<Array<Int>>): Int {
    val x = vertex.x
    val y = vertex.y

    if (x !in miro.indices || y !in miro[x].indices) {
        // 좌표가 밖으로 나간다면 카운트를 1씩 증가해주기 위해서 1 리턴
        return 1
    }
    if (dp[x][y] != -1) {
        // 이미 방문했던 좌표일 경우 그 경우의 값을 리턴 0 or 1  0이면 탈출못하는 좌표, 1이면 탈출 가능한 좌표
        return dp[x][y]
    }
    if (dp[x][y] == -1) { // 미 방문 하였을때
        dp[x][y] = 0 // 방문처리 아직 탈출할 수 있을지는 모른다.
        dp[x][y] += dfs(miro, moveWithType(miro[x][y], vertex), dp) // dp에 dfs한 값을 더해주면서 만약 탈출한다면, 지나온 좌표들을 모두 +1해준다.
    }
    return dp[x][y]
}
private fun moveWithType(type: Char, vertex: Vertex2): Vertex2 {
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


-1 : 방문하지 않음

0 : 방문했으나 탈출 불가능

1 : 방문했으며 탈출 가능
 */
