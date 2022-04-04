package programmers.highscorekit.dfsbfs

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
    solution(begin, target, words)
}
private fun solution(begin: String, target: String, words: Array<String>): Int {
    var answer = Integer.MAX_VALUE

    val check = List<Boolean>(words.size) { false }.toMutableList()
    for (i in words.indices) { // 모든 단어들을 다 돌아보자.
        // 한단어가 선택이 되어서 반영이 되었다면 true로
        var changeCount = 0

        changeCount = dfs(words, i, begin, target, check, changeCount)
        if (changeCount < answer) {
            answer = changeCount
        }
    }
    return answer
}
private fun dfs(
    words: Array<String>,
    index: Int,
    begin: String,
    target: String,
    check: MutableList<Boolean>,
    changeCount: Int
): Int {
    var count = 0
    var chCount = changeCount
    var targetCount = 0
    for (i in target.indices) {
        if (begin[i] != target[i]) { // begin으로 바로 cog로 갈수 있니?
            targetCount++
        }
    }
    if (targetCount == 1) { // 갈수 있어
        return chCount++
    }
    for (i in begin.indices) {
        if (begin[i] != words[index][i])
            count++ // 비교하려는 문자열과 words의 문자열을 확인해본다.
    }
    if (count == 1) {
        check[index] = true // 하나의 문자열만 다르다면 해당으로 이동하자.
        val start = words[index]
        chCount++
        words.forEachIndexed { idx, word ->
            if (!check[idx]) {
                // begin은 이동한 문자.
                dfs(words, idx, start, target, check, chCount)
            }
        }
    } else {
        dfs(words, index + 1, begin, target, check, chCount)
    }
    return 0
}

/*
모든 word를 돈다.
 */
