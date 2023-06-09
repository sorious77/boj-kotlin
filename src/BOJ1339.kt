import java.util.PriorityQueue

fun getNumber(word: String, numberMap: Map<Char, Int>): Int {
    var number = 0

    var padding = 1
    for (i in word.length - 1 downTo 0) {
        number += numberMap.getValue(word[i]) * padding

        padding *= 10
    }

    return number
}

fun main() {
    val N = readln().toInt()

    val words = mutableListOf<String>()
    var maxLength = 0
    for (i in 0 until N) {
        words.add(readln())
        maxLength = Math.max(maxLength, words[i].length)
    }

    var priorityMap = mutableMapOf<Char, Int>()
    for (word in words) {
        var count = 1
        for (i in (word.length - 1) downTo 0) {
            val curPriority = priorityMap.getOrDefault(word[i], 0)

            priorityMap[word[i]] = curPriority + count

            count *= 10
        }
    }

    val numberMap = mutableMapOf<Char, Int>()
    var number = 9
    val sorted = priorityMap.toList().sortedByDescending { it.second }
    for (i in sorted) {
        numberMap[i.first] = number
        number--
    }

    var answer = 0
    for (word in words) {
        answer += getNumber(word, numberMap)
    }

    println(answer)
}