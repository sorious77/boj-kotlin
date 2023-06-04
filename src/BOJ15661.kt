import kotlin.math.abs

var numberOfPeople = 0
var teams = arrayOf(intArrayOf())
var count = 0
var isChecked = booleanArrayOf()
var answer = Int.MAX_VALUE

fun calculateAbility() {
    var link = 0
    var start = 0

    for (i in 0 until numberOfPeople) {
        for (j in 0 until numberOfPeople) {
            if (isChecked[i] == isChecked[j]) {
                if (isChecked[i]) link += teams[i][j] else start += teams[i][j]
            }
        }
    }

    answer = answer.coerceAtMost(abs(link - start))
}

fun solve(start: Int) {
    calculateAbility()

    for (i in start until numberOfPeople) {
        count += 1
        isChecked[i] = true
        solve(i + 1)
        isChecked[i] = false
        count -= 1
    }
}

fun main() {
    numberOfPeople = readln().toInt()

    for (i in 0 until numberOfPeople) {
        teams += (readln().split(" ").map { it.toInt() }).toIntArray()
    }
    teams = teams.sliceArray(1..numberOfPeople)

    isChecked = BooleanArray(numberOfPeople + 1)
    solve(0)

    println(answer)
}