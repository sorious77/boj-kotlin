import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (availableStudents, queueingLength) = reader.readLine().split(" ").map { it.toInt() }

    val ordersMap = mutableMapOf<String, Int>()
    for (i in 0 until queueingLength) {
        ordersMap[reader.readLine()] = i
    }

    val orders = ordersMap.toList().sortedBy { it.second }

    val stringBuilder = StringBuilder()
    for (i in 0 until availableStudents) {
        if (i >= orders.size) break

        stringBuilder.append("${orders[i].first}\n")
    }

    println(stringBuilder)
}