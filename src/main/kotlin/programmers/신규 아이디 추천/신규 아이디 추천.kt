package programmers.`신규 아이디 추천`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Character.getNumericValue
import java.util.*

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val new_id = ".................................."
    val solution = Solution()
    println(solution.solution(new_id = new_id))
}
class Solution {
    fun solution(new_id: String): String {
        var answer = StringBuilder()
        var s = new_id.map {
            it.lowercaseChar()
        }.filter {
            it in 'a'..'z' || it == '_' || it == '.' || it == '-' || getNumericValue(it) in 0..9
        }

        for (i in s.indices) {
            if (s[i] == '.' && i == 0) {
                answer.append(s[i])
            } else if (s[i] == '.' && answer.last() == '.') {
            } else {
                answer.append(s[i])
            }
        }
        var list = LinkedList<Char>()
        answer.forEach { list.add(it) }
        while (list.peekFirst() == '.') {
            list.pollFirst()
        }
        while (list.peekLast() == '.') {
            list.pollLast()
        }

        var result = ""
        if (list.size == 0) {
            list.offer('a')
        } else {
            if (list.size >= 16) {
                list = LinkedList(list.subList(0, 15))
            }
        }
        if (list.size <= 2) {
            while (list.size != 3) {
                list.offer(list.peekLast())
            }
        }
        while (list.peekFirst() == '.') {
            list.pollFirst()
        }
        while (list.peekLast() == '.') {
            list.pollLast()
        }
        result = list.joinToString("")

        return result
    }
}
/*
새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천
아이디 규칙
1.  아이디 길이 = 3자 이상 15자 이하
2.  아이디는 알파벳, 숫자, - , _ , . 문자만 사용가능
3. 단 . 은 처음과 끝에 사용할 수 없음 & 연속으로 안됌

----- 변환 로직 순차적으로 처리
1. 모든 대문자를 대응하는 소문자로 치환
2. 알파벳 소문자, 빼기 , 밑줄, 마침표를 제외한 모든 문자를 제거
3. 마침표가 2번이상 연속된 부분을 하나의 마침표로 치환
4. 마침표가 처음이나 끝에 있다면 제거
5. 빈 문자열이면 "a" 대입
6. 아이디가 16자 이상이라면, 첫 15개를 제외한 나머지 문자들을 모두 제거
제거후 마침표가 끝에 위치한다면 끝에 위치한 마침표 문자 제거
7. 아이디 길이가 2자 이하라면 , 마지막 문자를 길이가 3이 될때까지 반복해서 끝에 붙임임
 */
