package baekjoon.solution13305

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

    val cityCount = readLine().toInt()
    require(
        cityCount in 2..100000
    )
    val roadList = readLine().split(" ").map {
        it.toLong()
    }
    require(roadList.size == cityCount - 1)

    val cityArr = Array<Long>(cityCount) { 0L }

    readLine().split(" ").mapIndexed { index: Int, s: String ->
        cityArr[index] = s.toLong()
    }

    var index = 0
    var totalPrice = 0L
    var currentPrice = cityArr[index]
    var saveIndex = 0
    while (index + 1 < cityArr.size) {
        if (currentPrice <= cityArr[index + 1] && index + 1 != cityArr.size - 1) {
            // 현재의 가격이 다음 도시의 가격보다 작거나 같다면?
            index++
        } else {
            var roadLength = 0L
            for (i in saveIndex until index + 1) {
                roadLength += roadList[i]
            }
            totalPrice += roadLength * currentPrice
            saveIndex = index + 1
            currentPrice = cityArr[index + 1]
            index++

            // 현재 가격보다 더 작은 도시를 찾았다
        }
    }
    println(totalPrice)
}
