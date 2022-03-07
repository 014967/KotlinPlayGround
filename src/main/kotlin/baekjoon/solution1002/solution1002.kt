package baekjoon.solution1002

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")

    val a = st.nextToken().toDouble()
    val b = st.nextToken().toDouble()

    print(divide(a, b))
}
fun divide(a: Double, b: Double): Double {
    require(a > 0 && b < 10)
    return a / b
}
