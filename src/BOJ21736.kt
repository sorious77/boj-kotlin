import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

var N = 0
var M = 0
var board = mutableListOf<String>()
var start = Pair(-1, -1)

fun canMove(next: Pair<Int, Int>, isVisited: Array<BooleanArray>): Boolean {
    return (next.first in 0 until M)
            && (next.second in 0 until N)
            && (!isVisited[next.second][next.first])
}

fun traversal(): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(start)

    val isVisited = Array(N) { BooleanArray(M) }
    isVisited[start.second][start.first] = true

    val moves = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

    var countOfPeople = 0

    while (!queue.isEmpty()) {
        val cur = queue.poll()

        for (move in moves) {
            val next = Pair(cur.first + move.first, cur.second + move.second)

            if (!canMove(next, isVisited)) continue

            when (board[next.second][next.first]) {
                'O' -> {
                    queue.offer(next)
                    isVisited[next.second][next.first] = true
                }

                'P' -> {
                    queue.offer(next)
                    countOfPeople++
                    isVisited[next.second][next.first] = true
                }
            }
        }
    }

    return countOfPeople
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val size = reader.readLine().split(" ").map { it.toInt() }

    N = size[0]
    M = size[1]

    for (i in 0 until N) {
        board.add(reader.readLine())

        for (j in 0 until M) {
            if (board[i][j] == 'I') start = Pair(j, i)
        }
    }

    val countOfPeople = traversal()

    println(if (countOfPeople == 0) "TT" else countOfPeople)
}