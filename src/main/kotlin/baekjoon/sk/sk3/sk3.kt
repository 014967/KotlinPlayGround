package baekjoon.sk.sk3

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

lateinit var table: Array<Array<Char>>
lateinit var checker: Array<Array<Boolean>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val boards = arrayOf(
        arrayOf("00011", "01111", "21001", "11001", "01111"), // 0이 벽, 1이 갈수 있는 곳, 2가 현재위치
        arrayOf("00011", "00011", "11111", "12101", "11111")
    )
    println(solution(boards).joinToString { it.toString() })
}
fun solution(boards: Array<Array<String>>): IntArray {
    var answer = intArrayOf()

    for (k in boards.indices) {
        val currentTable = boards[k]
        table = Array(currentTable.size) { Array(currentTable[0].toList().size) { ' ' } }

        var currentVertex = Vertex(0, 0, direction = 1) // 1 왼, 2 상, 3 오, 4 하
        // 그런 것 없음
//        방향중에 하나 내가 아래로 계속 했다. 근데 막힘 왼쪽, 위, 오른쪽 다 따져야함.
        // 그중 하나라도 모든 곳을 탐색을 할 수 있다? 이런 ~ 리턴
        // 아니다 모두 탐색할 수 없다 ~ 리턴
        for (i in currentTable.indices) {
            val row = currentTable[i].toList()
            for (j in row.indices) {
                if (row[j] == '2') {
                    currentVertex = currentVertex.copy(x = i, y = j)
                    table[i][j] = '1'
                } else {
                    table[i][j] = row[j]
                }
            }
        }

        var flag = false
        for (i in 1..4) {
            checker = Array(table.size) { Array(table[0].size) { false } }
            dfs(startVertex = currentVertex.copy(direction = i))
            println(checker)
        }
        println(table)
    }
    return answer
}
/*
2차원 테이블문제에서
방향이 있는 탐색 기억남?

현재 위치에서 방향 하나 정해 위왼 오 아래
이게 더이상 진행할 수 없을때까지 이 방향을 유지하고 직진함

그러다가 벽을 만나거나, 맵 밖을 나간다던가. 아니면 이미 탐색한 곳이다라고 했을 때 멈추고 새로운 방향으로 직진함

더이상 이동할 곳이 없으면 현재 자리에 꽃을 심는다.


그래서 벽이 아닌 곳을 모두 탐색할 수 있는가? 있다면 ~ 아니면 -1 했던거같은 //
 */

val dx = listOf(0, -1, 0, 1)
val dy = listOf(-1, 0, 1, 0)

fun dfs(startVertex: Vertex) {
    val currentVertex = startVertex
    val currentX = currentVertex.x
    val currentY = currentVertex.y
    val currentDirection = currentVertex.direction

    checker[currentX][currentY] = true

    var nextX = currentX + dx[currentDirection - 1]
    var nextY = currentY + dy[currentDirection - 1]

    val directionCheck = Array(4) { false }
    directionCheck[currentDirection - 1] = true
    var nextDirection = currentDirection


    if (nextX < 0 || nextX >= table.size || nextY < 0 || nextY >= table[0].size ||
        checker[nextX][nextY] || table[nextX][nextY] == '0'
    ) { // 맵 밖을 벗어나거나 벽인 경우, 아니면 꽃이 있는 경우
        var flag = false
        for (i in 0 until 4) {
            if (!directionCheck[i]) {
                nextDirection = i + 1
                nextX = currentX + dx[i]
                nextY = currentY + dy[i]
                if (nextX < 0 || nextX >= table.size || nextY < 0 || nextY >= table[0].size || table[nextX][nextY] == '0') {
                    return
                }
                if (!checker[nextX][nextY]) {
                    flag = true
                    dfs(Vertex(nextX, nextY, nextDirection))
                }
            }
        }
        if (!flag) {
            checker[nextX][nextY]
            return
        }
    } else {
        dfs(Vertex(nextX, nextY, nextDirection))
    }
}
data class Vertex(
    val x: Int,
    val y: Int,
    val direction: Int
)
