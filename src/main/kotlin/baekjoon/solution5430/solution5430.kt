package baekjoon.solution5430

import baekjoon.solution2667.arr
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for (i in 1..t) {
        val p = readLine() // rd
        val n = readLine().toInt() // 배열 크기
        var arr = LinkedList<String>()


        val inputArr = readLine().drop(1).dropLast(1).split(",").toMutableList()
        arr.addAll(inputArr)

        if (n < p.count { c -> c == 'D' }) {
            println("error")
            continue
        }
        var direction = true
        for (j in p) {
            if (j == 'R') {
                direction = !direction
            } else {
                if (direction) { // 정방향
                    arr.removeFirst()
                } else {
                    arr.removeLast()
                }
            }
        }
        if (!direction) {
            arr.reverse()
        }
        println("[" + arr.joinToString(",") { it } + "]")
    }
}
