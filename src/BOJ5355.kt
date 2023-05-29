fun readLine(): String {
    return readln()
}

fun calculate() {
    val input = readLine().split(" ")

    var number = input[0].toDouble()

    for(i in input) {
        when(i) {
            "@" -> number *= 3
            "%" -> number += 5
            "#" -> number -= 7
        }
    }

    println("%.2f".format(number))
}

fun main() {
    val testCase = readLine().toInt()

    for(i in 0 until testCase) {
        calculate()
    }
}