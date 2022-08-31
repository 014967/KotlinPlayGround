package baekjoon.solution1789

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 * @input
 * 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
 * @output
 * 첫째 줄에 자연수 N개의 최댓값을 출력한다.
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    // 서로 달라야하니때문에 1 부터 1씩 차근차근 더해간다
    // Int의 범위는 	–2,147,483,648 ~ 2,147,483,647
    // 따라서 Long의 범위로 받는다.
    val S = readLine().toLong() // 1 <= S <= 4,294,967,295
    var sum = 0L
    var num = 1L
    while (true) {

        sum += num
        if (sum > S) {
            break
        }
        num++
    }
    println(--num)
}

/*
sum num
0   1   = 1
1  2   = 3
3  3 = 6
6 4 = 10
 */
