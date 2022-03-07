package baekjoon.solution1000

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    val a: Int = st.nextToken().toInt()
    val b: Int = st.nextToken().toInt()

    print(plus(a, b))
}
fun plus(a: Int, b: Int): Int {
    return a + b
}
