package baekjoon.좋은수열

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

var result = ""
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    dfs(0, n)
    println(result)
}

var flag = false
val numberList = listOf("1", "2", "3")
fun dfs(length: Int, depth: Int) {
    if (result.length >= 2) {
        var isSame = false
        for (i in 1..result.length / 2) {
            val left = result.substring(result.length - 2 * i, result.length - i)
            val right = result.substring(result.length - i, result.length)
            if (left == right) {
                isSame = true
                break
            }
        }
        if (isSame) {
            return
        }
    }
    if (flag) {
        return
    }
    if (length >= depth) {
        println(result)
        flag = true
        return
    }

    for (i in 0..2) {
        if (result.isNotEmpty() && (result.last().toString() == numberList[i])) {
            continue
        }
        result += numberList[i]
        dfs(length + 1, depth)
        result = result.dropLast(1)
    }
}
/*

규칙 1
이전 값과 같은 값으로 넣으면 안된다.

n = 1
1
n = 2
1 2
n = 3
1 2 3
n = 4
1 2 1 3
n = 5
1 2 1 3 1
n = 6
1 2 1 3 1 2
n = 7
1 2 1 3 1 2 1
n = 8
1 2 1 3 1 2 1 3 ->


 */
