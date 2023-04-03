package baekjoon.도서관

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max

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

lateinit var bookLocationList: MutableList<Int>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    bookLocationList = readLine().split(" ").map { it.toInt() }.toMutableList()
    bookLocationList.add(0)
    bookLocationList.sort()
    val zeroIndex = bookLocationList.indexOf(0)

    var answer = 0
    var leftIndex = 0
    while (leftIndex < zeroIndex) {
        answer += abs(bookLocationList[leftIndex] * 2)
        leftIndex += m
    }
    var rightIndex = bookLocationList.size - 1
    while (rightIndex > zeroIndex) {
        answer += bookLocationList[rightIndex] * 2
        rightIndex -= m
    }

    answer -= max(abs(bookLocationList[0]), abs(bookLocationList[n]))
    println(answer)
}
/*
책들의 원래 위치가 주어질때, 책을 모두 제자리에 놔둘때 드는 최소 걸음수를 계산하는 프로그램을 작성해라.

세준이는 한 걸음에 좌표  1칸씩가며, 책을 모두 제자리에 놔둔 후에는 다시 0으로 돌아올 필요없음
세준이는 한번에 최대 M권의 책을 둘 수 있다.
 */
