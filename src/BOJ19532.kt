fun main() {
    val numbers = readln().split(" ").map { it.toInt() }

    val (a, b, c) = numbers.slice(0..2)
    val (d, e, f) = numbers.slice(3..5)

    val x = (c * e - b * f) / (a * e - b * d)
    val y = (c * d - a * f) / (b * d - a * e)

    println("$x $y")
}