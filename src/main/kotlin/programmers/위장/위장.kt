package programmers.위장

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
    val clothes = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    val clothes2 = arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    )
    val solution = Solution()
    println(solution.solution(clothes))
}

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = HashMap<String, ArrayList<String>>()
        clothes.forEach {
            if (map.containsKey(it[1])) {
                map[it[1]]?.add(it[1])
            } else {
                map[it[1]] = arrayListOf(it[0])
            }
        }
        for (i in map) {
            answer *= i.value.size + 1
        }
        return answer - 1
    }
}
/*
전날과 다른 의상을 입어야한다. 서로 다른 옷의 조합의 수를 return
 */
