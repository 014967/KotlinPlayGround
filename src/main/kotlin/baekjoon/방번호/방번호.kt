package baekjoon.방번호

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Character.getNumericValue
import kotlin.system.exitProcess

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

data class Number(
    val target: Int,
    val money: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val pArray = Array(N) { Number(0, 0) }

    val targetAndMoneyMap = HashMap<Int, Int>()

    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        pArray[index] = Number(index, i)
        targetAndMoneyMap[index] = i
    }
    pArray.sortWith(comparator = Comparator<Number> { o1, o2 -> o1.money - o2.money }.thenComparator { a, b -> b.target - a.target })

    /*
    target = 0 , money = 6
    target = 1 , money = 7
    target = 2 , money = 8
     */
    val targetMoney = readLine().toInt() // 21

    val initResult = StringBuilder()
    var lessMoney = 0

    if (pArray.size == 1) {
        println(0)
        exitProcess(0)
    }
    if (pArray[0].target == 0) {
        val lessTargetMoney = targetMoney - pArray[1].money
        if (lessTargetMoney < 0) {
            initResult.append("0")
        } else {
            initResult.append(pArray[1].target.toString())
            val count = lessTargetMoney / pArray[0].money
            lessMoney = lessTargetMoney % pArray[0].money
            repeat(count) {
                initResult.append(pArray[0].target.toString())
            }
        }
    } else {

        val count = targetMoney / pArray[0].money
        lessMoney = targetMoney % pArray[0].money
        repeat(count) {
            initResult.append(pArray[0].target.toString())
        }
    }

    val max = initResult.length
    var startIndex = 0
    while (startIndex < max) {
        val indexTarget = getNumericValue(initResult[startIndex])
        val indexMoney = targetAndMoneyMap[indexTarget]!!

        lessMoney += indexMoney

        var flag = false
        for (i in pArray.size - 1 downTo 0) {
            if (pArray[i].money <= lessMoney && indexTarget < pArray[i].target) {
                initResult.replace(startIndex, startIndex + 1, pArray[i].target.toString())
                lessMoney -= pArray[i].money
                flag = true
                break
            }
        }
        if (!flag) {
            lessMoney -= indexMoney
        }
        startIndex++
    }

    println(initResult.toString())
}

/*
가장 큰수를 만들기 위해서는 비용이 가장 적은 숫자를 최대한 많이 산다.
맨 앞자리에 0이 오면 안되나까, 비용이 두 번째로 적은 숫자를 하나 사서,
맨 앞자리에 배치하고 나머지는 비용이 가장 적은 숫자로 채운다.

4
5 3 2 1
1
 */
