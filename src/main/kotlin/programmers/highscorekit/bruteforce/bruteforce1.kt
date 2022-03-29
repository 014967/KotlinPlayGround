package programmers.highscorekit.bruteforce

/**
 * @desc
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * @input
 * [1,2,3,4,5]	[1]
 [1,3,2,4,2]	[1,2,3]
 * @output
 *
 * @example
 * 입출력 예 #1
수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
입출력 예 #2
모든 사람이 2문제씩을 맞췄습니다.
 */

fun main() {
    val answers = intArrayOf(3, 3, 2, 1, 5 , 7,5,4,5)
    println(solution(answers = answers).toList())
}
fun solution(answers: IntArray): IntArray {
    var answer = intArrayOf()
    val p1 = listOf<Int>(1, 2, 3, 4, 5)
    val p2 = listOf<Int>(2, 1, 2, 3, 2, 4, 2, 5)
    val p3 = listOf<Int>(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    val map = HashMap<Int, Int>()
    map[1] = 0
    map[2] = 0
    map[3] = 0

    var p1Count = 0
    var p2Count = 0
    var p3Count = 0
    var max = Int.MIN_VALUE
    for (i in answers.indices) {

        if (p1Count == p1.size) {
            p1Count = 0
        }
        if (p2Count == p2.size) {
            p2Count = 0
        }
        if (p3Count == p3.size) {
            p3Count = 0
        }
        if (p1[p1Count] == answers[i]) {
            map[1] = map[1]?.plus(1)!!
            if (map[1]!! > max) {
                max = map[1]!!
            }
        }
        if (p2[p2Count] == answers[i]) {
            map[2] = map[2]?.plus(1)!!
            if (map[2]!! > max) {
                max = map[2]!!
            }
        }
        if (p3[p3Count] == answers[i]) {
            map[3] = map[3]?.plus(1)!!
            if (map[3]!! > max) {
                max = map[3]!!
            }
        }
        p1Count++
        p2Count++
        p3Count++
    }
    for (i in map) {
        if (i.value == max) {
            answer += i.key
        }
    }

    return answer
}
