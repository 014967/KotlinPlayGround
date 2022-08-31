package programmers.solution

import kotlin.math.ceil

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

fun main() {
    val fees = intArrayOf(180, 5000, 10, 600)
    // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
    val records = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )
    val solution18 = Solution18()
    println(solution18.solution(fees, records))
}

class Solution18 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer = arrayListOf<Int>()

        val basicTime = fees[0]
        val basicMoney = fees[1]
        val unitTime = fees[2]
        val unitMoney = fees[3]

        val maxTime = 23 * 60 + 59
        val table = LinkedHashMap<String, MutableList<Pair<String, Int>>>()
        for (i in records) {
            val arr = i.split(" ")
            val time = arr[0].split(":")
            val tTime = time[0].toInt() * 60 + time[1].toInt()

            val number = arr[1]
            val type = arr[2]
            if (table.containsKey(number)) {
                val mList = table[number]!!
                mList.add(Pair(type, tTime))
                table[number] = mList
            } else {
                table[number] = mutableListOf(Pair(type, tTime))
            }
        }
        val sortedTable = table.toSortedMap()

        for (i in sortedTable) {

            var money = basicMoney
            var time = 0
            var inTime = 0

            if (i.value.size % 2 != 0) {
                // 입차는 하고 출차를 하지 않은 경우

                for (j in 0 until i.value.size - 1) {
                    // 마지막 인덱스 전까지 주차 시간을 구한다.
                    if (i.value[j].first == "IN") {
                        inTime = i.value[j].second
                    } else {
                        time += i.value[j].second - inTime
                    }
                }
                // 누적시간
                time += (maxTime - i.value[i.value.size - 1].second)

                // 기본 시간 초과 여부 계산

                if (time > basicTime)
                    money += ceil((time - basicTime).toDouble() / unitTime.toDouble()).toInt() * unitMoney

                answer.add(money)
            } else {
                for (j in i.value.indices) {
                    if (i.value[j].first == "IN") {
                        inTime = i.value[j].second
                    } else {
                        time += i.value[j].second - inTime
                    }
                }
                if (time > basicTime)
                    money += ceil((time - basicTime).toDouble() / unitTime.toDouble()).toInt() * unitMoney
                answer.add(money)
            }
        }
        return answer.toIntArray()
    }
}
