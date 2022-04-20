package baekjoon.solution4344

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = ArrayList<List<Int>>()
    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }.toList()
        list.add(line)
    }
    for (i in list) {
        var result = 0
        for (j in 0 until i.size) {
            if (j != 0) {
                result += i[j]
            }
        }
        var avg = result / i[0]
        var count = 0.toDouble()
        for (j in 1 until i.size) {
            if (i[j] > avg) {
                count++
            }
        }
        var percentage = (count / i[0].toDouble()) * 100
//        println(round(percentage * 100000) / 1000) 소수점 지정 불가능
        println("${String.format("%.3f", percentage)}%")
    }
}
