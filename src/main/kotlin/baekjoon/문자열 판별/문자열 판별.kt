package baekjoon.`문자열 판별`

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

val br = System.`in`.bufferedReader()
fun main() {
    val S = br.readLine()
    require(S.length <= 100)
    val n = br.readLine().toInt()
    require(n in 1..100)

    val wordArray = Array(n) { "" }

    for (i in 0 until n) {
        val A = br.readLine().apply {
            require(this.length <= 100)
        }
        wordArray[i] = A
    }
    wordArray.sortWith(compareBy<String> { it }.thenComparing { o1, o2 -> o1.length - o2.length })
    // 글자 abc별로 정렬을 한다음에 제일 짧은 것부터 다시 정렬

    var flag = false
    while (!flag) {
        var copyString = StringBuilder(S).toString()
        // 우리가 원하는 targetString

        for (i in wordArray) {
            val regex = Regex(i) // 찾으려고하는 단어
            val matchResult: Boolean = regex.containsMatchIn(copyString)
            // 우리가 찾으려는 단어가 targetString내부에 있는지 없는지 파악 : Boolean type반환
            if (matchResult) { copyString =
                copyString.split(regex)
                    .joinToString("") { it }
                // 만약있다면 해당 단어를 targetString에서 제거한다.
            }
        }

        if (copyString.isEmpty()) {
            // targetString이 모두 제거가 되었다면 우리가 찾는 문자열로 만들 수 있다는 말이므로 flag true
            // while 문 탈출
            flag = true
        } else {
            break
        }
    }

    if (flag) {
        println(1)
    } else {
        println(0)
    }
}
/*
소문자 문자열 S와 단어목록 A가 있을때
S를 A에 포함된 문자열 한개 이상 공백없이 붙여서 만들수 있는지 없는지?

단어 여러개를 사용할 수 있다.

 */
