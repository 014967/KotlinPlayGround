package baekjoon.좋다

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
    val N = readLine().toInt()
    val A = readLine().split(" ").map { it.toInt() }.sorted()

    var result = 0
    for (i in A.indices) {
        val findNumber = A[i] // 값들 target 이게 good number?
        var leftIndex = 0
        var rightIndex = A.lastIndex
        while (leftIndex < rightIndex) { // leftIndex < rightIndex
            val sum = A[leftIndex] + A[rightIndex] // 선택 한 두수 더하기
            if (findNumber == sum) { // 합으로 만들려는 수였냐?
                println("$leftIndex $rightIndex")
                println(findNumber)
                // 내가 선택한 값과 확인 하는 값이 다르도록 !

                if (i == leftIndex) {
                    // i findNumber 인덱스 내가 선택수의 index 같냐?
                    leftIndex++
                } else if (i == rightIndex) { // 끝자리면 내려
                    rightIndex--
                } else {
                    result++
                    break
                }
            }

            if (A[leftIndex] + A[rightIndex] > findNumber) {
                rightIndex--
            } else if (A[leftIndex] + A[rightIndex] < findNumber) {
                leftIndex++
            }
        }
    }

    println(result)
}

/*
N개의 수중에서 어떤 수가 다른 수 두개의 합으로 나타낼 수 있다면 "좋다"라고 한다.

값이 음수도 포함한다.

 */
