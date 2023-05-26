package baekjoon.`구슬 탈출 2` // ktlint-disable filename

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

// lateinit var board: Array<Array<Char>>
// lateinit var redCoord: Coordinates
// lateinit var blueCoord: Coordinates
// fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val (N, M) = readLine().split(" ").map { it.toInt() }
//    board = Array(N) { Array(M) { '#' } }
//
//    for (i in 0 until N) {
//        val row = readLine()
//        for (j in row.indices) {
//            if (row[j] == 'R') {
//                redCoord = Coordinates(i, j, Type.Red, 0)
//            }
//            if (row[j] == 'B') {
//                blueCoord = Coordinates(i, j, Type.Blue, 0)
//            }
//            board[i][j] = row[j]
//        }
//    }
//    var result = -1
//    result = bfs(redCoord, blueCoord)
//    println(result)
// }
// fun bfs(red: Coordinates, blue: Coordinates): Int {
//    val queue = LinkedList<Coordinates>()
//    queue.apply {
//        offer(red)
//        offer(blue)
//    }
//
//    var result = -1
//    while (queue.isNotEmpty()) {
//        val current = queue.poll()
//        if (current.moveCount > 10) {
//            break
//        }
//
//        if (board[current.x][current.y] == 'O') {
//            result = current.moveCount
//            break
//        }
//        for (i in Direction.values()) {
//            val next = moveCoord(current, i)
//            if (board[next.x][next.y] != '#' && next != current) {
//                queue.offer(next)
//            }
//        }
//    }
//    return result
// }
// fun moveCoord(coordinates: Coordinates, direction: Direction): Coordinates {
//    var x = coordinates.x
//    var y = coordinates.y
//    var moveCount = coordinates.moveCount
//    var flag = false
//    var goal = false
//    when (direction) {
//        Direction.LEFT -> {
//            while (board[x][y - 1] != '#' && !goal) {
//                flag = true
//                y--
//                if (board[x][y] == 'O') {
//                    goal = true
//                }
//            }
//        }
//        Direction.DOWN -> {
//            while (board[x + 1][y] != '#' && !goal) {
//                flag = true
//                x++
//                if (board[x][y] == 'O') {
//                    goal = true
//                }
//            }
//        }
//        Direction.RIGHT -> {
//            while (board[x][y + 1] != '#' && !goal) {
//                flag = true
//                y++
//                if (board[x][y] == 'O') {
//                    goal = true
//                }
//            }
//        }
//        Direction.UP -> {
//            while (board[x - 1][y] != '#' && !goal) {
//                flag = true
//                x--
//                if (board[x][y] == 'O') {
//                    goal = true
//                }
//            }
//        }
//    }
//    if (flag) {
//        moveCount++
//    }
//
//    return coordinates.copy(x = x, y = y, moveCount = moveCount)
// }

// enum class Direction {
//    LEFT, UP, RIGHT, DOWN
// }
// enum class Type {
//    Red, Blue
// }
// data class Coordinates(
//    val x: Int,
//    val y: Int,
//    val type: Type,
//    val moveCount: Int
// )
/*
직사각형 보드에 빨간 구슬과 파란 구슬을 나씩 넣은 다음, 빨간 구슬을 구명을 통해 빼내는 게임

보드의 크게는 N * M , 가장 바깥행과 열은 막혀잇다. 보드에는 하나의 구멍만 있다.
목표 빨간 구슬을 구명을 통해 빼내는 것.

구슬을 손으로 건들수 없고, 중력을 굴려야한다. 상하좌우로 굴릴수 있음
각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공, 파란 구슬이 구멍에 빠지면 실패.
빨간 구술과 파란 구술이 동시에 구명에 빠져도 실패. 동시에 같은 칸에 있을 수 없다.
기울이는 동작을 그만하는 것은 더이상 구슬이 움직이지 않을때까지.

보드의 상태가 주어졌을때, 최소 몇 번만에 빨간구슬을 구멍을 통해 빼낼 수 있는구해

 */
