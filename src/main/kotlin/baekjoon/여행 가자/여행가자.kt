package baekjoon.`여행 가자`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

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

lateinit var parentTable: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    parentTable = Array(n + 1) { it }

    for (i in 1..n) {

        // table 1 ,2 ,3
        val cityInfo = readLine().split(" ").map { it.toInt() }
        for (j in cityInfo.indices) {
            if (cityInfo[j] == 1) {
                union(i, j + 1)
            }
        }
    }
    val tour = readLine().split(" ").map { it.toInt() }
    val start = tour[0]
    for (i in 1 until tour.size) {
        if (parentTable[tour[i]] != parentTable[start]) {
            println("NO")
            exitProcess(0)
        }
    }

    println("YES")
}

fun union(start: Int, end: Int) {
    val startParent = getParent(start)
    val endParent = getParent(end)
    if (startParent < endParent) {
        parentTable[endParent] = startParent
    } else {
        parentTable[startParent] = endParent
    }
}
fun getParent(city: Int): Int {
    if (city != parentTable[city]) {
        parentTable[city] = getParent(parentTable[city])
    }
    return parentTable[city]
}
