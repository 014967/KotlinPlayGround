package programmers.`다단계 칫솔 판매`

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
    val enroll = arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young")
    val referral = arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward")
    val seller = arrayOf("young", "john", "tod", "emily", "mary")
    val amount = intArrayOf(12, 4, 2, 5, 10)

    val list = listOf(
        listOf(enroll, referral, seller, amount),
        listOf(
            enroll,
            referral,
            arrayOf("sam", "emily", "jaimie", "edward"),
            intArrayOf(2, 3, 5, 4)
        )
    )

    val solution = Solution()
    for (i in list) {
        println(
            solution.solution(
                i[0] as Array<String>,
                i[1] as Array<String>,
                i[2] as Array<String>,
                i[3] as IntArray
            )
        )
    }
}

class Solution {

    val map = HashMap<String, Int>()
    val parentTable = HashMap<String, String>()

    fun solution(
        enroll: Array<String>, // 판매원 이름
        referral: Array<String>, // 각 판매원을 참여시킨 다른 판매원
        seller: Array<String>, // 판매량을 올린 사람들
        amount: IntArray // 판매량을 올린 사람들이 올린 소득
    ): IntArray {
        var answer = intArrayOf()

        for (i in enroll.indices) {
            map.put(enroll[i], 0)
            parentTable.put(enroll[i], referral[i])
        }
        for (i in seller.indices) {
            getParentAndUpdate(seller[i], amount[i] * 100)
        }

        answer = IntArray(enroll.size) { it ->
            map.getOrDefault(enroll[it], 0)
        }
        return answer
    }

    private fun getParentAndUpdate(
        name: String,
        cost: Int
    ) {
        val parent = parentTable[name]!!

        val otherCost = (cost * 0.1).toInt()
        val currentCost = cost - otherCost
        map[name] = map[name]!! + currentCost
        if (otherCost < 1 || parent == "-") {
            return
        }
        getParentAndUpdate(parent, otherCost)
    }
}
