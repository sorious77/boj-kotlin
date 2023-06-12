fun main() {
    val (N, L) = readln().split(" ").map { it.toInt() }

    val waters = readln().split(" ").map { it.toInt() }.sorted()

    var answer = 0

    val isTaped = Array(1002) { false }

    for (water in waters) {
        if (isTaped[water - 1] && isTaped[water]) continue

        for (i in water - 1 until water + L) {
            if (i >= 1001) break

            isTaped[i] = true
        }
        answer++
    }

    println(answer)
}