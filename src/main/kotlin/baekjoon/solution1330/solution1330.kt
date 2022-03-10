package baekjoon.solution1330

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * @desc
 * 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 * @input
 * 첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
 * @output
 * 첫째 줄에 다음 세 가지 중 하나를 출력한다.
 * A가 B보다 큰 경우에는 '>'를 출력한다.
 * A가 B보다 작은 경우에는 '<'를 출력한다.
 * A와 B가 같은 경우에는 '=='를 출력한다.
 * @example
 * 1 2 -> <
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    solution(a, b)
}
fun solution(A: Int, B: Int) {
    require(-10000 < A)
    require(10000 > A)
    require(-10000 < B)
    require(10000 > B)
    if (A < B) {
        println("<")
    } else if (A> B) {
        println(">")
    } else {
        println("==")
    }
}
