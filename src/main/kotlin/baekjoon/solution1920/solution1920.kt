package baekjoon.solution1920

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @desc
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * @input
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.
출력
 * @output
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 * @example
 *
 */

/*
1. 무엇을 탐색할 것인가?
이분 탐색 할 것 : 정수
비교대상 : n
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    val input = readLine().split(" ").map { it.toInt() }
    for (i in input.indices) {
        arr[i] = input[i]
    }
    val m = readLine().toInt()
    val arr2 = IntArray(m)
    val input2 = readLine().split(" ").map { it.toInt() }
    for (i in input2.indices) {
        arr2[i] = input2[i]
    }
    Arrays.sort(arr)
    for (i in arr2) {
        // 존재하는가?
        var result = binarySearch(arr, i)
        println(result)
    }
}
fun binarySearch(array: IntArray, n: Int): Int {
    var start = 0
    var end = array.size - 1
    var mid = 0
    var answer = 0
    while (start <= end) {
        mid = (start + end) / 2
        if (array[mid] == n) {
            answer = 1
            break
        } else {
            if (array[mid] < n) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }
    return answer
}
