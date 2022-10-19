package programmers.`신고 결과 받기`

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
    val id_list = listOf(
//        arrayOf("muzi", "frodo", "apeach", "neo"),
//        arrayOf("con", "ryan"),
        arrayOf("muzi", "frodo", "apeach", "neo"),
    )
    val report = listOf(
//        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
//        arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        arrayOf("muzi frodo", "apeach frodo", "apeach neo", "muzi neo"),
    )
    val k = listOf(1)

    val solution = Solution()

    for (i in 0 until 1) {
        solution.solution(id_list[i], report[i], k[i]).forEach {
            print("$it ")
        }
        println()
    }
}
class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        val map = HashMap<String, ArrayList<String>>()
        val targetMap = HashMap<String, Int>()

        for (i in report) {
            val str = i.split(" ")
            val who = str[0]
            val target = str[1]
            if (map.contains(who)) {
                if (map[who] != null) {
                    if (map[who]!!.indexOf(target) == -1) {
                        // 중복 제거
                        map[who]!!.add(target)
                        if (targetMap.contains(target)) {
                            val count = targetMap[target]
                            if (count != null)
                                targetMap[target] = count + 1
                        } else {
                            targetMap[target] = 1
                        }
                    }
                }
            } else {
                val arrList = arrayListOf<String>()
                arrList.add(target)
                if (targetMap.contains(target)) {
                    val count = targetMap[target]
                    if (count != null)
                        targetMap[target] = count + 1
                } else {
                    targetMap[target] = 1
                }

                map[who] = arrList
            }
        }

        val resultArr = arrayListOf<Int>()
        for (i in id_list) {
            val getIdList = map[i]
            if (getIdList != null) {
                val size = getIdList.filter {
                    targetMap[it] != null
                }.filter {
                    targetMap[it]!! >= k
                }.size
                resultArr.add(size)
            } else {
                resultArr.add(0)
            }
        }
        answer = resultArr.toIntArray()

        return answer
    }
}
/*
각 유저는 한번에 한명의 유저를 신고할 수 있다.
- 신고 횟수에 제한은 없다
- 서로 다른 유저를 계속 신고할 수 있다.

각 유저는 한 유저를 여러번 신고할 수 있지만, 동일한 유저에 대한 신고횟수는 1회로 처리된다.
k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발소하
 */
