package programmers.highscorekit.dp

/**
 * @desc
 * 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를
 * 찾아보려고한다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽
 * 으로만 이동이 가능하다.
 * 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능하다.
 *
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어 질 때,
 * 거쳐간 숫자의 최댓값을 return하도록 solution함수를완성해라ㅒ
 *
 * 삼각형의 높이는 1이상 500이하다
 * 삼각형을 이루고 있는 숫자는 0이상 9999이하의 정수이다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val triangle = arrayOf(intArrayOf(7), intArrayOf(3, 8), intArrayOf(8, 1, 0), intArrayOf(2, 7, 4, 4), intArrayOf(4, 5, 2, 6, 5))
    solution(triangle)
}
fun solution(triangle: Array<IntArray>): Int {
    var answer = 0
    var size = 0
    for (i in triangle) {
        size += i.size
    }
    // var dp = IntArray(size) { 0 }
    var dp = triangle.copyOf().toMutableList()


    for (i in 1 until triangle.size) {
        // i 번째 줄의 최적해
        for (j in 0 until triangle.get(i).size) {
            // 행의 요소를 접근하겠다.
            if (j == 0) {
                dp[i][j] += dp[i - 1][j]
            } else if (j == triangle.get(i).size - 1) {
                dp[i][j] += dp[i - 1][j - 1]
            } else {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + dp[i][j], dp[i - 1][j] + dp[i][j])
            }
            if (dp[i][j] > answer) {
                answer = dp[i][j]
            }
        }
    }



    return answer
}
/*
        7
       3 8
      8 1 0
     2 7 4 4
    4 5 2 6 5


3에서는 그 아래칸의 8또는 1로만 이동이 가능하다.
[1][0] -> [2][0] , [2][1]
[1][1] -> [2][1], [2][2]
[2][0] -> [3][0], [3][1]
[2][1] -> [3][1], [3][2]
[2][2] -> [3][2] , [3][3]

각 점까지의  최적의해를 구해야할 것 같다.
0 = triangle[0][0]
1 =

 */
/*
dp -> i번째 줄까지의 최적 해
dp[0] = 7
dp[1] = max(dp[0] + arr[1][0], dp[0]+ arr[1][1])
dp[2] = max( (dp[0]+ arr[1][0]) + arr[2][0] , (dp[0]+ arr[1][0]) + arr[2][1] , (dp[0]+dp[1][1]) + arr[2][1],(dp[0]+dp[1][1]) + arr[2][2]
 */
