package baekjoon.solution1931

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
    val n = readLine().toString().toInt()
    val arr = arrayListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val line = readLine().split(" ").map {
            it.toInt()
        }
        val start = line[0]
        val end = line[1]
        arr.add(Pair(start, end))
    }
    val sortedArr = arr.sortedWith(Comparator<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }.thenComparator { o1, o2 -> o1.first - o2.first })

    var maxCount = 1
    var currentEnd = sortedArr[0].second
    for (i in 1 until sortedArr.size) {
        if (currentEnd <= sortedArr[i].first) {
            currentEnd = sortedArr[i].second
            maxCount++
        }
    }
    println(maxCount)
}
/*
   println("currentStart $currentStart, currentEnd $currentEnd")
//        var count = 1
//        if (maxCount != Integer.MIN_VALUE && sortedArr.size - (i + 2) <= maxCount) {
//
//        }else{
//            for (j in i + 1 until sortedArr.size) {
//                if (currentEnd <= sortedArr[j].first) {
//                    currentStart = sortedArr[j].first
//                    currentEnd = sortedArr[j].second
// //                println("$currentStart" + " " + "$currentEnd")
//                    count++
//                }
//            }
//            if (maxCount <= count) {
// //            println("count" + "$count")
//                maxCount = count
//            }
//        }
 */
