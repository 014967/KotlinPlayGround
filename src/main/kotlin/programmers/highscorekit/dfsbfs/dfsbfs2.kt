package programmers.highscorekit.dfsbfs

/**
 * @desc
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때
컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */
// arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))
// arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 1, 0), intArrayOf(1, 0, 1))
// arrayOf(intArrayOf(1,1, 0, 1), intArrayOf(1, 1,0, 0), intArrayOf(0, 0,1, 1), intArrayOf(1,0,1,1))
// arrayOf(intArrayOf(1,0, 0, 0), intArrayOf(0, 1,0, 0), intArrayOf(0, 0,1, 0), intArrayOf(0,0,0,1))
// arrayOf(intArrayOf(1,0, 1, 1,0,0), intArrayOf(0, 1,0, 0,1,1), intArrayOf(1, 0, 1,1, 1,1), intArrayOf(1,0,1,1,1,1), intArrayOf(0,1,1,1,1,1), intArrayOf(0,1,1,1,1,1))
// arrayOf(intArrayOf(1,1,1, 0, 0 ),intArrayOf(1,1, 0 , 0, 0),intArrayOf(1,0,1,0,0),intArrayOf(0,0,0,1,1),intArrayOf(0,0,0,1,1))
fun main() {
    val n = 3 // 5 // 6 // 4 // 3
    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
    // arrayOf(intArrayOf(1, 1, 1, 0, 0), intArrayOf(1, 1, 0, 0, 0), intArrayOf(1, 0, 1, 0, 0), intArrayOf(0, 0, 0, 1, 1), intArrayOf(0, 0, 0, 1, 1)) // arrayOf(intArrayOf(1, 0, 1, 1, 0, 0), intArrayOf(0, 1, 0, 0, 1, 1), intArrayOf(1, 0, 1, 1, 1, 1), intArrayOf(1, 0, 1, 1, 1, 1), intArrayOf(0, 1, 1, 1, 1, 1), intArrayOf(0, 1, 1, 1, 1, 1)) // arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 0, 1)) // arrayOf(intArrayOf(1,1, 0, 1), intArrayOf(1, 1,0, 0), intArrayOf(0, 0,1, 1), intArrayOf(1,0,1,1))//arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 1, 0), intArrayOf(1, 0, 1))//arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)) //
    println(solution(n, computers))
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    val visited = List<Boolean>(n) { false }.toMutableList()
    for (i in 0 until n) {
        if (!visited[i]) { // 해당 노드를 접근을 했는가 안했는가를 파악
            dfs(i, computers, visited)
            answer++ // 하나의 탐색을 할 때마다 네트워크가 생긴다
        }
    }
    return answer
}

fun dfs(i: Int, computers: Array<IntArray>, visited: MutableList<Boolean>) {
    // i -> 노드
    visited[i] = true
    computers[i].forEachIndexed { next, connected ->
        if (connected == 1 && !visited[next])
            dfs(next, computers, visited)
    }
}

/*
fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    val arr = generateSequence(0) { it + 1 }.take(n).toMutableList()
    for (i in computers.indices) {
        for (j in computers[i].indices) {
            if (i != j && computers[i][j] == 1) {
                unionParent(i, j, arr)
            }
        }
    }
    for (i in 0 until arr.size) {
        if (arr[i] == i) {
            answer++
        }
    }
    return answer
}
fun findParent(i: Int, arr: MutableList<Int>): Int {
    if (i == arr[i])
        return i
    else {
        arr[i] = findParent(arr[i], arr)
        return arr[i]
    }
}
fun unionParent(i: Int, j: Int, arr: MutableList<Int>) {
    val parentI = findParent(i, arr)
    val parentJ = findParent(j, arr)
    if (parentI > parentJ) {
        arr[parentI] = parentJ
    } else {
        arr[parentJ] = parentI
    }
}

 */
