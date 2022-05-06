package programmers.solution

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

fun main() {
    val expression = "50*6-3*2"
    val solution13 = Solution13()
    println(solution13.solution(expression))
}

class Solution13 {
    fun solution(expression: String): Long {
        var answer: Long = 0
        val op = arrayOf("*+-", "*-+", "+*-", "+-*", "-*+", "-+*")
        val exList = mutableListOf<String>()

        val str = StringBuilder()
        val map = HashMap<Char, Int>()
        var list = mutableListOf<Long>()
        for (i in expression) {
            if (i.isDigit()) {
                str.append(i)
            } else {
                if (map.containsKey(i)) {
                    val count = map[i]!!
                    map[i] = count + 1
                } else {
                    map[i] = 1
                }
                exList.add(str.toString())
                str.clear()
                exList.add(i.toString())
            }
        }
        if (str.isNotBlank()) {
            exList.add(str.toString())
        }

        for (i in op) {
            val tempArr = mutableListOf<String>()
            val newMap = HashMap(map)
            initArr(tempArr, exList)
            for (j in i) {
                var k = 0
                if (newMap.contains(j)) {
                    while (newMap[j] != 0) // j == operator
                        {
                            if (tempArr[k] == j.toString()) {
                                val count = newMap[j]!!
                                val result = operator(j, tempArr[k - 1].toLong(), tempArr[k + 1].toLong())
                                newMap[j] = count - 1
                                tempArr.removeAt(k - 1)
                                tempArr.add(k - 1, result.toString())
                                tempArr.removeAt(k)
                                tempArr.removeAt(k)
                                k--
                            } else {
                                k++
                            }
                        }
                }
            }

            list.add(abs(tempArr[0].toLong()))
        }
        list.sortDescending()
        answer = list[0]
        return answer
    }

    fun initArr(tempArr: MutableList<String>, exList: MutableList<String>) {
        exList.forEach {
            tempArr.add(it)
        }
    }

    fun operator(op: Char, a: Long, b: Long): Long {
        var result = 0L
        when (op) {
            '*' -> result = a * b
            '-' -> result = a - b
            '+' -> result = a + b
        }
        return result
    }
}
