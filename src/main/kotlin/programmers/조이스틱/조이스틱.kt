package programmers.조이스틱

import kotlin.math.abs
import kotlin.math.min

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
    val list = listOf("JEROEN","JAN")
    list.forEach {
        println(solution.solution(it))
    }
}
class Solution {
    fun solution(name: String): Int {
        var answer = 0
        val start = StringBuilder()

        var minRightLeft = name.length - 1
        repeat(name.length) {
            start.append("A")
        }

        for (i in name.indices) {
            answer += getUpDownCount(name[i]) // 일단 위아래 다 더하기
            var next = i + 1
            while (next < name.length && name[next] == 'A') {
                next++
            }
            minRightLeft = min(minRightLeft, i * 2 + name.length - next)
        }

        return answer
    }
    fun getUpDownCount(c: Char): Int {
        return min(abs(c.code - 'A'.code), abs(c.code - 'Z'.code) + 1)
    }
}
/*

맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.

name	return
"JEROEN"	56
"JAN"	23

ABCDEFGHIJKLMNOPQRSTUVWXYZ

 */
