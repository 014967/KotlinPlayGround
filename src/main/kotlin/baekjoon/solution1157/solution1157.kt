package baekjoon.solution1157

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 * @input
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 * @output
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 * @example
 * Mississippi -> ?
 * zZa -> Z
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = br.readLine().uppercase()
    val arr = Array<Int>(26) { i -> 0 }
    var max = 0
    var result = 'A'
    for (i in st.indices) {
        if (!st[i].isWhitespace()) {
            arr[(st[i].code - 65)] += 1
            if (max < arr[(st[i].code - 65)]) {
                max = arr[(st[i].code - 65)]
                result = st[i]
            } else if (max == arr[(st[i].code - 65)]) {
                result = '?'
            }
        }
    }
    println(result)
}
