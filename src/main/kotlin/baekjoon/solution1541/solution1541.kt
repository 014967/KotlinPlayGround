package baekjoon.solution1541

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
    val str = readLine().toString()
    val list = arrayListOf<String>()

    val s = StringBuilder()
    for (i in str) {
        when (i) {
            '-' -> {
                if (s.isNotEmpty()) {
                    list.add(s.toString())
                    s.clear()
                }

                list.add("-")
            }
            '+' -> {
                if (s.isNotEmpty()) {
                    list.add(s.toString())
                    s.clear()
                }
                list.add("+")
            }
            else -> {
                s.append(i)
            }
        }
    }
    if (s.isNotEmpty()) {
        list.add(s.toString())
        s.clear()
    }
    var index = 0
    var result = 0
    while (index != list.size) {
        if (list[index] == "-") {
            var temp = 0
            index++
            while (true) {
                if ( index == list.size || list[index] == "-") {
                    result -= temp
                    break
                } else {
                    if (list[index] == "+") {
                        temp += list[++index].toInt()
                    } else {
                        temp = list[index].toInt()
                    }
                    index++
                }
            }
        } else {
            if (list[index] == "+") {
                result += list[++index].toInt()
            } else {
                result += list[index].toInt()
            }
            index++
        }
    }

    println(result)
}
