package baekjoon.기타레슨

import java.io.BufferedReader
import java.io.InputStreamReader

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

var count = 0
var max = Integer.MIN_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]

    val arr = Array(n) { 0 }
    readLine().split(" ").map { it.toInt() }
        .forEachIndexed { index, i ->
            arr[index] = i
        }
    arr.sort()

    var low = 1
    var high = arr.sum()
    while (low <= high) {
        var count = 0
        val mid = (low + high) / 2 // 블루레이 길이
        var sum = 0
        for (i in arr.indices) {
            if (sum + arr[i] > mid) {
                sum = 0
                count++
            }
            sum += arr[i]
        }
        if (sum != 0) count++
        if (count <= m) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    println(low)
}

/*
기타 강의를 블루레이로 만들려고함
블루레이를 녹화할 때 강의의 순서가 바뀌면안됌.
i번 강의와 j번 강의를 블루레이에 녹화하려면 i 와 j 사이의 모든 강의도 블루레이여야함.
블루레이를 가급적 줄이려고함.
M개의 블루레이에 기타 동영상을 녹화하기로함.
이때 블루레이의 크기(녹화가능한 길이)를 최소로 하려고함. M개의 블루레이는 모두 같은 크기여얗마
각 강의의 길이가 분단위 자연수로 주어진다. 가능한 블루레이의 크기중 최소를 구해

1번에 1,2,3,4,5
2번에 6,7,
3번에 8,9
각블루레이의 크기는 15, 13, 17
블루레이의 크기는 모두 같아야해서 블루레이의 크기는 18이 된다.
 */
