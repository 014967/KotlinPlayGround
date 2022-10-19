package baekjoon.solution1068

import java.io.BufferedReader
import java.io.InputStreamReader

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

var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    require(n in 1..50)

    var rootIndex = 0
    val line = readLine().split(" ").map { it.toInt() }
    val removeIndex = readLine().toInt()
    val tree = Array(n) { mutableListOf<Int>() }
    val check = Array(n) { false }
    for (i in line.indices) {
        if (line[i] == -1) {
            rootIndex = i
        } else {
            tree[line[i]].add(i)
        }
        // i index 노드 번호,  line[i] -> 부모번호
    }
    if (removeIndex == rootIndex) {
        println(0)
    } else {
        dfs(tree, check, rootIndex, removeIndex)
        println(answer)
    }

}
fun dfs(tree: Array<MutableList<Int>>, check: Array<Boolean>, rootIndex: Int, removeIndex: Int) {
    check[rootIndex] = true
    var childCount = 0
    for (i in tree[rootIndex]) { // root index 부터 탐색
        if (!check[i] && i != removeIndex) {
            childCount++
            dfs(tree, check, i, removeIndex)
        }
    }
    if (childCount == 0) {
        answer++
    }
}
