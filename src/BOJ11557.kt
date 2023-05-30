fun getMostAlcoholicSchool() {
    val numberOfSchool = readln().toInt()

    var (mostAlcoholicSchool, maxAlcohol) = Pair("", 0)
    for (i in 0 until numberOfSchool) {
        val (school, alcohol) = readln().split(" ")

        if (alcohol.toInt() > maxAlcohol) {
            mostAlcoholicSchool = school
            maxAlcohol = alcohol.toInt()
        }
    }

    println(mostAlcoholicSchool)
}

fun main() {
    val testCase = readln().toInt()

    for (i in 0 until testCase) {
        getMostAlcoholicSchool()
    }
}