package youtube.dp

/**
 * @desc
 n * m 크기의 금광이 있습니다. 금강은 1 * 1 크기의 칸으로 나뉘어져 있으며,
 각 칸은 특정한 크기의 금이 들어있습니다.
 채굴자는 첫 번째 열부터 출발하여 금을 캐기 시작하빈다.
 맨 처음에는 첫 번째 열의 어느 행에서든 출발 할 수 있습니다. 이후에 m -1 번에 걸쳐서
 매번 오른쪽 위, 오른쪽, 오른쪽 아래 3가지 중 하나의 위치로 이동해야합니다.
 결과적으로 채굴자가 얻을 수 있는 금의 최대 크기를 출력하는 프로그램을 작성하세요
 * @input
 * 첫째 줄에테스트 케이스 T가 입력된다 ( 1<= T <= 1000)
 * 매 테스트 케이스 첫째 줄에 n 과  m이 공백으로 구분되어 입력된다
 * (1<=n , m<=20)둘째줄에 n*m개의 위치에 매장된 금의 개수가 공백으로 구분되어
 * 입력된다. ( 1 <= 각 위치의 매장된 금의 갯수 <=100)
 * @output
 * 테스트 케이스 마다 채굴자가 얻을 수 있는 금의 최대 크기를 출력한다.
 * 각 테스트 케이스는 줄 바꿈을 이용해 구분한다.
 * @example
 *
 */

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    require(T in 1..1000)
    for (i in 1..T) {
        val size = readLine().split(" ").map { it.toInt() }
        val n = size[0]
        val m = size[1]
        val gold = readLine().split(" ").map {
        }
    }
}
