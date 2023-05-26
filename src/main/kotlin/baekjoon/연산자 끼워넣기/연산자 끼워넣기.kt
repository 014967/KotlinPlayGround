package baekjoon.`연산자 끼워넣기`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

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
var min = Integer.MAX_VALUE
var max = Integer.MIN_VALUE
var originOperatorCount = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }

    // nList 0 .. n-1
    val operatorArray = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    br.close()
    originOperatorCount = operatorArray.sum()
    // operatorList의 각 원소의 갯수의 합은 N-1이다.
    getMinAndMax(nList, currentIndex = 1, totalValue = nList[0], operatorArray, 0)
    println(max)
    println(min)
}

fun getMinAndMax(nList: List<Int>, currentIndex: Int, totalValue: Int, operatorArray: Array<Int>, operatorCount: Int) {
    if (operatorCount == originOperatorCount) {
        // 계산하기
        if (min > totalValue) {
            min = totalValue
        }
        if (max < totalValue) {
            max = totalValue
        }
        return
    }
    for (i in operatorArray.indices) {
        if (operatorArray[i] != 0) {
            val copyArray = operatorArray.copyOf()
            copyArray[i]--
            val newTotalValue = calculate(i, totalValue = totalValue, currentValue = nList[currentIndex])
            getMinAndMax(nList, currentIndex + 1, newTotalValue, copyArray, operatorCount + 1)
        }
    }
}
fun calculate(operator: Int, totalValue: Int, currentValue: Int): Int {
    return when (operator) {
        0 -> {
            // 덧셈
            totalValue + currentValue
        }
        1 -> {
            // 뺄셈
            totalValue - currentValue
        }
        2 -> {
            // 곱셈
            totalValue * currentValue
        }
        else -> {
            // 나눗셈
            if (totalValue < 0) {
                -(abs(totalValue) / currentValue)
            } else {
                totalValue / currentValue
            }
        }
    }
}
