package programmers.`이모티콘 할인행사`

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
    val solution = Solution()

//    val users = arrayOf(
//        intArrayOf(40, 2900),
//        intArrayOf(23, 10000),
//        intArrayOf(11, 5200),
//        intArrayOf(5, 5900),
//        intArrayOf(40, 3100),
//        intArrayOf(27, 9200),
//        intArrayOf(32, 6900)
//    )
//    val emoticons = intArrayOf(
//        1300,
//        1500,
//        1600,
//        4900
//    )
    val users = arrayOf(
        intArrayOf(40, 10000),
        intArrayOf(25, 10000)
    )
    val emoticons = intArrayOf(7000, 9000)
    require(emoticons.size in 1..7)
    require(users.size in 1..100)
    /*
    할인율은 10 , 20 , 30, 40 중 하나

     */
    println(
        solution.solution(
            users = users,
            emoticons = emoticons
        )
    )
}

class Solution {
    private val typeList = arrayListOf<IntArray>()
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val disCount = intArrayOf(10, 20, 30, 40)
        val output = IntArray(emoticons.size) { 0 }
        d_Combination(disCount, output, 0, 0, emoticons.size)

        var result = Result(0, 0)
        for (i in typeList.indices) {
            // i in intArray
            var count = 0 // 몇명의 유저가 가입을 했는지
            var total = 0
            for (k in users.indices) {
                val user = users[k]
                val usersTargetDiscount = user[0]
                val usersTargetTotal = user[1]

                var tempCount = 0
                for (j in typeList[i].indices) {
                    val discount = typeList[i][j]
                    if (discount >= usersTargetDiscount) {
                        tempCount += emoticons[j] - ((emoticons[j] * discount) / 100)
                    }
                }
                if (tempCount >= usersTargetTotal) {
                    // 가입하면 뺴야지
                    count++
                } else {
                    total += tempCount
                }
            }

            if (result.access < count) {
                result.access = count
                result.total = total
            } else if (result.access == count) {
                if (result.total < total) {
                    result.total = total
                }
            }
        }

        answer = intArrayOf(result.access, result.total)
        return answer
    }
    data class Result(
        var access: Int,
        var total: Int
    )
    fun d_Combination(discount: IntArray, output: IntArray, start: Int, depth: Int, r: Int) {
        if (depth == r) {
            typeList.add(output.copyOf())
            return
        }
        for (i in start until discount.size) {
            output[depth] = discount[i]
            d_Combination(discount, output, start, depth + 1, r)
        }
    }
}
