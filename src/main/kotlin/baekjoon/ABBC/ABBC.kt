package baekjoon.ABBC

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()

    val aQueue = LinkedList<Int>()
    val bQueue = LinkedList<Int>()

    var count = 0
    for (i in s.indices) {
        /*
        여기서 중요한 점은 A와 B를 각각 queue에 넣어서 저장하는 것.
         */
        if (s[i] == 'B') {
            bQueue.offer(i) // index를 넣어줘
        } else if (s[i] == 'A') {
            aQueue.offer(i) // index를 넣어줘.
        } else {
            // C일 경우는 어떻게 할 것인가?
            /*
            C일 경우는 B부터 지워야한다.
            그이유는 A -> B -> C의 의존성을 가지고 있기 떄문에
            일단 B를 지워버리고 남은 B가 있다면 다시 A를 통해서 지워버린다.
             */
            if (bQueue.isNotEmpty()) {
                bQueue.poll() // B의 맨마지막
                count++
            }
        }
    }
    // C로 인한 B제거 가 완료된 상태

    while (aQueue.isNotEmpty() && bQueue.isNotEmpty()) {
        val aFirst = aQueue.first()  // index
        val bFirst = bQueue.first() //
        // 각각 queue의 first로 비교하는 이유
        /* A -> B B를 지울 수 있기 때문에
        A의 인덱스이후에 B의 인덱스가 와야 지울 수가 있어서
        처음부터 비교를한다.
         */

        if (aFirst < bFirst) { // 아  b index가 a보다 뒤다
            aQueue.pollFirst()
            bQueue.pollFirst()
            count++
        } else {
            // B의 index가 A보다 앞에있는 경우로 B를 삭제할 수 있는 경우가 없어서 그냥 고려를 안하도록 없앰.
            // A보다 앞에 있는 것은 그냥 queue에서 삭제시킨다.
            // 뺄 수 없기 때문에 카운트를 증가시키지 않는다.

            // b index가 a보다 앞이다. 이경우 지울 수가 없어서, a보다 뒤에있는 b를 찾기 위해서
            bQueue.pollFirst() //
        }
    }
    println(count)
}

/*
A,B,C로만 이루어진 길이가 |s|인 문자열s 가 있다ㅏ.
A와 그 뒤에 있는 B를 지운다
B와 그 뒤에 있는 C를 지운다

각 문자는 최대 1번만 지울 수 있다.
ABCBA를 보면
1번A와 2번 B를 지운다. 이 경우 시행의 횟수는 1번이고,
남은 문자열은 CBA가 된다.
어떤 두 문자를 골라도 시행의 조건을 만족 시킬 수 없으므로 더이상 실행할 수 없다.

1번 A와 4번B를 지우고, 이어 2번 B와 3번 C를 지운다.
이경우 시행의 횟수느 2번이고, 남은 문자열은 A다.
문자열에 남은 문자가 1개이기 떄문에 더이상 시행할 ㅅ구 없다.

시행할 수 있는 최대 횟수를 구해라.


https://velog.io/@zjvlzld/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-25381-java-%EC%9E%90%EB%B0%94
 */
