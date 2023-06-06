import java.io.BufferedReader
import java.io.InputStreamReader

var board: Array<IntArray> = arrayOf(intArrayOf())
var countOfBlue = 0
var countOfWhite = 0

fun count(start: Pair<Int, Int>, end: Pair<Int, Int>) {
    if (start == end) {
        if (board[start.second][start.first] == 1) countOfBlue++ else countOfWhite++
        return
    }

    val firstColor = board[start.second][start.first]
    var flag = false

    for (y in start.second until end.second) {
        if (flag) break
        for (x in start.first until end.first) {
            if (firstColor != board[y][x]) {
                flag = true
                break
            }
        }
    }

    if (flag) {
        val nextSize = (end.first - start.first) / 2

        count(start, Pair(end.first - nextSize, end.second - nextSize))
        count(Pair(start.first + nextSize, start.second), Pair(end.first, end.second - nextSize))
        count(Pair(start.first, start.second + nextSize), Pair(end.first - nextSize, end.second))
        count(Pair(start.first + nextSize, start.second + nextSize), end)
    } else {
        if (board[start.second][start.first] == 1) countOfBlue++ else countOfWhite++
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val length = reader.readLine().toInt()

    for (i in 0 until length) {
        val input = reader.readLine().split(" ").map { it.toInt() }

        board += input.toIntArray()
    }

    board = board.slice(1..length).toTypedArray()

    count(Pair(0, 0), Pair(length, length))

    println("$countOfWhite\n$countOfBlue")
}