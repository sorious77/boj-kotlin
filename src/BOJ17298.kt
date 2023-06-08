import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val N = reader.readLine().toInt()

    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val answer = Array(N) { -1 }

    val stack = Stack<Pair<Int, Int>>()
    for (i in 0 until N) {
        val number = numbers[i]

        while (stack.isNotEmpty()) {
            if (stack.peek().first < number) {
                val top = stack.pop()

                answer[top.second] = number
            } else break
        }

        stack.push(Pair(number, i))
    }

    val stringBuilder = StringBuilder()
    answer.forEach { stringBuilder.append("$it ") }

    print(stringBuilder)
}