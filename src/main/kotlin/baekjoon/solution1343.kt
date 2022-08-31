package baekjoon

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

val A = "AAAA"
val B = "BB"

fun transAB(dummy: String): String {
    var result = ""
    if (dummy.length % 2 != 0 && dummy.isNotEmpty()) { // A나 B로 치환할 수 없는 경우
        result = "-1"
    } else {
        var aCount = dummy.length / 4

        if (dummy.length % 4 == 0 && dummy.isNotEmpty()) {
            // a로 모두 치환이 가능한 경우
            var a = StringBuilder()
            for (j in 1..aCount) {
                a.append(A)
            }
            result = a.toString()
        } else {
            // a로 치환이 불가능한 경우 a,b가 석여 있는
            var ab = StringBuilder()
            if (aCount != 0) {
                for (j in 1..aCount) {
                    ab.append(A) // a 추가
                }
            }
            ab.append(B) // b 추가 b는 1개일 수밖에 없음
            result = ab.toString()
        }
    }
    return result
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val BOARD = readLine().toString()

    var flag = false
    var result = StringBuilder()
    var dummy = StringBuilder()  //

    var i = 0
    while (i != BOARD.length) {
        if (dummy.isNotEmpty() && BOARD[i] == '.') {
            val s = transAB(dummy.toString())
            if (s == "-1") {
                flag = true
                break
            } else {
                result.append(s)
                if (BOARD[i] == '.')
                    result.append('.')
            }
            dummy.clear()
        } else {
            if (dummy.isEmpty() && BOARD[i] == '.')
                result.append('.')
            else { // . 가 아닌 경우 dummy에 추가한다
                dummy.append(BOARD[i])
            }
        }
        i++
    }
    if (dummy.isNotEmpty()) {
        val s = transAB(dummy.toString())
        if (s == "-1") {
            flag = true
        } else {
            result.append(s)
        }
    }

    if (flag) {
        println(-1)
    } else {
        println(result)
    }
}
