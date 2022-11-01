package programmers.섬연결하기

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
    val solution = Solution2()
    val testCase = listOf(
        listOf(
            4,
            arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 2, 2), intArrayOf(1, 2, 5), intArrayOf(1, 3, 1), intArrayOf(2, 3, 8)),
            listOf(5, arrayOf(intArrayOf(0, 1, 1), intArrayOf(3, 4, 1), intArrayOf(1, 2, 2), intArrayOf(2, 3, 4))),
            listOf(4, arrayOf(intArrayOf(0, 1, 5), intArrayOf(1, 2, 3), intArrayOf(2, 3, 3), intArrayOf(1, 3, 2), intArrayOf(0, 3, 4))),
            listOf(5, arrayOf(intArrayOf(0, 1, 1), intArrayOf(3, 1, 1), intArrayOf(0, 2, 2), intArrayOf(0, 3, 2), intArrayOf(0, 4, 100))),
            listOf(
                6,
                arrayOf(
                    intArrayOf(0, 1, 5),
                    intArrayOf(0, 3, 2),
                    intArrayOf(0, 4, 3),
                    intArrayOf(1, 4, 1),
                    intArrayOf(3, 4, 10),
                    intArrayOf(1, 2, 2),
                    intArrayOf(2, 5, 3),
                    intArrayOf(4, 5, 4)
                )
            )

        )
    )
    testCase.forEach {
        println(solution.solution(it[0]as Int, it[1] as Array<IntArray>))
    }
}

class Solution2 {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        val parent = IntArray(n) { it } // 초기 parent는 자기 자신
        costs.sortWith(Comparator { o1, o2 -> o1[2] - o2[2] })
        // 비용 정렬
        for (i in costs.indices) {
            if (!findParent(parent, costs[i][0], costs[i][1])) {
                // 부모가 같지 않다면
                unionParent(parent, costs[i][0], costs[i][1])
                answer += costs[i][2]
            }
        }
        return answer
    }

    fun getParent(parent: IntArray, x: Int): Int {
        return if (parent[x] == x) x else getParent(parent, parent[x]).also { parent[x] = it }
    }
    fun unionParent(parent: IntArray, a: Int, b: Int) {
        val x = getParent(parent, a)
        val y = getParent(parent, b)
        if (x < y) {
            parent[y] = x
        } else {
            parent[x] = y
        }
    }

    fun findParent(parent: IntArray, a: Int, b: Int): Boolean {
        val x = getParent(parent, a)
        val y = getParent(parent, b)
        return x == y
    }
}
/*
크루스칼
그래프의 edge를 cost가 작은 순서대로 정렬
정렬된 edge를 순회하며 해당 edge를 mst에 포함했을때 사이클이 형성하는지 체크
사이클을 형성하지 않는 edge를 mst에 포함.

유니온 파인드를 써야한다.
 */
