package baekjoon.solution2438

/**
 * @desc
 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 * @input
 * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 * @output
 * 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
 * @example
 *
 */

fun main() {
    val n = readLine()!!.toInt()
    solution(n)
}
fun solution(n: Int) {
    require(1 <= n)
    require(100 >= n)
    for (i in 1..n) {
        for (j in 0 until i) {
            print("*")
        }
        println()
    }
}
