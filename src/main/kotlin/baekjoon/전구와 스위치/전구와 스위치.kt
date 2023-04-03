package baekjoon.`전구와 스위치`

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 *
 * @input
3
000
010
 * @output
 *
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = Array(2) { booleanArrayOf() }
    val arrSet0 = Array(2) { booleanArrayOf() }

    for (i in 1..2) {
        val type = readLine().toMutableList()
        val booleanArray = BooleanArray(type.size) { false }
        for (j in type.indices) {
            if (type[j] == '1') {
                booleanArray[j] = true
            }
        }
        arr[i - 1] = booleanArray
        arrSet0[i - 1] = booleanArray.clone()
    }

    var count1 = -1
    var count2 = -1

    arrSet0[0][0] = !arrSet0[0][0]
    arrSet0[0][1] = !arrSet0[0][1]

    for (i in 1 until arrSet0[0].size) {
        // 0번째 스위치가 눌렸을때
        if (i == 1) {
            count1 = 1
        }
        if (arrSet0[0][i - 1] != arrSet0[1][i - 1]) {
//                0번째 스위착 눌렸고, 상태가 다르다면 다음꺼를 눌러야한다.
            arrSet0[0][i - 1] = !arrSet0[0][i-1]
            arrSet0[0][i] = !arrSet0[0][i]
            if (i + 1 != arrSet0[0].size) {
                arrSet0[0][i + 1] = !arrSet0[0][i+1]
            }
            count1++
        }
    }
    if (!arrSet0[0].contentEquals(arrSet0[1])) {
        count1 = -1
    }

    for (i in 1 until arr[0].size) {
        if (i == 1) {
            count2 = 0
        }
        // 0번째 스위치가 눌리지 않았다면
        if (arr[0][i - 1] != arr[1][i - 1]) {
            // 0번째 스위치가 눌리지 않았지만, 상태가 달라서 다음꺼를 눌러야한다면
            arr[0][i - 1] = !arr[0][i-1]
            arr[0][i] = !arr[0][i]
            if (i + 1 != arr[0].size) {
                arr[0][i + 1] = !arr[0][i+1]
            }
            count2++
        }
    }
    if (!arr[0].contentEquals(arr[1])) {
        count2 = -1
    }

    if (count1 == -1 || count2 == -1) {
        println(maxOf(count1, count2))
    } else {
        println(minOf(count1, count2))
    }
}
