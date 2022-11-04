package baekjoon.개똥벌레

import baekjoon.solution2667.arr
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

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, H) = readLine().split(" ").map { it.toInt() }
    val upArr = arrayListOf<Int>()
    val downArr = arrayListOf<Int>()
    for (i in 0 until N) {
        val height = readLine().toInt()
        if (i % 2 == 0) {
            upArr.add(height)
        } else {
            downArr.add(height)
        }
    }
    upArr.sort()
    downArr.sort()

    var min = N // 전부 부시는 경우
    var result = 0
    for (i in 1..H) {
        val upCount = upArr.size - search(upArr, i - 0.5, 0, upArr.size - 1)
        val downCount = downArr.size - search(downArr, i - H + 0.5, 0, downArr.size - 1)
        if (min == upCount + downCount) {
            result++
        } else if (min > downCount + upCount) {
            result = 1
            min = downCount + upCount
        }
    }
    println("$min $result")
}
fun search(arr: ArrayList<Int>, target: Double, low: Int, high: Int): Int {
    var low = low
    var high = high
    while (low < high) {
        val mid = (low + high) / 2
        if (arr[mid] < target) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return high
}
/*
lower bound = 찾고자 하는 값 이상이 처음 나타나는 위치.
찾고자 하는 값 이상의 값이 처음 나타나는 위치를 찾아내기 위해 이분 탐색에서 조건을 변경

종유석과 석순을 따로 정렬을 함.
첫번째에서 걸리면 뒤까지 볼 필요가 없다. lower bound로 해야함. 첫번째로 걸리는 값까지

 */
