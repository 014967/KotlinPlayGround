import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(var x: Int, var y: Int)
private var student = ArrayList<Node>()
var n = 0
lateinit var map: Array<CharArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    map = Array(n) { CharArray(n) }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            map[i][j] = st.nextToken()[0]
            if (map[i][j] == 'S') {
                student.add(Node(i, j))
            }
        }
    }
    dfs(0)
    println("NO")
}

fun dfs(wall: Int) {
    if (wall == 3) {
        bfs()
        return
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 'X') {
                map[i][j] = 'O'
                dfs(wall + 1)
                map[i][j] = 'X'
            }
        }
    }
}

private fun bfs() {
    val q: Queue<Node> = LinkedList()
    val copyMap = Array(n) { CharArray(n) }
    val check = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            copyMap[i][j] = map[i][j]
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (copyMap[i][j] == 'T') {
                q.add(Node(i, j))
                check[i][j] = true
            }
        }
    }
    while (!q.isEmpty()) {
        val now = q.poll()
        val x = now.x
        val y = now.y
        for (k in 0..3) {
            var nx = x + dx[k]
            var ny = y + dy[k]
            while (nx in 0 until n && 0 <= ny && ny < n) {
                if (copyMap[nx][ny] != 'O') {
                    check[nx][ny] = true
                    nx += dx[k]
                    ny += dy[k]
                } else {
                    break
                }
            }
        }
    }
    if (catchStudent(check)) {
        println("YES")
        System.exit(0)
    }
}

private fun catchStudent(check: Array<BooleanArray>): Boolean {
    for (node in student) {
        if (check[node.x][node.y] == true) {
            return false
        }
    }
    return true
}
