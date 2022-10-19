package baekjoon.solution5052

import baekjoon.solution2667.arr
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
    val t = readLine().toInt()

    for (i in 1..t) {
        val map = HashMap<String, Int>()
        val n = readLine().toInt()
        var arr = mutableListOf<String>()
        for (j in 1..n) {
            val number = readLine().toString()
            arr.add(number)
        }
        arr.sort()
        var flag = false
        val min = arr[0].length
        for (j in 0 until arr.size - 1) {
            if (arr[j + 1].startsWith(arr[j])) {
                flag = true
                break
            }
        }

        /*
        911
        97625999

        911  -> 작은 길이
        976 -> map
        9762
        97625 -> map

        map


         */
        for (j in arr) {
            val dummy = StringBuilder()
            for (b in 0 until min) {
                dummy.append(j[b])
            }
            if (map.containsKey(dummy.toString())) {
                if (map[dummy.toString()] != null) {
                    val count = map[dummy.toString()]
                    if (count != null) {
                        map[dummy.toString()] = count + 1
                    }
                }
            } else {
                map[dummy.toString()] = 1
            }
            for (s in min until j.length) {
                dummy.append(j[s])

                if (map.containsKey(dummy.toString())) {
                    if (map[dummy.toString()] != null) {
                        val count = map[dummy.toString()]
                        if (count != null) {
                            map[dummy.toString()] = count + 1
                        }
                    }
                } else {
                    map[dummy.toString()] = 1
                }
            }
        }
        for (j in arr) {
            if (map.containsKey(j)) {
                if (map[j] != 1) {
                    flag = true
                    break
                }
            }
        }
        if (flag) {
            println("NO")
        } else {
            println("YES")
        }
    }
}
