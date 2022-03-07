package baekjoon.solution1001

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    print(minus(a, b))
}
fun minus(a: Int, b: Int): Int {
    return a - b
}
