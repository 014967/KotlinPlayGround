package baekjoon.당근훔쳐먹기

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

data class Carrot(
    val origin: Int,
    val growth: Long
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, t) = readLine().split(" ").map { it.toInt() }
    val carrotList = arrayListOf<Carrot>()

    for (i in 1..n) {
        val (wi, pi) = readLine().split(" ").map { it.toInt() }
        // wi 는 당근의 원래 맛, pi는 영양제
        carrotList.add(
            Carrot(wi, pi.toLong())
        )
    }

    /*
    안먹고 있다가, t-n일때 수확을 시작
     */

    carrotList.sortBy { it.growth }
    var waitTime = t - n

    var result = 0L
    for (i in carrotList.indices) {
        val (origin, growth) = carrotList[i]
        result += origin + waitTime * growth + i * growth
    }
    println(result)
}
/*

텃밭에 N종류의 당근을 하나씩 심고, T일 동안 재배

당근 i는 wi의 맛을 가지고 있다.
각 당근 i에 사용할 pi만큼 맛을 증가시켜주는 영양제가 종류별로 T개씩 준비되어있다.
pi >= wi값을 가진다.

오리는 각 당근 i에 대해 당근 i가 자리에 없으면 당근 i를 심는다. 그렇지 않다면 당근 i에 영양제를 준다.

토끼는 하루에 최대 하나의 당근만 먹거나 안먹을 수 있다.
토끼는 자신이 먹은 당근의 맛의 합을 최대로 하고 싶어한다.

T일 동안토끼가 먹으 수 있는 당근의 맛의 합의 최대를 구해
 */
