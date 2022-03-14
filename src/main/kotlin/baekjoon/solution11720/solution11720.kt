package baekjoon.solution11720

/**
 * @desc
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 * @input
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * @output
 * 입력으로 주어진 숫자 N개의 합을 출력한다.
 * @example
5
54321
 ->
15
 */

fun main() {
    val n = readLine()?.toInt()
    if (n != null) {
        solution(n)
    }
}
fun solution(n: Int) {

    val str = readLine()?.toList()?.map {
        Character.getNumericValue(it)
    }?.take(n)
    if (str != null) {
        var count = 0
        for (i in str.indices) {
            count += str[i]
        }
        print(count)
    }
}
