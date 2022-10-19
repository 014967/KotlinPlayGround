package baekjoon.solution10844

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
    val length = readLine().toInt()
    val dp = Array(length + 1) { arrayListOf<String>() }
    dp[1] = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    dp[2] = arrayListOf("10", "12", "21", "23", "32", "34", "43", "45", "54", "56", "65", "67", "76", "78", "87", "89", "98")

    if (length <= 2) {
        println(dp[length].size)
    } else {
        for (i in 3..length) {
            dp[i] = arrayListOf()
            dp[i - 1].forEach {
                val target = it
                val last = Character.getNumericValue(target.last())
                if (last != 0) {
                    val left = last - 1
                    val newValue1 = target + left.toString()
                    dp[i].add(newValue1)

                    if (last != 9) {
                        val right = last + 1
                        val newValue2 = target + right.toString()
                        dp[i].add(newValue2)
                    }
                } else {
                    // 0 일때
                    val right = last + 1
                    val newValue3 = target + right.toString()
                    dp[i].add(newValue3)
                }
            }
        }
    }
    println(dp[length].size % 1000000)
}
/*
// 각 줄의 마지막에 +1 -1한 값, 근데 자리수가 바뀌면 안됨
1  + 0 ,2
2 + 1, 3
3 + 2 ,4
4 + 3, 5
5
6
7
8
9

10, 12 2
21, 23 4
32, 34 6
43, 45 8
54, 56 10
65, 67 12
76, 78 14
87, 89 16
98,    17

if (3)
101, 121 ,123
21 -> 210 212 ,  232, 234
 */
