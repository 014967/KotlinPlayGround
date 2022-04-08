package programmers.highscorekit.binary

import java.util.*

/**
 * @desc
n명이 입국심사를 위해 줄을 서서 기다리고 있습니다.
각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.
가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가
매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를
작성해주세요.
제한사항
입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
심사관은 1명 이상 100,000명 이하입니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val n = 6
    val time = intArrayOf(7, 10)
    val solutionbi = Solutionbi()
    println(solutionbi.solution(n, time))
}

/*
해결방안
1. 무엇을 탐색할 것이고, 어떤 걸 비교할 것인지 정해라
- 이분 탐색 할 것: 심사를 받는게 걸리는 시간 (mid)
- 비교대상(target): n(입국 심사를 기다리는 사람)

2. 심사를 받는데 최소로 걸리는 시간(answer)를 구하므로 심사를 받는데 걸리는 시간(mid)를 이분탐색한다.
3. input에서 비교 대상으로 n 명이 주어지므로 n명을 target으로 정해 다음 탐색 구간을 정한다.
4. n과 비교하기 위해서 주어진 mid 시간동안 검사할 수 있는 사람 수 (sum)을 구하는 알고리즘이 포함되어야한다
5. answer를 구하기 위해 최소 시간을 찾아야한다.
 */
class Solutionbi {
    fun solution(n: Int, times: IntArray): Long {
        // 시간을 기준으로 해당 시간내에 모두 검사가 가능한지 판단하고 시간에 대해 이분탐색을 적용 ?
        var answer = Long.MAX_VALUE
        Arrays.sort(times)

        var start = 0L
        var end = Long.MAX_VALUE
        var sum = 0L
        var mid = 0L
        while (start <= end) {
            mid = (start + end) / 2
            sum = 0
            // 주어진 시간동안 몇명 검사를 할 수 있는가?
            for (i in 0 until times.size) {
                sum += mid / times[i]

                if (sum >= n) {
                    break
                }
            }

            // 만약 시간이 부족할 경우
            if (n > sum) {
                start = mid + 1 // mid의 시간으로는 안되니까 더 시간을 늘린다.
            } else {
                // 검사를 다 했을 때 시간이 남는 경우
                // 탐색하는 시간을 줄이고서 다시 탐색
                end = mid - 1
                answer = Math.min(answer, mid)
            }
        }
        return answer
    }
}
