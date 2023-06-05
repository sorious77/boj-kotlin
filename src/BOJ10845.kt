fun main() {
    var N = readln().toInt()

    val queue = IntArray(10000)
    var front = 0
    var rear = 0

    val stringBuilder = StringBuilder()

    while (N-- > 0) {
        val input = readln().split(" ")

        when (input[0]) {
            "push" -> {
                queue[rear++] = input[1].toInt()
            }

            "pop" -> {
                stringBuilder.append(if (front == rear) "-1\n" else "${queue[front++]}\n")
            }

            "size" -> {
                stringBuilder.append("${rear - front}\n")
            }

            "empty" -> {
                stringBuilder.append(if (rear == front) "1\n" else "0\n")
            }

            "front" -> {
                stringBuilder.append(if (rear == front) "-1\n" else "${queue[front]}\n")
            }

            "back" -> {
                stringBuilder.append(if (rear == front) "-1\n" else "${queue[rear - 1]}\n")
            }
        }
    }

    print(stringBuilder)
}