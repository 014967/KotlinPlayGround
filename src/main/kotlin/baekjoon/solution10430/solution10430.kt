package baekjoon.solution10430

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
 * @input
첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
 * @output
첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C,
셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var str = readLine().split(" ")
    val a = str[0].toInt()
    val b = str[1].toInt()
    val c = str[2].toInt()
    val first = (a + b) % c
    val second = ((a % c) + (b % c)) % c
    val third = (a * b) % c
    val fourth = ((a % c) * (b % c)) % c
    println(first)
    println(second)
    println(third)
    println(fourth)
}
