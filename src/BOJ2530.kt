fun main() {
    val (A, B, C) = readLine()!!.split(" ").map { it.toInt() }

    val D = readLine()!!.toInt()

    val time = (A * 60 + B) * 60 + C + D

    val hour = (time / (60 * 60)) % 24
    val minute = (time % (60 * 60)) / 60
    val second = time % 60

    println("$hour $minute $second")
}