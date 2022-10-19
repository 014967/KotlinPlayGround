package programmers.`순위 검색`

import java.util.*
import kotlin.collections.ArrayList

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
    val info = arrayOf("java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50")
    val query = arrayOf("java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150")
    require(info.size in 1..50000)
    val solution = Solution()
    solution.solution(info, query).forEach {
        println(it)
    }
}

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val tempAnswer = arrayListOf<Int>()
        val map = HashMap<Data, ArrayList<Int>>()
        for (i in info) {
            val item = i.split(" ")
            val language = item[0]
            val end = item[1]
            val nior = item[2]
            val food = item[3]
            val score = item[4]
            for (l in arrayListOf("-", language)) {
                for (e in arrayListOf("-", end)) {
                    for (n in arrayListOf("-", nior)) {
                        for (f in arrayListOf("-", food)) {
                            val data = Data(
                                language = l,
                                end = e,
                                nior = n,
                                food = f
                            )
                            if (map.contains(data)) {
                                val arrList = map[data]
                                arrList!!.add(score.toInt())
                            } else {
                                val arrList = arrayListOf<Int>()
                                arrList.add(score.toInt())
                                map[data] = arrList
                            }
                        }
                    }
                }
            }
         /*
         info하나를 돌때마다 16가지의 key가 생긴다.
          */
        }
        for (i in map.keys) {
            val arrayList = map[i]
            arrayList?.sort() // score 오름차순 정렬
        }
     /*
     이분탐색을 위해서 정렬해준다.
      */

        query.forEach {
            val item = it.split(" ")
            val language = item[0]
            val end = item[2]
            val nior = item[4]
            val food = item[6] // and제외
            val score = item[7].toInt()
            val checkArrayList = map[Data(language, end, nior, food)]

            if (checkArrayList != null) {
                var start = 0
                var end = checkArrayList!!.lastIndex
                while (start <= end) {
                    var mid = (start + end) / 2
                    if (checkArrayList[mid] < score) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                }
                tempAnswer.add(checkArrayList.size - start)
                // start 가 인덱스이기 때문에 score보다 checkArrayList[start] 클때의 index를 찾아서
                // tempAnswer에 전체 갯수 - start index 를 해주면 score에 해당하는 값들의 갯수가 나온다.
            } else {
                tempAnswer.add(0)
            }
        }
        answer = tempAnswer.toIntArray()
        return answer
    }
}
data class Data(
    // map 의 키로 할당한다.
    val language: String,
    val end: String,
    val nior: String,
    val food: String
)

/*
트라이 Trie
문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조

key 에 데이터를 가진다. key는 없어도 되는 값이다. -> trie 의 루트 노드는 키가 없기 때문에

이진 트리에서는 2개의 자식만 가지고 잇지만, trie는 여러 개의 자식 구조를 자신다.
is terminating - collection의 끝을 나타낸다.
 */
