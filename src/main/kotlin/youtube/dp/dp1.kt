package youtube.dp

/**
 * @desc
 * 첫째 줄에 식량창고의 개수 N이 주어진다. ( 3<= N <=100)
 * 둘째 줄에 공백을 기준으로 각 식량창고에 저장된 식량의 갯수 K가 주어진다( 0 <= K <=1000)
 * @input
 *
 * @output
 * 첫째 줄에 개미 전사가 얻을 수 있는 식량의 최대값을 출력해라.
 *
 * @example
 *
 */

fun main() {
    val N = readLine()?.toInt()
    require(N in 3..100)
    if (N != null) {
        val str = readLine()?.split(" ")?.filter { it.toInt() in 0..1000 }?.map { it.toInt() }
        if (str != null)
            println(solution(str, N))
    }
}

private fun solution(str: List<Int>, N: Int): Int {
    var answer = 0
    var dp = List<Int>(N) { 0 }.toMutableList()

    /*
    (a[i]= i번째 식량 창고짜기의 최적의 해)
    이렇게 정의한다면 다이나믹 프로그래밍을 적용할 수 있다.
    DP 테이블의 값: a[0] =1 , a[1] = 3 , a[2] = 3, a[3] = 8

    왼쪽부터 차례대로 식량창고를 턴다고 했을 때, 특정한 i번째 식량창고에 대해서 털지 안 털지의 여부를 결정하면,
    2가지 경우 중에서 더 많은 식량을 털 수 있는 경우를 선택하면 된다.
    현재의 창고는 현재의 창고 index -2 를 털었다면 털 수 있고, 아니라면 털 수 없다.

    한칸 전의 최적의 해와 투칸 전의 최적의 해의 현재위치의 식량을 더한 값을 비교를 해서 더 큰 경우를 고른다?
    ->
    a[i] = i번째 식량 창고까지의 최적의 해 ( 얻을 수 있는 식량의 최댓 값)
    k[i] = i번째 식량 창고에 있는 식량의 양
    점화식
    -> a[i] = max(a[i-1],a[i-2]+k)
     */
    dp[0] = str[0]
    dp[1] = str[1].coerceAtLeast(dp[0]) // coerceAtLeast min값보다 크거나 같으면 이값. 아니면 min값
    for (i in 2 until str.size) { // for문을 이용하므로 botton Up 방식
        dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + str[i].toInt())
    }
    answer = dp[N - 1]
    return answer
}
