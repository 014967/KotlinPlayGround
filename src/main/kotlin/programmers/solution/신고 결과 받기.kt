package programmers.solution

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
    val id_list = arrayOf("con", "ryan")//arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")//arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    val k = 3//2
    val solution = Solution()
    println(solution.solution(id_list, report, k))
}

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): Array<Int> {

        require(id_list.size in 2..1000)
        require(report.size in 1..200000)
        require(k in 1..200)

        var answer: Array<Int> = Array(id_list.size) { 0 }
        val fireList = Array(id_list.size) { 0 } // 0으로 초기화하자.
        var arr = Array<ArrayList<Int>>(id_list.size) { arrayListOf() }

        for (i in report) {
            val str = i.split(" ")
            val user_id = str[0]
            val fire_id = str[1]

            val user_idx = id_list.indexOf(user_id)
            val fire_idx = id_list.indexOf(fire_id)

            if (arr[user_idx].indexOf(fire_idx) == -1) {
                arr[user_idx].add(fire_idx)
                fireList[fire_idx] += 1
            }
        }

        for (i in arr.indices) {
            for (j in arr[i]) {
                if (fireList[j] >= k) {
                    answer[i] += 1
                }
            }
        }

        return answer
    }
}


//class Solution {
//    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
//    report.map { it.split(" ") }
//        .groupBy { it[1] }
//        .asSequence()
//        .map { it.value.distinct() }
//        .filter { it.size >= k }
//        .flatten()
//        .map { it[0] }
//        .groupingBy { it }
//        .eachCount()
//        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
//}
