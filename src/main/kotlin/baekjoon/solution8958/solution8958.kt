package baekjoon.solution8958

/**
 * @desc
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
 *  예를 들어, 10번 문제의 점수는 3이 된다.
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 * @input
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
 * @output
 * 각 테스트 케이스마다 점수를 출력한다.
 * @example
 *
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
 ->>
10
9
7
55
30
 */

fun main() {
    val n = readLine()?.toInt()
    if (n != null) {
        solution(n)
    }
}
fun solution(n: Int) {
    val strList = mutableListOf<String>()
    for (i in 1..n) {
        val str = readLine().toString()
        require(str.length < 80)
        require(str.isNotEmpty())
        strList.add(str)
    }

    for (i in 0 until strList.size) {
        var result = 0
        var count = 0
        for (j in 0 until strList[i].length) {
            if (strList[i][j] == 'O') {
                count ++
                result += count
            } else {
                count = 0
            }
        }
        println(result)
    }
}
