package programmers.`성격 유형 검사하기`

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
    val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val choices = intArrayOf(5, 3, 2, 7, 5)
    val solution = Solution()
    println(solution.solution(survey, choices))
}
class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val answer = StringBuilder()

        val typeList = listOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')

        val map = HashMap<Char, Int>()
        typeList.forEach {
            map[it] = 0
        }

        val zipSurch = survey.zip(choices.toList())

        for (i in zipSurch) {
            val key = i.first
            val value = i.second
            val surUnitList = key.toList()
            when (value) {
                2, 6 -> {
                    // 2 점 비동의, 동의 동의라면 앞글자 아니라면 뒷글자
                    val currentType = if (value == 2)surUnitList[0] else surUnitList[1]
                    val count = map.getOrDefault(currentType, 0)
                    map[currentType] = count + 2
                }
                3, 5 -> {
                    // 1점 // 3 약간 비동의 , 5 약간 동의
                    // AN일 때 약간 동의라면 앞의 글자 A가 1점 아니라면 뒤의 글자
                    val currentType = if (value == 3) surUnitList[0] else surUnitList[1]
                    val count = map.getOrDefault(currentType, 0)
                    map[currentType] = count + 1
                }
                1, 7 -> {
                    // 3점
                    val currentType = if (value == 1) surUnitList[0] else surUnitList[1]
                    val count = map.getOrDefault(currentType, 0)
                    map[currentType] = count + 3
                }
                else -> { // 0점
                }
            }
        }

        if (map['R']!! >= map['T']!!) {
            answer.append('R')
        } else {
            answer.append('T')
        }

        if (map['C']!! >= map['F']!!) {
            answer.append('C')
        } else {
            answer.append('F')
        }

        if (map['J']!! >= map['M']!!) {
            answer.append('J')
        } else {
            answer.append('M')
        }

        if (map['A']!! >= map['N']!!) {
            answer.append('A')
        } else {
            answer.append('N')
        }

        return answer.toString()
    }
}

/*

-- index < 4 비동의 ->FC 라면 뒤의 문자 C가 +
-- index 4 == 0
--  index > 4  동의 -> FC 라면 앞의 문자가 +이다.
성격 유형 검사는 4개의 지표로 성격 유형을 구분하빈다
1번 -> R,T
2-> C,F
3 -> J,M
4 -> A,N
16가지로 RFMN 같은 게 나올 수 있음

질문지는 총 7개

성격 유형이 가으면 사전순으로 빠른 성격유형으로 정함

 */
