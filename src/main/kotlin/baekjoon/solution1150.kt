package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
당신은 큰 회사들의 컴퓨터 자료를 백업하여주는 정보통신회사를 운영한다.
자료 백업이 즐거운 일이 아니므로, 당신은 서로 다른 두 회사의 자료를 서로 백업하여
주는 시스템을 개발하여 당신이 집에서 게임을 즐기는 동안 백업이 이루어지게 하려 한다.
모든 회사들은 직선인 길을 따라 위치하고 있다. 당신은 서로 백업을 하여 줄 두 회사를 짝 지어 주어야 하는데,
두 회사 사이에 네트워크 케이블을 연결 사용하여야 한다.
네트워크 케이블은 대단히 비쌀 뿐 아니라, 지역 통신 회사에서는 당신에게 오직 k개의 네트워크 케이블을 제공한다
–이 말은 당신이 오직 k 쌍의 회사에만 백업을 할 수 있다는 뜻이다 (전체 2k 개의 회사).
어떤 회사도 두 개 이상의 쌍에 속할 수는 없다 (즉, 여기 2k 개의 회사가 모두 다른 회사라는 것을 뜻한다).
통신 회사는 네트워크 케이블의 길이를 km 단위로 경비를 부과한다. 따라서 당신은 가장 짧은 길이의
케이블을 사용하도록 회사들을 k 쌍으로 짝지어야 한다.
다시 말하자면, 회사들을 짝짓기 하는데, 짝지어진 두 회사간의 거리들의 전체 합을 최소화 하도록 짝을 지어야 한다는 것이다.
예를 들어, 아래 그림과 같이 다섯 개의 고객회사들이 같은 길 위에 위치한다고 하자.
이 회사들은 각각 길의 출발점에서 기준하여 1 km, 3 km, 4 km, 6 km 그리고 12 km 에 위치하고 있다.
통신회사에서는 오직 k = 2 케이블만을 제공한다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()
    var arr = IntArray(n) { 0 }

    for (i in 0 until n) {
        arr[i] = readLine().toInt()
    }

    val checkArr = BooleanArray(arr.size) { false }
    var answer = Integer.MAX_VALUE

    for (i in 0 until k * 2 - 1) {
        // 케이블 갯수의 * 2개만큼만 건물을 확인하면 된다
        // 첫번째 건물부터
        var max = 0
        var m = i + 1
        var s = k
        while (s != 0) {
            if (m == checkArr.size - 1)
                break

            if (!checkArr[m-1] && !checkArr[m]) {
                max += arr[m] - arr[m - 1]
                checkArr[m] = true
                checkArr[m - 1] = true
                s--
            }
            m++
        }
        if (max != 0 && s == 0)
            answer = Math.min(answer, max)
        for (i in checkArr.indices) {
            checkArr[i] = false
        }
    }

    println(answer)
}
