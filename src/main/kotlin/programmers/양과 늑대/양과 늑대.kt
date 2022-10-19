package programmers.`양과 늑대`

import java.awt.SystemColor.info
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

var wolfCount = 0
var shipCount = 0

fun main() {
    val info = intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1)
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(0, 8),
        intArrayOf(8, 7),
        intArrayOf(9, 10),
        intArrayOf(9, 11),
        intArrayOf(4, 3),
        intArrayOf(6, 5),
        intArrayOf(4, 6),
        intArrayOf(8, 9)
    )
    val solution = Solution()
    println(solution.solution(info, edges))
}

class Solution {
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        var answer: Int = 0
        val arr = Array(info.size) { Array(info.size) { 0 } }
        val checkArr = BooleanArray(info.size) { false }
        val map = HashMap<Int, ArrayList<Int>>()
        for (i in edges) {
            val root = i[0]
            val child = i[1]
            if (map.contains(root)) {
                val list = map[root]
                list!!.add(child)
                map[root] = list
            } else {
                val arrayList = arrayListOf<Int>()
                arrayList.add(child)
                map[root] = arrayList
            }

            if (map.contains(child)) {
                val list = map[child]
                list!!.add(root)
                map[child] = list
            } else {
                val arrayList = arrayListOf<Int>()
                arrayList.add(root)
                map[child] = arrayList
            }
        }
//        dfs(0, 0, 0, checkArr, map)

        return answer
    }
}

fun dfs(root: Int, ship: Int, wolf: Int, checkArr: BooleanArray, map: HashMap<Int, ArrayList<Int>>, info: IntArray) {

    var newShip = ship
    var newWolf = wolf
    if (info[root] == 0) {
        newShip++
    } else if (info[root] == 1) {
        newWolf++
    }
    if (newShip <= newWolf) {
        return
    }
    val list = map[root]
    if (list == null) {
        return
    } else {

    }
}
