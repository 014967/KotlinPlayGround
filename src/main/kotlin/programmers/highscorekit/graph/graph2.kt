package programmers.highscorekit.graph

/**
 * @desc
n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
권투 경기는 1대1 방식으로 진행이 되고,
만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다.
하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때
정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
제한사항
선수의 수는 1명 이상 100명 이하입니다.
경기 결과는 1개 이상 4,500개 이하입니다.
results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
모든 경기 결과에는 모순이 없습니다.
입출력 예
n	results	return
5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    // dfs를 돌면서 모든 노드를 갈 수 있느냐를 볼 수 있으면 될려나
    val n = 5
    val results = arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(2, 5))
    val graph2Solution = Graph2Solution()
    println(graph2Solution.solution(n, results))
}
class Graph2Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        require(n in 1..100)
        require(results.size in 1..4500)
        val boxerArrList = Array(n + 1) { Array(n + 1) { 10000 } }

        for (i in results.indices) {
            val start = results[i][0]
            val end = results[i][1]
            boxerArrList[start][end] = 1
        }
        for (d in 1..n) {
            // 거쳐가는 노드
            for (i in 1..n) {
                // 출발 노드
                for (j in 1..n) {
                    // 도착 노드
                    if (boxerArrList[i][j] > boxerArrList[i][d] + boxerArrList[d][j]) {
                        boxerArrList[i][j] = boxerArrList[i][d] + boxerArrList[d][j]
                    }
                }
            }
        }
        for (i in 1 until boxerArrList.size) {
            var count = 0
            for (j in 1 until boxerArrList[i].size) {
                if (boxerArrList[i][j] < 10000 || boxerArrList[j][i] < 10000) {
                    count ++
                }
            }
            if (count == n - 1) {
                answer++
            }
        }

        return answer
    }
}
/*


 */
