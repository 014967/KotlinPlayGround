package programmers.highscorekit.stackqueue

import java.util.*

/**
 * @desc
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄 될 수 있습니다.
 * 이런 문제를 보완하기 위헤 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
 * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄작업을 수행합니다.
 * 1. 인쇄 대기 목록의 가장 앞에 있는 문서(J)를 대기 목록에서 꺼냅니다.
 * 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 그렇지 않다면 J를 인쇄합니다
 * 예를 들어, 4개의 문서( A,B,C,D )가 순서대로 인괘 대기목록에 잇고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서는 C는 1번째로, A는 3번째로 인쇄됩니다.
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를
 * 알려주는 location이 매개 변수로 주어질때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 * 제한 사항
 * 1. 현재 대기 목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 2. 인쇄 작업의 중요도는 1~9로 펴햔하며 숫자라 클수록 중요하다는 뜻이다
 * 3. location은 0 이상(현재 대기 목록에 있는 작업 수 - 1 ) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0 , 두번째에 있으면 1로 표현합니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val priorities = intArrayOf(2, 1, 3, 2)
    val location = 2 // 내가 요청한 문서의 위치
    // 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return하도록 해라.
    val result = solution(priorities, location)
}
fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    var queue = LinkedList<Int>()
    var priList = LinkedList<Int>()
    var lo = location
    for (i in 0 until priorities.size) {
        println("$i : ${priorities[i]}")
        queue.offer(priorities[i])
        priList.offer(priorities[i])
    }
    val s = queue.sortedDescending()
    queue = LinkedList(s)

    var count = 0
    while (true) {
        if (priList.first() == queue.first() && lo == 0) {
            answer = count + 1
            break
        } else if (priList.first() != queue.first() && lo == 0) {
            priList.offer(priList.poll())
            lo = priList.size - 1
        } else if (priList.first() == queue.first() && lo != 0) {
            priList.poll()
            queue.poll()
            lo -= 1
            count++
        } else {
            val s = priList.poll()
            priList.offer(s)
            lo -= 1
        }
    }

    println(answer)
    return answer
}
