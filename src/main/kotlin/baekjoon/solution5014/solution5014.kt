package baekjoon.solution5014

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
F : 건물 총 층
S : 지금 이쓴 층
G : 타켓 층
U : 위로 u층만큼 감
D : 아래로 d층만큼 감

위나 아래로 해당하는  층이 없을 경우에는 엘베를 움직이지 않음
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readLine().split(" ").map { it.toInt() }
    val f = line[0]
    val s = line[1]
    val g = line[2]
    val u = line[3]
    val d = line[4]
    val check = Array<Boolean>(f + 1) { false }
    bfs(totalStage = f, startStage = s, targetStage = g, up = u, down = d, check = check)
}
private fun bfs(totalStage: Int, startStage: Int, targetStage: Int, up: Int, down: Int, check: Array<Boolean>) {

    var queue = LinkedList<Int>()
    queue.offer(startStage)

    val tempQueue = LinkedList<Int>()
    check[startStage] = true
    var count = 0
    var flag = false
    if (startStage == targetStage) {
        println(count)
        return
    }
    while (queue.isNotEmpty()) {
        val currentStage = queue.poll()
        val nextUpStage = currentStage + up
        val nextDownStage = currentStage - down

        if (currentStage == targetStage) {
            flag = true
            break
        }

        if (nextUpStage in 1..totalStage && !check[nextUpStage]) {
            tempQueue.offer(nextUpStage)
            check[nextUpStage] = true
        }
        if (nextDownStage in 1..totalStage && !check[nextDownStage]) {
            tempQueue.offer(nextDownStage)
            check[nextDownStage] = true
        }
        if (queue.isEmpty()) {
            count++
            queue = LinkedList(tempQueue)
            tempQueue.clear()
        }
    }
    if (count == 0 || !flag) {
        println("use the stairs")
    } else {
        println(count)
    }
}
