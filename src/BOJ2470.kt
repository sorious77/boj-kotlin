import kotlin.math.abs

fun main() {
    val N = readln().toInt()

    val numbers = readln().split(" ").map { it.toInt() }.sorted()

    var start = 0
    var end = N - 1

    var answer = Triple(Int.MAX_VALUE, 0, 0)

    while (start < end) {
        val sum = numbers[start] + numbers[end]

        if (abs(sum) < abs(answer.first)) {
            answer = Triple(sum, numbers[start], numbers[end])
        }

        if (sum < 0) start++ else end--
    }

    println("${answer.second} ${answer.third}")
}