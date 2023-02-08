package programmers.`등산 코스 정하기`

import java.util.*
import kotlin.collections.ArrayList

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
    val solution = Solution()
    val n = 6
    val path = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(2, 3, 5),
        intArrayOf(2, 4, 2),
        intArrayOf(2, 5, 4),
        intArrayOf(3, 4, 4),
        intArrayOf(4, 5, 3),
        intArrayOf(4, 6, 1),
        intArrayOf(5, 6, 1)
    )
    val gates = intArrayOf(1, 3)
    val summits = intArrayOf(5)
    println(solution.solution(n, path, gates, summits))
}

data class Node(
    val nodeNum: Int,
    val cost: Int,
    val intensity: Int,
    val topNum: Int
)
class Solution {
    fun solution(
        n: Int, // 지점수
        paths: Array<IntArray>, // 경로
        gates: IntArray, // 출입구
        summits: IntArray // 산봉우리
    ): IntArray {
        var answer: IntArray = intArrayOf(500001, Integer.MAX_VALUE)

        val arr = Array(n + 1) { arrayListOf<Node>() }
        val check = Array(n + 1) { false }
        for (index in paths.indices) {
            val i = paths[index][0]
            val j = paths[index][1]
            val w = paths[index][2]
            arr[i].add(Node(j, w, w, -1))
            arr[j].add(Node(i, w, w, -1))
        }
        for (i in gates) {
            val result = bfs(i, check, arr, summits, gates)
        }

        return answer
    }
}

fun bfs(start: Int, check: Array<Boolean>, arr: Array<ArrayList<Node>>, summits: IntArray, gates: IntArray): IntArray {
    val queue = PriorityQueue<Node>() { p1, p2 ->
        p1.cost - p2.cost
    } // 가장 적은 cost로 지나가기 위해서

    for (i in arr[start]) {
        queue.offer(i)
    }

    val resultList = arrayListOf<IntArray>()
    val gatesWithoutStart = gates.filter {
        it != start
    }
    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        val currentNodeNum = currentNode.nodeNum
        val currentCost = currentNode.cost
        val currentIntensity = currentNode.intensity
        val currentTopNum = currentNode.topNum

        if (currentNodeNum == start) {
            // 처음으로 돌아왔다
            resultList.add(intArrayOf(currentIntensity, currentTopNum))
            continue
        }

        var flag = false
        for (i in arr[currentNodeNum]) {
            val nextNodeNum = i.nodeNum
            val nextCost = i.cost
            val nextIntensity = i.intensity
            var topNum = i.topNum

            if (flag) {
                // 이미 한번은 산봉우리에 갔다는 것.
                if (nextNodeNum !in summits && nextNodeNum !in gatesWithoutStart) {
                    if (currentIntensity < nextIntensity) {
                        if (nextNodeNum == start) {
                            if (flag) {
                                queue.offer(Node(nextNodeNum, nextCost, nextIntensity, currentTopNum))
                            }
                        } else {
                            queue.offer(Node(nextNodeNum, nextCost, nextIntensity, currentTopNum))
                        }
                    } else {
                        if (nextNodeNum == start) {
                            if (flag) {
                                queue.offer(Node(nextNodeNum, nextCost, currentIntensity, currentTopNum))
                            }
                        } else {
                            queue.offer(Node(nextNodeNum, nextCost, currentIntensity, currentTopNum)) }
                    }
                }
            } else {
                if (nextNodeNum in summits) {
                    flag = true
                    topNum = nextNodeNum
                }

                if (nextNodeNum !in gatesWithoutStart) {
                    if (currentIntensity < nextIntensity) {
                        if (nextNodeNum == start) {
                            if (flag) {
                                queue.offer(Node(nextNodeNum, nextCost, nextIntensity, topNum))
                            }
                        } else {
                            queue.offer(Node(nextNodeNum, nextCost, nextIntensity, topNum))
                        }
                    } else {
                        if (nextNodeNum == start) {
                            if (flag) {
                                queue.offer(Node(nextNodeNum, nextCost, currentIntensity, topNum))
                            }
                        } else {
                            queue.offer(Node(nextNodeNum, nextCost, currentIntensity, topNum))
                        }
                    }
                }
            }
        }
    }
    return intArrayOf(0, 0)
}
