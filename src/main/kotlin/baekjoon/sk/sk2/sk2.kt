package baekjoon.sk.sk2

import java.io.BufferedReader
import java.io.InputStreamReader

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

val map = HashMap<Int, ArrayList<Int>>()
lateinit var checker: BooleanArray
var count = 1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val p = intArrayOf(2, 2, -1, 1, 5, -1, 5)
    val b = intArrayOf(2, 5) // 조직원 조사해야하는 , 얘네가 최종보스면 조직원이 얼마나 속해있는지 출력
    println(solution(p, b))
}

fun solution(p: IntArray, b: IntArray): IntArray {
    var answer = IntArray(b.size) { 0 }

    for (i in p.indices) {
        if (map.containsKey(p[i])) {
            map[p[i]]?.add(i)
        } else {
            map[p[i]] = arrayListOf()
            map[p[i]]?.add(i)
        }
    }
    checker = BooleanArray(p.size) { false }

    for (i in b.indices) {
        if (map[-1]?.contains(b[i]) == true) {
            getCount(b[i])
            answer[i] = count
            count = 1
        } else {
            answer[i] = 0
        }
    }

    return answer
}

fun getCount(root: Int) {
    if (!map.containsKey(root)) {
        return
    }

    if (!checker[root]) {
        checker[root] = true
    } else {
        return
    }
    for (i in map[root]!!) {
        count++
        getCount(i)
    }
}

/*
조직원들은 자신의 보스에게 돈을 보낸다.
한 조직원당 하나의 보스만 가진다.
조직원은 여러명의 조직원으로부터 수익금을 받고, 모인 수익금을 다시 자신의 보스에게 보냄.
수익금을 낼 수 없는 경우 그 사람이 보스임.

각 조직원들의 보스가 누군지를 나타내는 배열 p, 조사하고자 하는 조직원의 아이디가 담긴 배열 b가 매개변수로 주어짐.
조사한 조직원이 최종 보스인 경우, 해당 조직의 조직원 수를 구해서 순서대로 배열에 담아 return




 */
