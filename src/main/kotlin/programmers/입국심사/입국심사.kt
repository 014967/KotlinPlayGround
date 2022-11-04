package programmers.입국심사

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
    val n = 6
    val times = intArrayOf(7, 10)
    println(solution.solution(n, times))
}

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = Long.MAX_VALUE
        times.sort()
        val table = times.map {
            it.toLong()
        }

        var low = 0L
        var high = table.last() * n

        while (low <= high) {
            val mid = (low + high) / 2
            val sum = table.fold(0L) { acc, i ->
                acc + (mid / i)
            }.toLong()
            if (sum < n) {
                low = mid + 1
            } else {
                high = mid - 1
                answer = answer.coerceAtMost(mid)
            }
        }
        return answer
    }
}

/*



 */
/*
n명이 입국심사를 위해 줄을 서서 기다린다.
각 심사관마다 심사하는데 걸리는 시간이 다름

모든 심사대는 비어있다.
한 심사대에서 동시에 한 명만 심사를 할 수 있다.
가장 앞에 서있는 사람은 비어있는 심사대로 가서 심사를 받을 수 있다.
하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶다.
걸리는 시간을 최소로 하기 위해서는 -> 이것을 mid로 탐색을 진행해야할꺼같은데
입국 심사를 기다리는 사람은 1명 이상 1_000_000_000명 이하
각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1_000_000_000분 이하이다.
심사관은 1명이상 100_000 이하

탐색은 현재 심사가 가능한 심사원을 찾아야하는게 아닐까 ?
근데 정렬이 필요하다.
아 그니까 심사원을 times로 걸리는 시간 순으로 정렬을 하자.
그리고 1분씩 지날 때마다 누적합을 해줘서 비어있는지 아닌지 해줘야할꺼같은데 ?



 */
