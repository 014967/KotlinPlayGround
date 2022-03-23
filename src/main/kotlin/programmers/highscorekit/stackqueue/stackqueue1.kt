package programmers.highscorekit.stackqueue

import java.util.*

/**
 * @desc
 * 각 기능은 진도가 100%일 때 서비스에 반영 가능
 * 속도가 다 다르기 때문에, 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됌.
 * 먼저 배포 되어야하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다
 * 몇 개의 기능이 배포되는지를 return 하도록 solution함수를 완성해라
 * @limit
 * 작업의 갯수(progresses, speeds 배열의 길이 ) 는 100개 이하이다.
 * 작업 진도는 100미만 자연수다
 * 작업 속도는 100이하의 자연수다
 * 배포는 하루에 한번만 할 수잇다. 하루의 끝에 이루어 진다.
 * 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어진다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
//    val progresses = intArrayOf(93, 30, 55)
//    val progresses = intArrayOf(95, 90, 99, 99, 80, 99)
//    val progresses = intArrayOf(96,99,98,97)
//    val progresses = intArrayOf(20,99,93,30,55,10)
//    val progresses = intArrayOf(97, 98, 95, 94, 96)
    val progresses = intArrayOf(95, 95, 95, 95)
//    val speeds = intArrayOf(1, 30, 5)
//    val speeds = intArrayOf(1, 1, 1, 1, 1, 1)
//    val speeds = intArrayOf(1,1,1,1)
//    val speeds = intArrayOf(5,10,1,1,30,5)
//    val speeds = intArrayOf(1, 1, 1, 1, 1)
    val speeds = intArrayOf(4, 3, 2, 1)
    println(solution(progresses, speeds))
}
fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    // 결국 선입 선출이라는 말인거같음 queue로 작업을 해야할듯
    var answer = intArrayOf()
    val progressQueue = LinkedList<Int>()
    val speedQueue = LinkedList<Int>()
    val map = HashMap<Int, Int>()
    for (i in 0 until progresses.size) {
        progressQueue.offer(progresses[i])
        speedQueue.offer(speeds[i])
    }

    var count = 0
    while (progressQueue.size != 0) {

        if (progressQueue.get(0) >= 100) {
            progressQueue.poll()
            speedQueue.poll()
            if (map.contains(count)) {
                val value = map[count]?.plus(1)
                if (value != null)
                    map[count] = value
            } else {
                map[count] = 1
            }
        } else {
            for (i in 0 until progressQueue.size) {
                progressQueue[i] = progressQueue.get(i).plus(speedQueue[i])
            }
            count++
        }
    }
    val s = map.toList().sortedBy { it.first }
    val list = mutableListOf<Int>()
    for (i in s) {
        list.add(i.second)
    }

    answer = list.toIntArray()
    println(answer.toList())

    return answer
}
