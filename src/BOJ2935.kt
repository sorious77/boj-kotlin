import java.lang.StringBuilder

fun main() {
    var A = readln()
    val op = readln()
    var B = readln()

    A = if(A > B) A else B.also { B = A }

    val logA = kotlin.math.log10(A.toDouble()).toInt()
    val logB = kotlin.math.log10(B.toDouble()).toInt()

    val answer = StringBuilder()

    when(op) {
        "+" -> if(logA == logB) answer.append("2").append("0".repeat(logA))
        else answer.append("1").append("0".repeat(logA - logB - 1)).append("1").append("0".repeat(logB))
        "*" -> answer.append("1").append("0".repeat(logA + logB))
    }

    println(answer)
}