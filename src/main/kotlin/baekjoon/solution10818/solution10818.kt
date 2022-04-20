package baekjoon.solution10818

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    require(n in 1..1000000)

    val arr = Array<Int>(n) { 0 }
    val second = readLine().split(" ")
    for (i in 0 until n) {
        arr[i] = second[i].toInt()
    }
    Arrays.sort(arr)
    println("${arr[0]} ${arr[n - 1]}")
}
