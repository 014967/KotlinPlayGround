package baekjoon.이동하기

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

//lateinit var table: Array<Array<Int>>
//lateinit var dp: Array<Array<Int>>
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val (r, c) = readLine().split(" ").map { it.toInt() }
//    table = Array(r + 1) { Array(c + 1) { 0 } }
//    dp = Array(r + 1) { Array(c + 1) { 0 } }
//
//    for (i in 1..r) {
//        val line = readLine().split(" ").map { it.toInt() }
//        for (j in line.indices) {
//            table[i][j + 1] = line[j]
//        }
//    }
//    dp[1][1] = table[1][1]
//    bfs(vertex = Vertex(1, 1), r, c)
//}
//
//val dx = listOf(1, 0, 1)
//val dy = listOf(0, 1, 1)
//
//data class Vertex(
//    val x: Int,
//    val y: Int
//)
//fun bfs(vertex: Vertex, r: Int, c: Int) {
//    val queue = LinkedList<Vertex>()
//    queue.offer(vertex)
//
//    while (queue.isNotEmpty()) {
//        val currentVertex = queue.poll()
//        val x = currentVertex.x
//        val y = currentVertex.y
//        val currentCandy = dp[x][y]
//
//        if (x == r && y == c) {
//            break
//        }
//
//
//        for (i in 0..2) {
//            val nextX = x + dx[i]
//            val nextY = y + dy[i]
//
//            if (nextX !in 1..r) {
//                continue
//            }
//            if (nextY !in 1..c) {
//                continue
//            }
//            val nextCandy = table[nextX][nextY]
//
//            if (dp[nextX][nextY] < nextCandy + currentCandy) {
//                dp[nextX][nextY] = nextCandy + currentCandy
//                queue.offer(Vertex(nextX, nextY))
//            }
//        }
//    }
//    println(dp[r][c])
//}
/*
1,1에서 n,m으로 이동을 하려고하는데

(r,c)에 있으면 , (r+1,c), (r,c+1), (r+1, c+1)
 */
