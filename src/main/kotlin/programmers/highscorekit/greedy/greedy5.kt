package programmers.highscorekit.greedy

/**
 * @desc
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
제한사항
섬의 개수 n은 1 이상 100 이하입니다.
costs의 길이는 ((n-1) * n) / 2이하입니다.
임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
연결할 수 없는 섬은 주어지지 않습니다.
입출력 예
n	costs	return
4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
 * @input
 *
 * @output
 *
 * @example
 *
 */
class Edges(node: IntArray, distance: Int) {
    val node = IntArray(2)
    var distance = 0

    init {
        this.node[0] = node[0]
        this.node[1] = node[1]
        this.distance = distance
    }
}
fun main() {
    val n = 5 // 6 // 4
    val costs: Array<IntArray> = arrayOf(intArrayOf(0, 1, 5), intArrayOf(1, 2, 3), intArrayOf(2, 3, 3), intArrayOf(3, 1, 2), intArrayOf(3, 0, 4), intArrayOf(2, 4, 6), intArrayOf(4, 0, 7))
    // arrayOf(intArrayOf(0, 1, 5), intArrayOf(0, 3, 2), intArrayOf(0, 4, 3), intArrayOf(1, 4, 1), intArrayOf(3, 4, 10), intArrayOf(1, 2, 2), intArrayOf(2, 5, 3), intArrayOf(4, 5, 4))
    // arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 2, 2), intArrayOf(1, 2, 5), intArrayOf(1, 3, 1), intArrayOf(2, 3, 8))
    println(solution(n, costs))
}
private fun solution(n: Int, costs: Array<IntArray>): Int {
    var answer = 0
    // 간선을 추가하자.
    var list = mutableListOf<Edges>()
    var parentArr = IntArray(n) { it } // 0 ,1,2,3,4로 초기화 해놨음. 자기 자신을 가리킨다.

    for (i in costs) {
        val Edge = Edges(intArrayOf(i[0], i[1]), i[2])
        list.add(Edge)
    }
    // 모든 간선을 list에 넣어놨으니까, 이를 distance로 정렬하자
    list = list.sortedWith(Comparator { o1: Edges, o2: Edges -> o1.distance - o2.distance }).toMutableList()

    var count = 0
    // 이게 모든 간선에 대해서 수행을 해보자
    for (i in list) {
        // 사이클이 발생하지 않는 경우, 그래프에 포함 시킨다.
        if (count == n - 1)
            break
        if (findParent(parentArr, i.node.get(0), i.node.get(1)) == 0) {
            // 0이라며 부모가 서로 다른 상태
            answer += i.distance
            unionParent(parentArr, i.node.get(0), i.node.get(1))
            count++
        }
    }

    return answer
}

fun getParent(parent: IntArray, a: Int): Int {
    if (parent[a] == a) {
        return a
    }
    // a가 가리기고 있는 부모를 다시 넣어서 최종 부모를 찾을려고 함.
    parent[a] = getParent(parent, parent[a])

    return parent[a]
}
// 같은 부모를 가지는 지 확인한다.
fun findParent(parent: IntArray, a: Int, b: Int): Int {
    var x = getParent(parent, a)
    var y = getParent(parent, b)
    if (x == y) {
        return 1 // 같은 부모를 가진다면 1을 반환하고
    } else
        return 0 // 다른 부모라면 0
}

fun unionParent(parent: IntArray, a: Int, b: Int) {
    var x = getParent(parent, a)
    var y = getParent(parent, b)
    if (x > y) {
        for (i in parent.indices) {
            if (parent[i] == x) {
                parent[i] = y
            }
        }
        parent[a] = y // 노드를 합치고 가리키는 부모노드를 초기화한다.
    } else {
        for (i in parent.indices) {
            if (parent[i] == y) {
                parent[i] = x
            }
        }
        parent[b] = x
    }
}
