package baekjoon.solution9237

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    val growingList = mutableListOf<Int>()
    val tList = readLine().split(" ").map {
        it.toInt()
    }.sortedDescending().toMutableList()

    var dayCount = 1
    while (tList.isNotEmpty() || growingList.isNotEmpty()) {

        growingList.mapIndexed { index, tree ->
            growingList[index] = tree - 1 // 하루씩 자라게 함
        }
        growingList.filter {
            it == 0 // 다자라면 지움
        }.map {
            growingList.remove(it)
        }
        if (tList.isNotEmpty()) {

            growingList.add(tList[0]) // 심기
            tList.remove(tList[0])
        }
        dayCount++
    }
    println(dayCount)
}
