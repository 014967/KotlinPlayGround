package programmers.미로탈출명령어

import kotlin.math.abs

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

fun main() {
    val solution = Solution()
    Input.InputList.forEach {
        val result = solution.solution(
            it.n,
            it.m,
            it.x,
            it.y,
            it.r,
            it.c,
            it.k
        )
        println(result)
    }
}

class Solution {
    lateinit var table: Array<Array<Int>>
    lateinit var end: Vertex
    var flag = false
    var k = 0
    var answer: String = ""
    var newN = 0
    var newM = 0
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        answer = ""
        flag = false

        newN = n + 1
        newM = m + 1
        this.k = k
        this.end = Vertex(r, c, 0, "")
        dfs(current = Vertex(x, y, 0, ""))

        if(!flag){
            answer ="impossible"
        }
        return answer
    }

    private fun dfs(current: Vertex) {
        if (flag) {
            return
        }

        if (current.x == end.x && current.y == end.y) {
            if (current.moveCount == k) {
                flag = true
                answer = current.moveString
                return
            } else if (k - current.moveCount % 2 == 1) {
                flag = true
                answer = "impossible"
                return
            }
        }

        val distance = abs(end.x - current.x) + abs(end.y - current.y)
        if (distance > k -current.moveCount) {
            return
        }

        for (i in 0 until 4) {
            val nextX = current.x + directions[i].x
            val nextY = current.y + directions[i].y
            val nextMoveCount = current.moveCount + 1
            val nextString = current.moveString + directions[i].str

            if (nextX in 1 until newN && nextY in 1 until newM && nextMoveCount <= k) {

                dfs(Vertex(nextX, nextY, nextMoveCount, nextString))
            }
        }
    }
}

data class Direction(
    val x: Int,
    val y: Int,
    val str: String
)
val directions = listOf(
    Direction(1, 0, "d"),
    Direction(0, -1, "l"),
    Direction(0, 1, "r"),
    Direction(-1, 0, "u")
)

data class Vertex(
    val x: Int,
    val y: Int,
    val moveCount: Int,
    val moveString: String
)
/*
n * m 격자 미로가 주어니느데, (x,y)에서 (r,c) 로 이동해서 탈출해야한다.
미로를 탈출하는 조건이 세가지가 있다.

1. 격자의 바깥으로는 나갈 수 없다
2. (x,y)에서 (r,c)까지 이동하는 거리가 총 k여야한다.
3. (x,y) 와 (r,c)격자를 포함해서, 같은 격자를 두번 이상 방문해도 된다.
4. 미로에서 탈출한 경로를 문자열로 나타냈을때, 문자열이 사전순으로 가장 빠른 경로로 탈출해야한다.

l : 왼쪽 한칸 이동
r : 오른쪽 한칸이동
u : 위쪽 한칸
d : 아래 한칸이동

미로의 크기는 최소 2 * 2 최대 50 * 50
시작 지점과 끝나는 지점은 같지 않고
k는 1~ 2500까지임.

 */

data class Input(
    val n: Int,
    val m: Int,
    val x: Int,
    val y: Int,
    val r: Int,
    val c: Int,
    val k: Int
) {
    companion object {
        val InputList = listOf(
            Input(3, 4, 2, 3, 3, 1, 5),
            Input(2, 2, 1, 1, 2, 2, 2),
            Input(3, 3, 1, 2, 3, 3, 4)
        )
    }
}
