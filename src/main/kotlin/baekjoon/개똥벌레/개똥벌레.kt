package baekjoon.개똥벌레

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


//fun main(): Unit= with(BufferedReader(InputStreamReader(System.`in`))) {
//    val str = readLine().split(" ").map { it.toInt() }
//    val N = str[0]
//    val H = str[1]
//
//    val arr = Array(H) { Array(N) { 0 } }
//    var type = false // true = up , false = down
//    for (i in 0 until N) {
//        type = !type
//        val height = readLine().toInt()
//        if (type) {
//            // up
//            for (j in H - 1 downTo H - height) {
//                arr[j][i] = 1
//            }
//        } else {
//            // down
//            for (j in 0 until height) {
//                arr[j][i] = 1
//            }
//        }
//    }
//    val blockArr = Array(H) { 0 }
//
//    for (i in arr.indices) {
//        blockArr[i] = arr[i].sum()
//    }
//
//    var min = Integer.MAX_VALUE
//    for (i in blockArr) {
//        min = min.coerceAtMost(i)
//    }
//    println(
//        "$min ${blockArr.count { it == min }}"
//    )
//}
/*
동굴의 길이 N, 높이는 H
N은 짝수
첫 번째 장애물은 항상 석순이고, 그다음부터 종유석과 석순이 벌갈아가면서 등장한다.

 */
