import java.util.LinkedList

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    val moves = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

    var maps: Array<String> = arrayOf()
    for (i in 0 until N) {
        maps += readln()
    }

    val queue = LinkedList<Triple<Int, Int, Int>>()
    queue.offer(Triple(0, 0, 1))

    val isVisit: Array<BooleanArray> = Array(N) { BooleanArray(M) { false } }
    isVisit[0][0] = true

    var answer = 0
    while (!queue.isEmpty()) {
        val (x, y, count) = queue.poll()

        if (x == M - 1 && y == N - 1) {
            answer = count
            break
        }

        for (move in moves) {
            val (nx, ny) = Pair(x + move.first, y + move.second)

            if ((nx in 0 until M) && (ny in 0 until N) && (maps[ny][nx] == '1') && !isVisit[ny][nx]) {
                isVisit[ny][nx] = true

                queue.offer(Triple(nx, ny, count + 1))
            }
        }
    }

    println(answer)
}