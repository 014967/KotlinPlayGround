package leetcode.GroupAnamgram

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
// 10000

fun main() {
    val sol = Solution()
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = sol.groupAnagrams(strs)
    println(result)
}

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var result = mutableListOf(mutableListOf(""))
        val check = BooleanArray(strs.size) { false }

        if (strs.isNotEmpty()) {
            for (i in strs.indices) {
                if (check[i]) {
                    continue
                }
                val current = strs[i]
                val tempList = mutableListOf<String>().apply {
                    add(current)
                }
                check[i] = true

                for (j in i + 1 until strs.size) {
                    if (check[j]) {
                        continue
                    }
                    val next = strs[j]
                    if (isEquals(current, next)) {
                        check[j] = true
                        tempList.add(next)
                    }
                }
                result.add(tempList)
            }
        }
        if (result.size != 1) {
            result.removeAt(0)
        }

        return result
    }

    fun isEquals(s: String, t: String): Boolean {
        var result = true

        if (s.length != t.length) {
            result = false
        } else {
            val map = HashMap<Char, Int>()
            for (i in s) {
                if (map.containsKey(i)) {
                    val count = map[i]!!
                    map[i] = count + 1
                } else {
                    map[i] = 1
                }
            }

            for (i in t) {
                if (map.containsKey(i)) {
                    val count = map[i]!!
                    if (count == 0) {
                        result = false
                        break
                    } else {
                        map[i] = count - 1
                    }
                } else {
                    result = false
                    break
                }
            }
        }

        return result
    }
}
