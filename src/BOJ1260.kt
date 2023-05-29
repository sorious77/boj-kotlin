import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val (N, M, V) = readln().split(" ").map { it.toInt() }

    val board = Array(N + 1) { BooleanArray(N + 1) }

    for (i in 0 until M) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        board[x][y] = true
        board[y][x] = true
    }

    dfs(N, V, board)
    bfs(N, V, board)
}

fun dfs(N: Int, V: Int, board: Array<BooleanArray>) {
    val stack = Stack<Int>()
    stack.push(V)

    val isVisit = BooleanArray(N + 1)
    isVisit[V] = true

    val result = StringBuilder()
    result.append("$V ")

    while (!stack.isEmpty()) {
        val top = stack.peek()

        var allVisited = true
        for (i in 1 until (N + 1)) {
            if (board[top][i] && !isVisit[i]) {
                stack.push(i)
                isVisit[i] = true
                allVisited = false
                result.append("$i ")
                break
            }
        }

        if(allVisited) stack.pop()
    }
    result.setLength(result.length - 1)

    println(result)
}

fun bfs(N: Int, V: Int, board: Array<BooleanArray>) {
    val queue: Queue<Int> = LinkedList()
    queue.offer(V)

    val isVisit = BooleanArray(N + 1)
    isVisit[V] = true

    val result = StringBuilder()
    while (!queue.isEmpty()) {
        val head = queue.poll()
        result.append("$head ")

        for (i in 1 until (N + 1)) {
            if (board[head][i] && !isVisit[i]) {
                queue.offer(i)
                isVisit[i] = true
            }
        }
    }
    result.setLength(result.length - 1)

    println(result)
}