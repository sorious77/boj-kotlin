fun main() {
    while (true) {
        val (M, F) = readln().split(" ").map { it.toInt() }

        if (M == 0 && F == 0)
            break

        println(M + F)
    }
}