package programmers.`표현 간으한 이진트리`

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
    solution.solution(longArrayOf(1, 423)).forEach {
        println(it)
    }
}

class Solution {
    var answer: IntArray = intArrayOf()
    var result = 0
    lateinit var target: BooleanArray
    fun solution(numbers: LongArray): IntArray {
        answer = IntArray(numbers.size) { 0 }

        result = 1
        numbers.forEachIndexed { index, it ->

            val binary = getString(it) // 이진법 길이
            val fullBinary = getFullBinary(binary) // 0추가 이진법길이

            val root = fullBinary.length / 2
            val left = fullBinary.substring(0, root)
            val right = fullBinary.substring(root + 1)
            if (fullBinary[root] == '0') {
                answer[index] = 0
            } else {
                answer[index] = if (search(left) && search(right)) 1 else 0
            }
        }

        return answer
    }
    private fun search(binary: String): Boolean {
        if (binary.isEmpty()) {
            return true
        }

        val root = binary.length / 2
        val left = binary.substring(0, root)
        val right = binary.substring(root + 1)
        if (binary[root] == '0') {
            // 자식이 1이 있는지 확인한다.
            return isHasZero(left) && isHasZero(right)
        }

        return search(left) && search(right)
    }

    private fun isHasZero(binary: String): Boolean {
        if (binary.isEmpty()) {
            return true
        }

        val root = binary.length / 2
        val left = binary.substring(0, root)
        val right = binary.substring(root + 1)
        if (binary[root] == '1') {
            // root가 0인 트리에서 타고 내려와서 노드가 1인것을 발견했을때
            return false
        }
        /*
        전부 0인지 확인한다.
         */
        return isHasZero(left) && isHasZero(right)
    }
}
fun getFullBinary(binary: String): String {
    val length = binary.length

    var count = 1
    var exp = 1
    while (length > count) {
        exp *= 2
        count += exp
    }

    val less = count - length
    return "0".repeat(less) + binary
}

fun getString(number: Long): String {
    var builder = StringBuilder()
    var tempNum = number
    while (tempNum / 2 != 0L) {
        builder.append(tempNum % 2)
        tempNum /= 2
    }
    builder.append(1)
    return builder.toString().reversed()
}

/*
이진수를 저장할 빈 문자열생성

 */
