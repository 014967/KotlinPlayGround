package programmers.순위

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
    val n = 5
    val results = arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(2, 5))
    val solution = Solution()
    println(solution.solution(n, results))
}

lateinit var countWin: Array<Int>
lateinit var countLose: Array<Int>
class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        countWin = Array(n + 1) { 0 }
        countLose = Array(n + 1) { 0 }
        val fight = Array(n + 1) { arrayListOf<Int>() }
        results.forEach {
            val win = it[0]
            val lose = it[1]
            fight[win].add(lose)
        }
        val check = Array(n + 1) { BooleanArray(n + 1) { false } }

        for (i in 1 until fight.size) {
            dfs(i, i, fight, check)
        }
        for (i in 1..n) {
            if (countLose[i] + countWin[i] == n - 1) {
                answer++
            }
        }
        return answer
    }
}
fun dfs(start: Int, current: Int, fight: Array<ArrayList<Int>>, check: Array<BooleanArray>) {
    for (i in fight[current]) {
        if (check[start][i]) {
            continue
        }
        check[start][i] = true
        countWin[start]++
        countLose[i]++
        dfs(start, i, fight, check)
    }
}

/*
이길 수 있는 선수 + 지는 선수의 합이 n-1인 선수는 순위가 확정된것.
각 선수를 시작 노드로 각각 DFS를 진행한다.

 */
