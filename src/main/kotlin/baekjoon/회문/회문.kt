package baekjoon.회문

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
    for (i in 0 until n) {
        val row = readLine()
        var left = 0
        var right = row.length - 1
        var count = 0
        while (left < right) {
            if (count >= 2) {
                break
            }
            if (row[left] == row[right]) {
                left++
                right--
            } else {
                count = 1
                // left와 right -1 이 같은지
                if (row[left] == row[right - 1] || row[left + 1] == row[right]) {
                    var rightCount = count
                    var leftCount = count
                    if (row[left] == row[right - 1]) {
                        // 각각 유사회문인지 확인
                        var nLeft = left
                        var nRight = right - 1
                        while (nLeft < nRight) {
                            if (rightCount >= 2) {
                                break
                            }
                            if (row[nLeft] == row[nRight]) {
                                nLeft++
                                nRight--
                            } else {
                                rightCount++
                            }
                        }
                    } else {
                        rightCount++
                    }
                    if (row[left + 1] == row[right]) {
                        var nLeft = left + 1
                        var nRight = right
                        while (nLeft < nRight) {
                            if (leftCount >= 2) {
                                break
                            }
                            if (row[nLeft] == row[nRight]) {
                                nLeft++
                                nRight--
                            } else {
                                leftCount++
                            }
                        }
                    }else{
                        leftCount++
                    }
                    if (leftCount == 2 && rightCount == 2) {
                        count = 2
                        break
                    } else {
                        count = 1
                        break
                    }
                }
//
                else if (row[left + 1] == row[right - 1]) {
                    count = 2
                    break
                } else {
                    count = 2
                    break
                }
            }
        }
        when (count) {
            0 -> {
                println(0)
            }
            1 -> {
                println(1)
            }
            else -> {
                println(2)
            }
        }
    }
}

/*
유사회문은 한글자만을 삭제해서 만들 수 회문으로 만들 수 있는는
*/
