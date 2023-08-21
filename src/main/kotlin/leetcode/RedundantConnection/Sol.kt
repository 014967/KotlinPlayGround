package leetcode.RedundantConnection

/**
이 문제에서 트리는 연결되어 있고 주기가 없는 무방향 그래프입니다.

하나의 추가 간선이 추가된 1에서 n까지 레이블이 지정된 n개의 노드가 있는 트리로 시작된 그래프가 제공됩니다.

추가된 모서리는 1에서 n까지 선택된 두 개의 서로 다른 정점을 가지며 이미 존재하는 모서리가 아닙니다.

그래프는 길이 n의 배열 가장자리로 표시됩니다. 여기서 edge[i] = [ai, bi]는 그래프에서 노드 ai와 bi 사이에 가장자리가 있음을 나타냅니다.

결과 그래프가 n 노드의 트리가 되도록 제거할 수 있는 에지를 반환합니다. 답변이 여러 개인 경우 입력에서 마지막으로 발생한 답변을 반환합니다.
 */

fun main() {
    val edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
    )
    val sol = Solution()
    println(sol.findRedundantConnection(edges).joinToString { it.toString() })
}
/*
무향일 경우 유니온 파인드를 사용하자.
 */

class Solution {
    lateinit var parent: Array<Int>
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        parent = Array(edges.size + 1) { it }
        for (i in edges) {
            val (start, end) = i
            if (!union(start, end)) {
                return intArrayOf(start, end)
                break
            }
        }
        return intArrayOf()
    }

    private fun find(x: Int): Int {
        return if (x == parent[x]) x else {
            parent[x] = find(parent[x])
            parent[x]
        }
    }
    private fun union(x: Int, y: Int): Boolean {
        val nx = find(x)
        val ny = find(y)
        return if (nx != ny) {
            parent[nx] = ny
            true
        } else {
            false
        }
    }
}
