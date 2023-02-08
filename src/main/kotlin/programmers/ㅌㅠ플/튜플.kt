package programmers.ㅌㅠ플

import java.util.*

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
    val list = listOf(
//        "{{2},{2,1},{2,1,3},{2,1,3,4}}",
//        "{{1,2,3},{2,1},{1,2,4,3},{2}}",
//        "{{20,111},{111}}",
//        "{{123}}",
        "{{4,2,3},{3},{2,3,4,1},{2,3}}"

    )
    val solution = Solution()
    for (i in list) {
        println(solution.solution(i).joinToString { it.toString() })
    }
}

class Solution {
    fun solution(s: String): IntArray {
        val answer = mutableListOf<String>()

        val str = s.substring(1, s.length - 1)
        val pattern = "\\{(.*?)\\}".toRegex()
        val matcher = pattern.findAll(str)

        val temp = arrayListOf<List<String>>()
        matcher.forEach {
            val value = it.value.substring(1, it.value.length - 1)
            val t = value.split(",")
            temp.add(t)
        }
        temp.sortBy {
            it.size
        }
        for (i in temp) {
            val other = i.filter {
                it !in answer
            }.take(1)
            answer.add(other[0])
        }


        return answer.map{it.toInt()}.toIntArray()
    }
}
/*
원소는 중괄호 안에 담기는데, 중복 원소는 없다
원소는 정해진 순서가 있고, 원소의 순서가 다르면 서로 다른 튜플이래.
근데 집한은 원소의 순서가 바뀌어도 상관이 없다네?
 */
