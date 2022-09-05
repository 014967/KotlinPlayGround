package baekjoon.solution1783

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

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

    val line = readLine().split(" ").map { it.toInt() }
    val row = line[0] // row
    val column = line[1] // column

    // 우리가 원하는 결과값은 방문한 칸의 갯수
    when (row) {
        1 -> {
            println(1)
        }
        2 -> {
            val count = min(4, (column + 1) / 2)
            println(count)
        }
        else -> {
            if (column <= 6) println(min(4, column))
            else println(column - 2)
        }
    }
}
/*
 어렵다 참고했다
 */