package baekjoon.solution1744

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

var zeroCount = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = arrayListOf<Int>()
    var result = 0

    var plusList = mutableListOf<Int>()
    var minusList = mutableListOf<Int>()

    for (i in 1..n) {
        val k = readLine().toInt()
        if (k <0) {
            minusList.add(k)
        } else if (k == 0) {
            zeroCount++
        } else {
            if (k == 1) {
                result++ // 1 은 다 더해 준다
            } else {
                plusList.add(k)
            }
        }
    }

    plusList.sort()
    minusList.sortDescending() // 반대로 -1 -2 -3 -4

    result += handleSequence(plusList, plusList.size) + handleSequence(minusList, minusList.size)

    if (minusList.size % 2 != 0 && zeroCount != 0) {
        result -= minusList[0] // 다시 더해준다
    }

    println(result)
}

fun handleSequence(sequence: MutableList<Int>, numOfSequece: Int): Int {
    return when {
        numOfSequece == 0 -> 0
        numOfSequece == 1 -> sequence[0]

        numOfSequece % 2 == 0 -> sequence.chunked(2).map {
            it[0] * it[1]
        }.reduce { sum, num ->
            sum + num // += 랑 같음
        }
        else -> sequence[0] + // 음수는 더해줌
            sequence.subList(1, numOfSequece)
                .chunked(2).map { it[0] * it[1] }
                .reduce { sum, num -> sum + num }
    }
}


/*
1은 곱하는 것보다 더하는게 더 커져서 1은 미리 더해뒁.
https://best-human-developer.tistory.com/8
 */