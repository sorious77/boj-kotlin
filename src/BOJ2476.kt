fun getPrice(dices: List<Int>): Int {
    val (a, b, c) = dices.sortedDescending()

    if(a == c)
        return 10000 + a * 1000
    else if(a == b || b == c)
        return 1000 + b * 100

    return a * 100
}

fun main() {
    val N = readln().toInt()

    var answer = 0
    for(i in 0 until N) {
        val dices = readln().split(" ").map { it.toInt() }

        answer = answer.coerceAtLeast(getPrice(dices))
    }

    println(answer)
}