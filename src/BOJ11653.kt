import java.lang.StringBuilder

fun main() {
    var number = readln().toInt()

    val answer = StringBuilder()

    var denominator = 2
    while(number > 1) {
        if(number % denominator == 0) {
            while(number % denominator == 0) {
                answer.append("$denominator\n")
                number /= denominator
            }
        }

        denominator += 1
    }

    println(answer)
}