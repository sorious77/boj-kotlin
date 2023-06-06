import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val numberOfPeople = reader.readLine().toInt()

    if (numberOfPeople == 0) {
        println(0)
        return
    }

    val counts = IntArray(31)
    var sumOfOpinion = 0
    for (i in 0 until numberOfPeople) {
        val opinion = reader.readLine().toInt()

        counts[opinion]++
        sumOfOpinion += opinion
    }

    val exceptionNumberOfPeople = (numberOfPeople * 0.15).roundToInt()

    var downLeft = exceptionNumberOfPeople
    var upLeft = exceptionNumberOfPeople

    for (i in 1..30) {
        while (counts[i] > 0 && downLeft > 0) {
            downLeft--
            counts[i]--
            sumOfOpinion -= i
        }
    }

    for (i in 30 downTo 1) {
        while (counts[i] > 0 && upLeft > 0) {
            upLeft--
            counts[i]--
            sumOfOpinion -= i
        }
    }

    val answer = (sumOfOpinion.toDouble() / (numberOfPeople - 2 * exceptionNumberOfPeople)).roundToInt()
    println(answer)
}