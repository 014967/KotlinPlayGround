package baekjoon.`공유기 설치`

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, C) = readLine().split(" ").map { it.toInt() }
    require(N in 2..200000)
    require(C in 2..N)
    val arr = Array(N) { 0 }
    for (i in 0 until N) {
        val x = readLine().toInt()
        arr[i] = x
    }
    arr.sort()
    val low = 1
    val high = 1000000001
    search(arr, low, high, C)
}
fun search(arr: Array<Int>, low: Int, high: Int, c: Int) {
    var low = low
    var high = high
    while (low + 1 < high) {
        val mid = (low + high) / 2 // 인접한 두 거리
        var count = 1
        var prev = arr[0]
        for (i in 1 until arr.size) {
            if (arr[i] - prev >= mid) {
                count++
                prev = arr[i]
            }
        }

        if (count < c) {
            high = mid
        } else {
            // cont >= c
            low = mid
        }
    }
    println(low)
}
/*
1 - 2 - 4 - 8 - 9
1   1   1   1   1
2   0   2   2   2
3   0

집 N개가 수직선위에 있다. 각각 다른 좌표다.
공유기 C개를 설치하려고한다.
최대한 많은 곳에서 와이파이를 사용하려고함.
한 집에는 공유기 하나만 설치할 수 있고,
가장 인접한 두 공유기 사이의 거리를 가능한 크게 하려고함.
C개의 공유기를 N개의 집에 적당히 설치해서 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
https://blog.naver.com/jinhan814/222607789392
 */
