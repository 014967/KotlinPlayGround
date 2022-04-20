package baekjoon.solution18108

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
CPC Bangkok Regional에 참가하기 위해 수완나품 국제공항에 막 도착한
팀 레드시프트 일행은 눈을 믿을 수 없었다. 공항의 대형 스크린에 올해가 2562년이라고 적혀 있던 것이었다.
불교 국가인 태국은 불멸기원(佛滅紀元), 즉 석가모니가 열반한 해를 기준으로 연도를 세는 불기를 사용한다.
반면, 우리나라는 서기 연도를 사용하고 있다. 불기 연도가 주어질 때 이를 서기 연도로 바꿔 주는
프로그램을 작성하시오.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().toInt()
    require(str in 1000..3000)
    println(str - 543)
}
