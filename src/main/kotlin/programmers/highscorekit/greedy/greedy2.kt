package programmers.highscorekit.greedy

/**
 * @desc
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
조이스틱을 각 방향으로 움직이면 아래와 같습니다.
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
 * @input
name	return
"JEROEN"	56
"JAN"	23
 * @output
 *
 * @example
 *
 */

fun main() {
    val name = "JAN"
    println(solution(name))
}
private fun solution(name: String): Int {
    var answer = 0
    // 위아래로 움직이는 값과 좌우로 움직이는 값을 따로 계산하여 더한다
    var min = name.length - 1 // 좌우로 가장 적에 움직이는 방법은 그냥 순서대로 가는 것이다.
    for (i in name.indices) // indices로 접근하면 인덱스로 접근한다.
        {
            answer += (name[i] - 'A').coerceAtMost('Z' - name[i] + 1)
            // coerceAtMost(maximumValue) 좌측 값이 더 작거나 같으면 좌측값을 반환하고, 그렇지 않다면 우측 값을 반환한다. // 어찌됐든 최소값을 반환한다.
        }
    // 위의 반복문으로 위아래로 움직이는 값은 모두 더했다. 다음으로 좌우를 살핀다.
    for (i in name.indices) {
        if (name[i] != 'A') // A가 아니라면
            {
                var next = i + 1
                while (next <name.length && name[next] == 'A') // 다음값이 A라면 어디까지 A가 나오는지 index를 찾는다.
                    {
                        next++
                    }
                min = min.coerceAtMost(i * 2 + name.length - next)
                // i *2 인것은 갔던길을 다시 뒤돌아서 가야하니까, + 어디까지 ? 전체길이에서 A가 나오지 않는 index까지.
            }
    }
    answer += min
    return answer
}
