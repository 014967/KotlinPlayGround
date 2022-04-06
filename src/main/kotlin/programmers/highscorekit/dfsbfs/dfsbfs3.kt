package programmers.highscorekit.dfsbfs

import kotlin.math.min

/**
 * @desc
두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로
변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
제한사항
각 단어는 알파벳 소문자로만 이루어져 있습니다.
각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
begin과 target은 같지 않습니다.
변환할 수 없는 경우에는 0를 return 합니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val begin: String = "hit"
    val target: String = "cog"
    val words: Array<String> = arrayOf("hot", "dot", "dog", "lot", "log", "cog")
    // solution(begin, target, words)
    val Solution = Solution()
    println(Solution.solution(begin, target, words))
}

class Solution {
    var answer = Integer.MAX_VALUE
    var checkWords: BooleanArray = booleanArrayOf()
    fun solution(begin: String, target: String, words: Array<String>): Int {
        // 한단어가 선택이 되어서 반영이 되었다면 true로
        // 모든 단어를 첫번째 시작으로 다 돌아보자.그중에 가장 최적인 수를 answer에 넣는다.

        val change = 0
        checkWords = BooleanArray(words.size)
        dfs(words, begin, target, change) // words의 인덱스별로 탐색을 한다. begin과 target도 넘긴다.

        if (answer == Integer.MAX_VALUE) {
            answer = 0
        }
        return answer
    }
    private fun dfs(
        words: Array<String>, // 단어 목록
        begin: String, // 시작값 hit 고정
        target: String, // 타겟값 cog 고정
        change: Int,

    ) { // 우리가 반환하고나 하는 것은 단어를 몇개를 변환해서 도착했는가 이다.

        // begin 은 변하면 안될 것 같고 현재의 단어를 저장하는 변수를 선언하자. > currentWord
        // 재귀로 갈꺼니까 종료조건을 일단 말하자.

        if (begin == target) {
            answer = min(answer, change)
        }
        // for문을 돌아가면서 1개의 단어변경으로 만들 수 있는 단어를 찾는다.

        for (i in words.indices) {

            if (!checkWords[i] && checkDiff(begin, words[i])) {
                // 탐색을 하지 않았던 워드라면 해당하는 단어로 깊은 탐색을 해야할 것 같음
                checkWords[i] = true // 탐색한거로 바꾸자.
                dfs(words, words[i], target, change + 1)
                checkWords[i] = false
            }
        }
    }
    private fun checkDiff(str1: String, str2: String): Boolean {
        var count = 0
        for (i in str1.indices) {
            if (str1[i] != str2[i]) {
                count++
            }
        }
        if (count == 1) {
            return true
        }
        return false
    }
}
