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
    val numbers = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
    val hand = "right"
    val solution = Solution5()
    println(solution.solution(numbers, hand))
}
class Solution5 {
    fun solution(numbers: IntArray, hand: String): String {

        val table = Array(4) { Array(4) { 0 } }
        /*
        number = 1 [0][0]
        number = 2 [0][1]
        number = 3 [0][2] // 첫번째 인덱스는 4로 나눈 몫, 두번째 인덱스는 나머지 -1
        number = 4 [1][0] //
        number = 5 [1][1]
        number = 6 [1][2]
        number = 7 [2][0]
        number = 8 [2][1]
        number = 9 [2][2]
        number = * [3][0]
        number = 0 [3][1]
        number = # [3][2]

         */
        var answer = StringBuilder()

        var leftIdx = -1 // *
        var rightIdx = 10 // #
        for (i in numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer.append("L")
                leftIdx = i
            } else if (i == 3 || i == 6 || i == 9) {
                answer.append("R")
                rightIdx = i
            } else { // 가운데 숫자가 눌릴 때
                if (leftIdx == -1) {

                }
                if (rightIdx == 10) {
                }
            }
        }
        return answer.toString()
    }
}

/*


        val top = arrayOf(1, 2, 3, 4) // 내가 현재 위치가 1,3일 때, 2,5,8,0에 대한 거리
        val middle = arrayOf(2, 1, 2, 3) // 내 위치가  4,6일 때 2,5,8,0에 대한 거리
        val bottom = arrayOf(3, 2, 1, 2) // 내 위치가 7,9일 때 2,5,8,0에 대한 거리
        val top2 = arrayOf(0, 1, 2, 3) // 내위치가 2
        val middle5 = arrayOf(1, 0, 1, 2) // 내위치가 5
        val bottom8 = arrayOf(2, 1, 0, 1) // 내위치가 8
        val zero = arrayOf(3, 2, 1, 0) // 내위치가 0
 */
