package baekjoon.solution2583

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

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ")
    val m = str[0].toInt() // <=100
    val n = str[1].toInt() // <=100
    val k = str[2].toInt() // <=100

    val arr = Array(m) { Array(n) { 1 } }
    val checked = Array(m) { BooleanArray(n) { false } }

    val list = mutableListOf<Int>()
    for (i in 0 until k) {
        val input = readLine().split(" ")
        val leftX = input[1].toInt()
        val leftY = input[0].toInt()
        val rightX = input[3].toInt()
        val rightY = input[2].toInt()
        arrFill(arr, leftX, leftY, rightX, rightY)
    }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (!checked[i][j] && arr[i][j] == 1) {
                dfs(arr, checked, i, j)
                list.add(count)
                count = 0
            }
        }
    }
    println(list.size)
    list.sort()
    for (i in list.indices) {
        if (i != list.size - 1) {
            print("${list[i]} ")
        } else {
            print(list[i])
        }
    }
}

private fun dfs(arr: Array<Array<Int>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    count++
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in arr.indices && y in arr[0].indices && !checked[x][y] && arr[x][y] == 1) {
            dfs(arr, checked, x, y)
        }
    }
}
private fun arrFill(arr: Array<Array<Int>>, leftX: Int, leftY: Int, rightX: Int, rightY: Int) {
    if (leftX == 0) {
        for (i in 0 until rightX) {
            for (j in leftY until rightY) {
                arr[i][j] = 0
            }
        }
    } else {
        for (i in leftX until rightX) {
            for (j in leftY until rightY) {
                arr[i][j] = 0
            }
        }
    }
}
/*
(2,0), (4,4) -> (2,0), (2,1) , (2,2) (2,3)
                (3,0) , (3,1), (3,2), (3,3)
(1,1)(5,2) -> (1,1), (2,1),(3,1),(4,1)

(0,4) (2,6) -> (0,4),(0,5), (1,4),(1,5)

(0,4) (2,7) 이라면? -> (0,4),(0,5)(0,6), (1,4),(1,5)(1,6),
이렇게 접근했을 때, 채워지는 좌표들의 y 값은 마지막 좌표를 넘지않음. 왼쪽 y ~오른쪽 y-1까지
x의 값은 왼쪽의 x값이 0 일때는 오른쪽 x값 -1까지고, 아니라면 그냥 뺀 값 까지 채워진다.


 */
