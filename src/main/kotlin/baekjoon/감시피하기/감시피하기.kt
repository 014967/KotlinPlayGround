package baekjoon.감시피하기

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

data class Coordinate(
    val x: Int,
    val y: Int
)

val teacherList = arrayListOf<Coordinate>()
val xList = arrayListOf<Coordinate>()
lateinit var table: Array<Array<String>>
var N = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    table = Array(N) { Array(N) { " " } }

    require(N in 3..6)
    for (i in 1..N) {
        val row = br.readLine().split(" ")
        for (j in row.indices) {
            if (row[j] == "T") {
                teacherList.add(Coordinate(i - 1, j))
            }
            if (row[j] == "X") {
                xList.add(Coordinate(i - 1, j))
            }
            table[i - 1][j] = row[j]
        }
    }

    dfs(0, 0)

    println("NO")
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)

fun dfs(index: Int, count: Int) {
    if (count == 3) {
        if (bfs()) {
            println("YES")
            exitProcess(0)
        }
        return
    }


    for (i in index until xList.size) {
        val x = xList[i].x
        val y = xList[i].y
        table[x][y] = "O"
        dfs(index + 1, count + 1)
        table[x][y] = "X"
    }
}
fun bfs(): Boolean {
    for ((x, y) in teacherList) {
        for (index in 0 until 4) {
            var nextX = x
            var nextY = y
            while (true) {
                nextX += dx[index]
                nextY += dy[index]
                if (nextX !in table.indices || nextY !in table[0].indices || table[nextX][nextY] == "O") {
                    break
                }
                if (table[nextX][nextY] == "S") {
                    return false
                }
            }
        }
    }

    return true
}
