package youtube.dp

import kotlin.math.min

/**
 * @desc
 * N가지 종류의 화폐가 잇다. 이 화폐들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록하려고한다
 * 이때의 각 종류의 화폐 몇 개라도 사용할 수 있습니다.
 * 예를 들어 2원, 3원 단위의 화폐가 있을 때는 15원을 만들기 위해 3원을 5개 사용하는 것이 가장 최소한의 화폐 개수이다
 * M원을 만들기 위한 최소한의 화폐 개수를 출력하는 프로그램을 작성하세요
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val nm = readLine()?.split(" ")?.map { it.toInt() }
    if (nm != null) {
        val n = nm[0]
        val m = nm[1]
        require(n in 1..100)
        require(m in 1..10000)
        println(solution(n, m))
    }
}
private fun solution(n: Int, m: Int): Int {
    var answer = 0
    val dp = List<Int>(m + 1) { Int.MAX_VALUE }.toMutableList()
    val coinTable = List<Int>(n + 1) { 0 }.toMutableList()

    coinTable[0] = 0
    // 우리가 원하는 것은 m일때의 갯수이다.
    for (i in 1..n) {
        val coin = readLine()?.toInt()
        if (coin != null) {
            coinTable[i] = coin
        }
    }

    dp[0] = 0
    for (i in 1..n) {
        // i 는 각각의 화폐 단위  모든 코인을 확인해보겠다.
        // j 는 각각의 금액
        for (j in coinTable[i]until m + 1) {
            if (dp[j - coinTable[i]] != Int.MAX_VALUE) { // i-k원을 만드는 방법이 존재하는 경우
                dp[j] = min(dp[j], dp[j - coinTable[i]] + 1)
            }
        }
    }

    if (dp[m] == Int.MAX_VALUE) {
        answer = -1
    } else {
        answer = dp[m]
    }

    return answer
}
/**
 작은 문제부터 접근하자. 각 금액을 만들 수 있는 최소환의 화폐 갯수가 있는지 확인하자
 a_i = 금액 i를 만들 수 있는 최소한의 화폐개수
 k = 각 화폐의 단위
 점화식 : 각 화폐 단위인 k를 하나씩 확인하며 !!!! 하나씩 확인해본다.
 - a_(i-k) 를 만드는 방법이 존재하는 경우, a_i = min(a_i , a(i-k) + 1)
 i-k원을 만들 수 있다고 하면, 현재 확인하는 화폐만 추가해 줄 수 있다면 , 화폐 i에 대한 optimal solution을 만들 수 있다.
 - a_(i-k) 를 만드는 방법이 존재하지 않는 경우, a_i = INF
 */
