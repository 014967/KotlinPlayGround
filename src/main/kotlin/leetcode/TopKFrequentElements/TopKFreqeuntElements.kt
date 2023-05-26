package leetcode.TopKFrequentElements

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
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = IntArray(k) { 0 }
        val numsSet = nums.toList().toSet()
        val map = HashMap<Int, Int>()
        numsSet.forEach { numSet ->
            val count = nums.filter { num ->
                numSet == num
            }.count()
            map[numSet] = count
        }
        val list = map.toList().sortedByDescending { it.second }.take(k).map {
            it.first
        }.toIntArray()
        return list
    }
}
