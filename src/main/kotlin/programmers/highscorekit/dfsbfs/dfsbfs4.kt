package programmers.highscorekit.dfsbfs

/**
 * @desc
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때,
방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
입출력 예
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
//    val tickets: Array<Array<String>> = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
//    val tickets: Array<Array<String>> = arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL", "SFO"))
    val tickets: Array<Array<String>> = arrayOf(arrayOf("ICN", "BBB"), arrayOf("ICN", "CCC"), arrayOf("BBB", "CCC"), arrayOf("CCC", "BBB"), arrayOf("CCC", "ICN"))
    val solution4 = Solution4()
    println(solution4.solution(tickets))
}

class Solution4 {

    var visited = booleanArrayOf()
    var answer = mutableListOf<String>()
    val cnt = 0
    fun solution(tickets: Array<Array<String>>): List<String> {

        visited = BooleanArray(tickets.size) // 모든 티켓을 소모했는가?
        val tic = tickets.sortedWith(
            compareBy { it[1] }
        )
        dfs(tic, "ICN", cnt)
        return answer
    }

    fun dfs(
        tickets: List<Array<String>>,
        start: String,
        cnt: Int
    ) {

        answer.add(start)
        if (cnt == visited.size) {
            return
        }

        /**
         *  탐색을 할때 동일한 경로가 있다면, 알파벳 순서로 가야한다.
         *  일단 출력부터 해볼까?
         */

        for (i in tickets.indices) {

            if (!visited[i] && tickets[i][0] == start) {
                visited[i] = true
                dfs(tickets, tickets[i][1], cnt + 1)
                visited[i] = false
                if (answer.size !== visited.size + 1)
                    answer.removeLast()
            }
        }
    }
}
