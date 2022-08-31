package baekjoon.solution2644

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

var count = -1
var result = -1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val totalNum = readLine().toInt()
    val calPerson = readLine().split(" ")
    val cal1 = calPerson[0].toInt()
    val cal2 = calPerson[1].toInt()
    val relation = readLine().toInt()

    val arr = Array(totalNum + 1) { mutableListOf<Int>() }
    val checked = Array(totalNum + 1) { false }
    for (i in 1..relation) {
        val str = readLine().split(" ")
        val parent = str[0].toInt()
        val child = str[1].toInt()
        arr[parent].add(child)
        arr[child].add(parent)
    }
    dfs(arr, cal1, cal2, checked)
    println(result)
}
fun dfs(arr: Array<MutableList<Int>>, start: Int, end: Int, checked: Array<Boolean>) {

    count++
    checked[start] = true
    if (start == end) {
        result = count
        return
    }
    for (i in arr[start]) {
        if (!checked[i]) {
            dfs(arr, i, end, checked)
        }
    }
    count--
}
