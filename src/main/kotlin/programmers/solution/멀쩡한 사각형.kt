package programmers.solution

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
    val w = 8
    val h = 12
    val solution = Solution9()
    println(solution.solution(w, h))
}

class Solution9 {
    fun solution(w: Int, h: Int): Int {
        var answer: Int = w * h
        val angle: Double = (h.toDouble() / w.toDouble()) // 기울기는 소수가 있어야함
        var list = mutableListOf<Pair<Int, Int>>()
        for (i in 0..w) {
            val y = -angle * i + h
            if (i == 0) {
                list.add(Pair(i, y.toInt()))
            } else if (isInteger(y)) {
                list.add(Pair(i, y.toInt()))
                break
            }
        }
        // 작은 직사각형 구하기
        var smallx = list[1].first
        var smally = list[0].second - list[1].second
        var midx = smallx / 2
        var midy = -angle / midx + h
        println(midy)
        val repeatBox = w / smallx // 이만큼 반복해야함 박스의 갯수를 구헤야함
        

        return answer
    }
    fun isInteger(num: Double): Boolean {
        return Math.ceil(num) == Math.floor(num)
    }
}
