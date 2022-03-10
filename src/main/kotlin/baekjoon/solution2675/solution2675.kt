package baekjoon.solution2675

import java.util.StringTokenizer

/**
 * @desc
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
 * S에는 QR Code "alphanumeric" 문자만 들어있다.
 * QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 * @input
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
 * @output
 * 각 테스트 케이스에 대해 P를 출력한다.
 * @example
 *
 */

fun main() {
    val n = readLine()!!.toInt()
    solution(n)
}
fun solution(n: Int) {

    val list = listOf<Table>().toMutableList()
    for (i in 0 until n) {
        val str = StringTokenizer(readLine(), " ")
        val f = str.nextToken().toInt()
        val s = str.nextToken()
        val c = Table(f, s)
        list.add(c)
    }
    for (table in list) {
        for (s in 0 until table.text.length) {
            for (i in 0 until table.count) {
                print(table.text[s])
            }
        }
        println()
    }
}
class Table(f: Int, s: String) {
    val count: Int = f
    val text: String = s
}
