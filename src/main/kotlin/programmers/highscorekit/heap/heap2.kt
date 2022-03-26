package programmers.highscorekit.heap

import java.util.*

/**
 * @desc
 * 하드디스크는 한 번에 하나의 작업만 수행할 수있다. 디스크 컨트롤러를 구현하는 방법은 여러가지가 있다.
 * 가장 일반적인 방법은 요청이 들어온 순서대로 처리를 하는것이다.
 *
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val jobs: Array<IntArray> = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6), intArrayOf(0, 2))
    val result = solution(jobs)
    println(result)
}
fun solution(jobs: Array<IntArray>): Int {
    var answer = 0
    val waitingQueue = PriorityQueue<IntArray>(
        compareBy({ it.get(0) }, { it.get(1) }) // 시작 시간 순으로 정렬하고, 같다면 소요 시간순으로 정렬해라
    )

    val workingQueue = PriorityQueue<IntArray>(
        compareBy({ it.get(1) }, { it.get(0) }) // 소요 시간 순으로 정렬하고, 같다면 시작 시간순으로 정렬해라.
    )

    var time = 0
    waitingQueue.addAll(jobs)
    while (waitingQueue.isNotEmpty() || workingQueue.isNotEmpty()) {
        // waiting 큐와 working 큐 둘중에 하나라도 남았을 경우에 계속 실행한다.
        while (waitingQueue.isNotEmpty() && waitingQueue.peek()[0] <= time) {
            workingQueue.offer(waitingQueue.poll()) // 현재 시간 안에 들어온 작업들을 모두 working queue에 넣는다
        }
        if (workingQueue.isNotEmpty()) {
            time += workingQueue.peek().get(1) // 현재 working queue의 작업이 끝난 시간으로 이동한다.
            // 왜 += 하는가 . 작업이 순차적으로 진행되기 때문에 한 작업이 끝날 때마다 소요 시간을 더해준다.
            answer += time - workingQueue.peek().get(0)
            // 현재 시간에서 해당하는 작업의 시작 시간을 빼준다면 총 소요시간에 도착하게 된다.
            workingQueue.poll()
            // 실행이 끝난 작업을 working queue에서 제외한다.
        } else {
            if (waitingQueue.isNotEmpty()) {
                time = waitingQueue.peek().get(0)
                // 가장 가까운 요청시간으로 이동한다.
            }
        }
    }
    answer /= jobs.size
    return answer
}
