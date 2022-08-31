package baekjoon.solution10162

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 A = 5분 , B= 1분, C = 10초
 냉동음식마다 전자레인저로 요리해야할 시간 T가 "초"단위로 되어있음
 a,b,c를 저당히 눌러서 합이 정확히 T초가 되어야하고, 횟수의 합도 최소가 되어야함.
 100초라고 했을 때 B를 1번, C는 4번 누르면 됌
 정확히 T를 만들 수 없을 수도 있다
 * @input
 * 요리시간 T초가 정수로 주어져있으며 범위는 1 <= T <= 10000이다.
 * 3개의 버튼으로  T로츷 맞출 수 없으면 음수 -1을 첫 줄에 출력해야한다.
 * 해당 버튼을 누르지 않는다면 숫자 0을 출력해야한다.
 * @output
 *
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var input = readLine().toInt() // 입력받을 정수

    val table = HashMap<Int, Int>().toSortedMap(
        Comparator { o1, o2 ->
            o2 - o1
        }
    )
    table[300] = 0
    table[60] = 0
    table[10] = 0

    if (input % 10 != 0) {
        // 10초 단위로 나누어 떨어지지 않는다면 -1 출력
        println(-1)
    } else {
        for (i in table) {
            if (input / i.key > 0) {
                table[i.key] = input / i.key // count 증가
                input %= i.key
            }
        }
        table.toList().forEachIndexed { index, pair ->
            print(pair.second) // key
            if (index != table.size - 1) {
                print(" ")
            }
        }
    }
}
