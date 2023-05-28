fun main() {
    val input = readLine()

    println(input!!.split(" ").sumOf { it.toInt() })
}