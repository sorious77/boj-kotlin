val moves = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
var size = Pair(0, 0)
var maps: Array<String> = arrayOf()
var isVisit: Array<IntArray> = arrayOf()
var answer = Int.MAX_VALUE

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    size = Pair(N, M)

    maps = arrayOf()
    for (i in 0 until N) {
        maps += readln()
    }

    isVisit = Array(N) { IntArray(M) { Int.MAX_VALUE } }

    dfs(0, 0, 1)

    println(answer)
}

fun dfs(x: Int, y: Int, count: Int) {
    if (x == size.second - 1 && y == size.first - 1) {
        answer = answer.coerceAtMost(count)

        return
    }

    for (move in moves) {
        val nx: Int = x + move.first
        val ny: Int = y + move.second

        if (!canMove(nx, ny, count + 1)) continue

        isVisit[ny][nx] = count + 1
        dfs(nx, ny, count + 1)
    }
}

fun canMove(x: Int, y: Int, count: Int): Boolean {
    return (x in 0 until size.second) && (y in 0 until size.first) && (count < isVisit[y][x]) && (maps[y][x] == '1')
}