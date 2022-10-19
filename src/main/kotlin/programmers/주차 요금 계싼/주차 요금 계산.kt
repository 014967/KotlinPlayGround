package programmers.`주차 요금 계싼`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.ceil

/**
 * @desc
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val solution = Solution()
    val fees = intArrayOf(120, 0, 60, 591)
    val records = arrayOf(
        "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"
    )
    solution.solution(fees, records).forEach {
        println(it)
    }
}

data class TimeType(
    val time: Int,
    val type: String
)

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer = arrayListOf<Int>()

        require(fees.size == 4)
        require(records.size in 1..1000)

        val basicTime = fees[0]
        val basicMoney = fees[1]
        val unitTime = fees[2]
        val unitMoney = fees[3]

        val map = HashMap<Int, ArrayList<TimeType>>()

        for (i in records) {
            val str = i.split(" ")
            val time = str[0]

            val s = time.split(":").map { it.toInt() }
            val mmTime = s[0] * 60 + s[1]

            val carNumber = str[1].toInt()
            val type = str[2]

            if (map.contains(carNumber)) {
                val arr = map[carNumber]
                arr!!.add(TimeType(mmTime, type))
                map[carNumber] = arr
            } else {
                val arr = arrayListOf<TimeType>()
                arr.add(TimeType(mmTime, type))
                map[carNumber] = arr
            }
        }

        for (i in map.toSortedMap()) {
            var result = 0
            if (i.value.size % 2 == 0) {
                val totalTime = i.value.asSequence().chunked(2).map {
                    // 차량 별로 out 에서 in을 빼버린다.
                    it[1].time - it[0].time
                }.reduce { total, num ->
                    total + num
                }
                result += if (totalTime <= basicTime) {
                    basicMoney
                } else {
                    val x = (totalTime.toFloat() - basicTime.toFloat()) / unitTime.toFloat()
                    basicMoney + (ceil(x).toInt() * unitMoney)
                }
            } else {
                // 출차 기록이 되지 않음
                i.value.add(TimeType(23 * 60 + 59, type = "Out"))
                val totalTime = i.value.asSequence().chunked(2).map {
                    // 차량 별로 out 에서 in을 빼버린다.
                    it[1].time - it[0].time
                }.reduce { total, num ->
                    total + num
                }
                result += if (totalTime <= basicTime) {
                    basicMoney
                } else {
                    val x = (totalTime.toFloat() - basicTime.toFloat()) / unitTime.toFloat()
                    basicMoney + (ceil(x).toInt() * unitMoney)
                }
            }
            answer.add(result)
        }

        return answer.toIntArray()
    }
}

/*
요금표
가본 시간
기본 요금
단위 시간
단위 요금

주차요금을 나타내는 정 수 배열 fees
자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주엊미.

차랴 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return하도록 solution
 */
