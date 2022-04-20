package baekjoon.solution2750

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
    val n = readLine().toInt()
    val arr = Array<Int>(n) { 0 }
    for (i in 0 until n) {
        arr[i] = readLine().toInt()
    }
    // bubbleSort(arr)
    // selectionSort(arr)
    insertionSort(arr)
    arr.forEach { println(it) }
}
fun bubbleSort(arr: Array<Int>) {
    for (i in arr.size - 1 downTo 0) {
        // 맨뒤부터 하나씩 줄여나간다.
        for (j in 0 until i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}
fun selectionSort(arr: Array<Int>) {
    for (i in 0 until arr.size - 1) {
        var minIdx = i
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j
            }
        }
        if (minIdx != i) {
            val temp = arr[minIdx]
            arr[minIdx] = arr[i]
            arr[i] = temp
        }
    }
}
fun insertionSort(arr: Array<Int>) {
    for (i in 1 until arr.size) {
        for (j in i downTo 1) {
            if (arr[j - 1] > arr[j]) {
                val temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
            }
        }
    }
}
