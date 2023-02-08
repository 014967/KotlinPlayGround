package programmers.`불량 사용자`

import baekjoon.solution1068.answer
import programmers.highscorekit.bruteforce.permutation
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

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
    val user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id = arrayOf("fr*d*", "*rodo", "******", "******")
    val solution = Solution()
    println(solution.solution(user_id, banned_id))
    val map = mapOf<Int,Int>()
}

class Solution {

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        val ban_regex_list = arrayListOf<String>()
        for (i in banned_id) {
            val regex = StringBuilder()
            regex.append('^')
            for (j in i) {
                if (j == '*') {
                    regex.append('.')
                } else {
                    regex.append(j)
                }
            }
            regex.append("\$")
            ban_regex_list.add(regex.toString())
        }

        val check = BooleanArray(user_id.size) { false }

        val tePicked = mutableListOf<String>()

        permutation(tePicked, targetList = user_id.toList(), check, 0, ban_regex_list.size)

        val list = mutableSetOf<List<String>>()
        for (i in pickedList) { //
            var flag = true
            for (j in i.indices) {
                val result = ban_regex_list[j].toRegex().matchEntire(i[j])
                if (result != null) {
                } else {
                    flag = false
                    break
                }
            }
            if (flag) {
                val t = i.sorted()
                if (t !in list) {
                    list.add(t)
                }
            }
        }

        answer = list.size

        return answer
    }

    val pickedList = mutableListOf<MutableList<String>>()
    fun permutation(picked: MutableList<String>, targetList: List<String>, check: BooleanArray, count: Int, depth: Int) {
        if (count == depth) {
            pickedList.add(picked.toMutableList())
            return
        }
        for (i in targetList.indices) {
            if (!check[i]) {
                check[i] = true
                picked.add(targetList[i])
                permutation(picked, targetList, check, count + 1, depth)
                picked.removeAt(picked.lastIndex)
                check[i] = false
            }
        }
    }
}



/*
https://school.programmers.co.kr/questions/38974
https://soopeach.tistory.com/157
 */
