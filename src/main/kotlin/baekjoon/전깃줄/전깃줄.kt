package baekjoon.전깃줄

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 *
 * @input
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
 * @output
 *
 * @example
 *
 */

data class Line(
    val left: Int,
    val right: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val map = HashMap<Line, MutableSet<Line>>()
    val list = arrayListOf<Line>()
    for (i in 1..n) {
        val (left, right) = readLine().split(" ").map { it.toInt() }
        list.add(Line(left, right))
    }

    list.sortBy { it.left }

    for (i in list) {
        val newLine = i
        val left = newLine.left
        val right = newLine.right
        if (!map.containsKey(newLine)) {
            map[newLine] = mutableSetOf()
        }
        for (j in map.entries) {
            if (left < j.key.left || right < j.key.right) {
                map[j.key]?.add(newLine)
                map[newLine]?.add(j.key)
            }
        }
    }

    val newMap = map.entries.sortedByDescending {
        it.value.size
    }.toMutableList()

    var count = 0
    while (!getBoolean(newMap)) {
        val removeCurrent = newMap[0]
        count++
        newMap.remove(removeCurrent)
        for (i in newMap) {
            if (i.value.contains(removeCurrent.key)) {
                i.value.remove(removeCurrent.key)
            }
        }
    }
    println(n - newMap.size)
}
fun getBoolean(list: MutableList<MutableMap.MutableEntry<Line, MutableSet<Line>>>): Boolean {
    var flag = true
    for (i in list) {
        if (i.value.size != 0) {
            flag = false
            break
        }
    }
    return flag
}
