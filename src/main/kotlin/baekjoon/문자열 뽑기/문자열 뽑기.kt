package baekjoon.`문자열 뽑기`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.regex.Pattern
import java.util.stream.Collectors

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

data class Group(
    val start: Int,
    val end: Int,
    val str: String
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for (i in 0 until n) {
        val str = readLine()
        println(merge(str))
    }
}

fun merge(s: String): Int {
    val group = Pattern.compile("aa+|bb+").matcher(s).results()
        .map {
            val group = it.group()
            val start = it.start()
            val end = it.end()
            Group(start, end, group)
        }.collect(Collectors.toList())
    if (group.size == 0) {
        return 0
    }
    val e = s.toList().toSet()
    if (e.size == 1) {
        return 1
    }

    for (i in group) {
        if (merge(s.substring(0, i.start) + s.substring(i.end)) == 1) {
            return 1
        }
    }
    return 0
}

/*
a와 b로만 이루어진 문자열 s가 있다.

 */
