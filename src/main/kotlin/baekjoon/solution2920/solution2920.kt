package baekjoon.solution2920

/**
 * @desc
 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 * @input
 * 첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.
 * @output
 * 첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
 * @example
 * 1 2 3 4 5 6 7 8 -> ascending
 */

fun main() {
    val s = readLine()?.split(" ")?.map {
        it.toInt()
    }
    if (s != null) {
        print(solution2(s))
    }
}
fun solution1(s: List<Int>) {
    val ascendingList = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)
    val descendingList = listOf<Int>(8, 7, 6, 5, 4, 3, 2, 1)

    if (s == ascendingList) {
        println("ascending")
    } else if (s == descendingList) {
        println("descending")
    } else {
        println("mixed")
    }
}
fun solution2(s: List<Int>): String {
    var result = ""
    if (s[0] == s[1] - 1) {
        result = "ascending"
    }
    if (s[0] == s[1] + 1) {
        result = "descending"
    }
    for (i in 2 until s.size - 1) {
        if (s[i] == s[i + 1] - 1) {
            result = "ascending"
        } else if (s[i] == s[i + 1] + 1) {
            result = "descending"
        } else {
            result = "mixed"
            break
        }
    }
    return result
}
