fun main(args: Array<String>) {
    val (A, B) = readLine()!!.split(" ").map { it.toInt() }

    val C = readLine()!!.toInt()

    val time = A * 60 + B + C

    val hour = time / 60 % 24
    val minute = time % 60

    println("$hour $minute")
}