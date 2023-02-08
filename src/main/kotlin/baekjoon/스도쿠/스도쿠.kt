package baekjoon.스도쿠

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

val sudokuTable = Array(9) { Array(9) { 0 } }

data class Vertex(
    val x: Int,
    val y: Int
)
val blankList = arrayListOf<Vertex>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    for (i in 0 until 9) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            sudokuTable[i][j] = row[j]
            if (row[j] == 0) {
                blankList.add(Vertex(i, j))
            }
        }
    }
    dfs(0)
}

fun checkRowAndColumn(rowIndex: Int, columnIndex: Int, targetValue: Int): Boolean {
    var flag = true
    for (i in 0 until 9) {
        if (sudokuTable[rowIndex][i] == targetValue) return false
        if (sudokuTable[i][columnIndex] == targetValue) return false
    }
    return flag
}


fun checkSquare(rowIndex: Int, columnIndex: Int, targetValue: Int): Boolean {
    var flag = true

    var squareRowIndex = rowIndex / 3 // ex 0,1,2 =0 3,4,5 = 1 6,7,8 2
    var squareColumnIndex = columnIndex / 3

    squareRowIndex *= 3
    squareColumnIndex *= 3
    for (i in squareRowIndex until squareRowIndex + 3) {
        for (j in squareColumnIndex until squareColumnIndex + 3) {
            if (targetValue == sudokuTable[i][j]) {
                flag = false
                return flag
            }
        }
    }
    return flag
}

var flag = false
fun dfs(index: Int) {
    if (flag) {
        return
    }
    if (index == blankList.size) {
        flag = true
        sudokuTable.forEachIndexed { index, it->
            println(sudokuTable[index].joinToString(" ") { it.toString() })
        }
    } else {
        val vertexX = blankList[index].x
        val vertexY = blankList[index].y
        for (i in 1..9) {
            // 빈칸에 대입한다.
            if (checkRowAndColumn(vertexX, vertexY, i) && checkSquare(vertexX, vertexY, i)) {
                sudokuTable[vertexX][vertexY] = i
                dfs(index + 1)
                sudokuTable[vertexX][vertexY] = 0
            }
        }
    }
}
