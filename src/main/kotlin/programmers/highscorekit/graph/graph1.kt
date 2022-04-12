package programmers.highscorekit.graph

import java.util.*

/**
 * @desc
n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 * @input
n	vertex	                                                  return
6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
 * @output
 *
 * @example
 *
 */

fun main() {
    val n = 6
    val vertex = arrayOf(
        intArrayOf(3, 6), intArrayOf(4, 3),
        intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2),
        intArrayOf(2, 4), intArrayOf(5, 2)
    )

    val graphSolution = GraphSolution()
    println(graphSolution.solution(n, vertex))
}
class GraphSolution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        require(n in 2..20000)
        require(edge.size in 1..50000)
        var answer = -1
        val checkArr = BooleanArray(n + 1) { false } // 노드 갯수 추가
        val depthArr = IntArray(n + 1) { 0 } // 노드 갯수 추가
        val edgeArr = Array<ArrayList<Int>>(n + 1) { arrayListOf<Int>() }
        for (i in edge.indices) {
            edgeArr[edge[i][0]].add(edge[i][1])
            edgeArr[edge[i][1]].add(edge[i][0])
        }

        answer = bfs(edgeArr, 1, checkArr, depthArr)
        return answer
    }

    fun bfs(edgeArray: Array<ArrayList<Int>>, x: Int, checkArr: BooleanArray, depthArr: IntArray): Int {

        val q = LinkedList<Int>()
        q.offer(x)
        checkArr[x] = true
        var max = -1
        depthArr[x] = 0

        var count = 0
        while (q.isNotEmpty()) {
            val first = q.poll()

            for (i in 0 until edgeArray[first].size) { // 연결되어 있는 부분찾기

                val node = edgeArray[first][i] //  연결되어 있는 node의 숫자
                if (!checkArr[node]) {
                    q.offer(node)
                    depthArr[node] = depthArr[first] + 1
                    max = depthArr[node].coerceAtLeast(max)
                    checkArr[node] = true
                }
            }
        }
        for (i in depthArr.indices) {
            if (depthArr[i] == max) {
                count++
            }
        }
        return count
    }
}
