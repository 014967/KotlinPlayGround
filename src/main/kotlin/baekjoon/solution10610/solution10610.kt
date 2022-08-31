package baekjoon.solution10610

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()

    if ("0" in n) {
        val arr = Array<Int>(n.length) { 0 }
        var sum = 0
        for (i in n.indices) {
            arr[i] = Character.getNumericValue(n[i])
            sum += Character.getNumericValue(n[i])
        }

        Arrays.sort(arr, reverseOrder())
        if (sum % 3 == 0) {
            // 30의 배수다
            val result = StringBuilder()
            arr.forEach {
                result.append(it.toString())
            }
            println(result)
        } else {
            // 각자리수의 합이 3의 배수가 아니라면
            println(-1)
        }
    } else {
        // 0 이 퐇마되어있지 않는다면
        println(-1)
    }
}
/*
TODO 배수 판정법
정수 m,n에 대해서 m이 n의 배수인지 확인할려면 m이 n으로 나누어 떨어지는지 확인하면 된다.

2의 배수 -> 일의 자리수가 0, 2, 4, 6, 8 인수
3의 배수 -> 각 자리수의 합이 3의 배수인것
4의 배수 -> 가장 끝의 두 자리수가 00이거나 4의 배수
5의 배수 -> 일의 자리수가 홀수면 5, 짝수면 0 인수
6의 배수 -> 2와 3의 공배수 , 짝수이면서 각 자리의 합이 3의 배수
7의 배수 -> 일의 자리를 두 배 한 것을 나머지 수에서 빼면 결과가 0 또는 7의배수가 나오는 수
8의 배수 -> 가장 끝의 세자리수가 000이거나 8의 배수
9의 배수 각 자리 숫자의 합이 9의 배수
11의 배수 홀수 자리의 합과 짝수 자리의 합의 차가 0이거나 11의 배수
13의 배수 -> 일의 자리를 4배 하고 나머지 자리에서 더한값이 13의 배수인 수
16의 배수 -> 끝의 네자리가 0000이거나 16의 배수
17의 배수 일의 자리를 5배 하여 나머지 자리에서 뺀값이 0이거나 17의 배수인 수

그렇다면 30의 배수라면 3과 10의 공배수
각 자리수의 합이 3의 배수이면서 끝자리가 0인 수 다.
 */
