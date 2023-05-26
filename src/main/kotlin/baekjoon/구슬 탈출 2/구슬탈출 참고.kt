package baekjoon.`구슬 탈출 2`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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
lateinit var board: Array<Array<Char>>
lateinit var redCoord: Coordinates
lateinit var blueCoord: Coordinates
lateinit var check: Array<Array<Array<Array<Boolean>>>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    board = Array(N) { Array(M) { '#' } }
    check = Array(10) { Array(10) { Array(10) { Array(10) { false } } } }
    // redx ,redy , bluex, bluey

    for (i in 0 until N) {
        val row = readLine()
        for (j in row.indices) {
            if (row[j] == 'R') {
                redCoord = Coordinates(i, j)
            }
            if (row[j] == 'B') {
                blueCoord = Coordinates(i, j)
            }
            board[i][j] = row[j]
        }
    }
    val startMarble = Marble(
        redCoordinate = redCoord,
        blueCoordinate = blueCoord,
        count = 0
    )
    var result = -1
    result = bfs(start = startMarble)
    println(result)
}
fun bfs(start: Marble): Int {
    var result = -1
    val queue = LinkedList<Marble>()
    queue.offer(start)
    while (queue.isNotEmpty()) {
        val currentMarble = queue.poll()
        val currentRed = currentMarble.redCoordinate
        val currentBlue = currentMarble.blueCoordinate
        check[currentRed.x][currentRed.y][currentBlue.x][currentBlue.y] = true
        if (currentMarble.count > 10) {
            break
        }

//        if (board[currentRed.x][currentRed.y] == 'O' &&
//            board[currentBlue.x][currentBlue.y] == 'O'
//        ) {
//            continue
//        }

        if (board[currentRed.x][currentRed.y] == 'O' && board[currentBlue.x][currentBlue.y] != 'O') {
            result = currentMarble.count
            break
        }

        for (i in Direction.values()) {
            var nextRed = moveCoord(currentRed, i)
            var nextBlue = moveCoord(currentBlue, i)
            if (nextRed == nextBlue) {
                if (board[nextRed.x][nextRed.y] != 'O') {
                    val reverse = reverseDirection(i)
                    // 빨강 보다 한칸 뒤로
                    when (i) {
                        Direction.DOWN -> {
                            if (currentRed.x < currentBlue.x) {
                                // 빨강이 더위에 잇엇다면
                                nextRed = nextRed.copy(
                                    x = nextRed.x + reverse.first,
                                    y = nextRed.y + reverse.second
                                )
                            } else {
                                nextBlue = nextBlue.copy(
                                    x = nextBlue.x + reverse.first,
                                    y = nextBlue.y + reverse.second
                                )
                            }
                        }
                        Direction.RIGHT -> {
                            // 빨강이 더 왼쪽에 잇었다면?
                            if (currentRed.y < currentBlue.y) {
                                nextRed = nextRed.copy(
                                    x = nextRed.x + reverse.first,
                                    y = nextRed.y + reverse.second
                                )
                            } else {
                                nextBlue = nextBlue.copy(
                                    x = nextBlue.x + reverse.first,
                                    y = nextBlue.y + reverse.second
                                )
                            }
                        }
                        Direction.LEFT -> {
                            // 빨강이 더 오른쪽에 있엇다면?
                            if (currentRed.y > currentBlue.y) {
                                nextRed = nextRed.copy(
                                    x = nextRed.x + reverse.first,
                                    y = nextRed.y + reverse.second
                                )
                            } else {
                                nextBlue = nextBlue.copy(
                                    x = nextBlue.x + reverse.first,
                                    y = nextBlue.y + reverse.second
                                )
                            }
                        }
                        Direction.UP -> {
                            // 빨강이 더 아래에 있엇다면?
                            if (currentRed.x > currentBlue.x) {
                                nextRed = nextRed.copy(
                                    x = nextRed.x + reverse.first,
                                    y = nextRed.y + reverse.second
                                )
                            } else {
                                nextBlue = nextBlue.copy(
                                    x = nextBlue.x + reverse.first,
                                    y = nextBlue.y + reverse.second
                                )
                            }
                        }
                    }
                }
            }
            if (board[nextBlue.x][nextBlue.y] == 'O') {
                continue
            } else {
                if (!check[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                    queue.offer(
                        Marble(
                            nextRed,
                            nextBlue,
                            currentMarble.count + 1
                        )
                    )
                }
            }
        }
    }

    return result
}

fun reverseDirection(direction: Direction): Pair<Int, Int> {
    return when (direction) {
        Direction.DOWN -> {
            Pair(-1, 0)
        }
        Direction.RIGHT -> {
            Pair(0, -1)
        }
        Direction.LEFT -> {
            Pair(0, 1)
        }
        Direction.UP -> {
            Pair(1, 0)
        }
    }
}
fun moveCoord(coordinates: Coordinates, direction: Direction): Coordinates {
    var x = coordinates.x
    var y = coordinates.y
    var goal = false
    when (direction) {
        Direction.LEFT -> {
            while (board[x][y - 1] != '#' && !goal) {
                y--
                if (board[x][y] == 'O') {
                    goal = true
                }
            }
        }
        Direction.DOWN -> {
            while (board[x + 1][y] != '#' && !goal) {
                x++
                if (board[x][y] == 'O') {
                    goal = true
                }
            }
        }
        Direction.RIGHT -> {
            while (board[x][y + 1] != '#' && !goal) {
                y++
                if (board[x][y] == 'O') {
                    goal = true
                }
            }
        }
        Direction.UP -> {
            while (board[x - 1][y] != '#' && !goal) {
                x--
                if (board[x][y] == 'O') {
                    goal = true
                }
            }
        }
    }

    return coordinates.copy(x = x, y = y)
}

enum class Direction {
    LEFT, UP, RIGHT, DOWN
}

data class Marble(
    val redCoordinate: Coordinates,
    val blueCoordinate: Coordinates,
    val count: Int
)

data class Coordinates(
    val x: Int,
    val y: Int
)
