package programmers.`길 찾기 게임`

import java.util.*

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
    val nodeInfo = arrayOf<IntArray>(
        intArrayOf(5, 3),
        intArrayOf(11, 5),
        intArrayOf(13, 3),
        intArrayOf(3, 5),
        intArrayOf(6, 1),
        intArrayOf(1, 3),
        intArrayOf(8, 6),
        intArrayOf(7, 2),
        intArrayOf(2, 2)
    )
    val solution = Solution()
    solution.solution(nodeInfo)
}

data class Node(
    val nodeId: Int,
    val x: Int,
    val y: Int
)

class Solution {
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        /*
        제한사항
         */
        require(nodeinfo.size in 1..10000)
        // 노드는 1번노드부터 nodeinfo[0] = 1번 노드 좌표다.

        var answer = arrayOf<IntArray>()

        val list = arrayListOf<Node>()
        var idCount = 1
        for (i in nodeinfo) {
            val node = Node(idCount, i[0], i[1])
            list.add(node)
            idCount++
        }
        list.sortByDescending { it.y }
        println(list)

        val priQueue = PriorityQueue<Node>(
            kotlin.Comparator<Node> { o1, o2 -> o2.y - o1.y }
        )
        list.forEach {
            priQueue.add(it)
        }


//        priQueue.poll()

        var count = 0
        var depth = 1
        for (i in (2 * depth) until 2 * (depth + 1)) {
            // depth

            println(count++)
        }
        println(priQueue)

        return answer
    }
}
/*
카카오 프렌즈를 두 팀으로 나누고, 각 팀이 같은 곳을 다른 순서로 방문하도록 해서 먼저 순회를 마친 팀이 승리
방물할 곳의 2차원 좌표 값을 구하고 각 장소를 이진 트리의 노드가 되도록 구성한후,
순회 방법을 힌트로 주어 각 팀이 스스로 경로를 찾도록 하마

규칙
1. 트리를 구성하는 모든 노드의 x,y 좌표값은 정수다
2. 모든 노드는 서로 다른 x값을 가진다
3. 같은 레벨에 있는 노드는 같은 y좌표를 가진다.
4. 자식 노드의 y값은 항상 부모 노드보다 작다
5. 임의의 노드 v의 왼쪽 서브 트리에 있는 모든 노드의 값은 v의 x값보다 작다
6. 임의의 노드 v의 오른쪽 서브 트리에 있는 모든 노드의 x값은 v의 x값보다 크다.
이진트리를 전위 순회, 후위 순회한 결과를 2차원 배열에 순서대로 담아 return하도록  solution 함수 완성
 */
