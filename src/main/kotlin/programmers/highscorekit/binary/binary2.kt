package programmers.highscorekit.binary

import java.util.*

/**
 * @desc
출발지점부터 distance만큼 떨어진 곳에 도착지점이 있습니다. 그리고 그사이에는 바위들이 놓여있습니다.
바위 중 몇 개를 제거하려고 합니다.
예를 들어, 도착지점이 25만큼 떨어져 있고, 바위가 [2, 14, 11, 21, 17] 지점에 놓여있을 때 바위 2개를 제거하면
출발지점, 도착지점, 바위 간의 거리가 아래와 같습니다.
제거한 바위의 위치	각 바위 사이의 거리	거리의 최솟값
[21, 17]	[2, 9, 3, 11]	2
[2, 21]	[11, 3, 3, 8]	3
[2, 11]	[14, 3, 4, 4]	3
[11, 21]	[2, 12, 3, 8]	2
[2, 14]	[11, 6, 4, 4]	4
위에서 구한 거리의 최솟값 중에 가장 큰 값은 4입니다.
출발지점부터 도착지점까지의 거리 distance, 바위들이 있는 위치를 담은 배열 rocks,
제거할 바위의 수 n이 매개변수로 주어질 때, 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을
return 하도록 solution 함수를 작성해주세요.
제한사항
도착지점까지의 거리 distance는 1 이상 1,000,000,000 이하입니다.
바위는 1개 이상 50,000개 이하가 있습니다.
n 은 1 이상 바위의 개수 이하입니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */
fun main() {
    val distance = 25
    val rocks = intArrayOf(2, 14, 11, 21, 17)
    val n = 2
    val solutionbi2 = Solutionbi2()
    println(solutionbi2.solution(distance, rocks, n))
}
class Solutionbi2 {
    /*
    해결방안
1. 무엇을 탐색할 것이고, 어떤 걸 비교할 것인지 정해라
- 이분 탐색 할 것: 바위 사이의 거리  (mid)
- 비교대상(target): 도착지점까지의 거리

2. 바위 사이의 거리를 구하므로 , 바위 사이의 거리는 이분 탐색해야하는데
3. input에서 비교 대상으로 거리가 주어지므로 distance을 target으로 정해 다음 탐색 구간을 정한다.
     */
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = -1
        Arrays.sort(rocks)
        var start = 1
        var end = 25

        while (start <= end) {
            var mid = (start + end) / 2
            var prevRock = 0
            var count = 0
            for (i in rocks.indices) {
                if (rocks[i] - prevRock < mid) {
                    count++
                } else {
                    prevRock = rocks[i]
                }
            }
            if (distance - prevRock < mid) { // 맨마지막 바위와 끝 거리의 거리 계산
                count ++
            }
            if (count <= n) {
                // count => 제거 돌 갯수
                answer = if (mid > answer) mid else answer // 최대를 구함
                start = mid + 1
                // 제거를 덜했다면 start를 더함
            } else {
                end = mid - 1 // 제거를 더 많이 했다면 right를 줄임
            }
        }
        return answer
    }
}
