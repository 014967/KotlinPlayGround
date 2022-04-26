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

    val record = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan")
    val solution = Solution3()
    val result = solution.solution(record)
    result.forEach {
        print(it)
    }
}

class Solution3 {
    fun solution(record: Array<String>): ArrayList<String> {
        require(record.size in 1..100000)

        var answer = arrayListOf<String>()
        var map = HashMap<String, String>()
        for (i in record) {
            var str = i.split(" ")
            if (str[0] == "Change" || str[0] == "Enter") {
                val user_id = str[1]
                val nick_name = str[2]
                map[user_id] = nick_name
            }
        }
        for (i in record) {
            var str = i.split(" ")
            val cmd = str[0]
            val user_id = str[1]
            val nickname = map[user_id]
            var result = StringBuilder()
            if (cmd != "Change") {
                result.append(nickname).append(command(cmd))
                answer.add(result.toString())
            }
        }

        return answer
    }
    fun command(input: String): String {
        when (input) {
            "Enter" ->
                {
                    return "님이 들어왔습니다."
                }
            "Leave" ->
                {
                    return "님이 나갔습니다."
                }
            else ->
                {
                    return ""
                }
        }
    }
}
/*

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val user = mutableMapOf<String, String>()

    return record
            .map {
                val r = it.split(" ")
                val action = r.first()
                when (action) {
                    "Enter", "Change" -> user += r[1] to r[2]
                }
                r
            }
            .asSequence()
            .filter { it[0] != "Change" }
            .map {
                val nickName = user[it[1]]
                val explanation = when (it[0]) {
                    "Enter" -> "님이 들어왔습니다."
                    "Leave" -> "님이 나갔습니다."
                    else -> throw IllegalArgumentException()
                }
                "$nickName$explanation"
            }
            .toList().toTypedArray()
    }
}
 */