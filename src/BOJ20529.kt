import java.io.BufferedReader
import java.io.InputStreamReader

val reader = BufferedReader(InputStreamReader(System.`in`))

fun getDiffMbti(a: String, b: String): Int {
    var count = 0;

    for (i in 0..3) {
        if (a[i] != b[i]) count++
    }

    return count
}

fun getPsychologicalDistance(): Int {
    val numberOfStudent = reader.readLine().toInt()

    val mbtiOfStudent = reader.readLine().split(" ")

    val mbtiCountMap = mutableMapOf<String, Int>()

    var answer = Int.MAX_VALUE

    for (mbti in mbtiOfStudent) {
        val count = mbtiCountMap.getOrDefault(mbti, 0) + 1

        mbtiCountMap[mbti] = count

        if (count >= 3) {
            return 0
        }
    }

    val mbtiCountDescList = mbtiCountMap.toList()
    mbtiCountDescList.sortedByDescending { it.second }

    for (i in mbtiCountDescList.indices) {
        if (mbtiCountDescList[i].second == 2) {
            for (j in mbtiCountDescList.indices) {
                if (i != j) {
                    answer =
                        answer.coerceAtMost(2 * getDiffMbti(mbtiCountDescList[i].first, mbtiCountDescList[j].first))
                }
            }
        } else {
            for (j in i + 1 until mbtiCountDescList.size) {
                for (k in j + 1 until mbtiCountDescList.size) {
                    answer = answer.coerceAtMost(
                        getDiffMbti(mbtiCountDescList[i].first, mbtiCountDescList[j].first)
                                + getDiffMbti(mbtiCountDescList[j].first, mbtiCountDescList[k].first)
                                + getDiffMbti(mbtiCountDescList[i].first, mbtiCountDescList[k].first)
                    )
                }
            }
        }
    }

    return answer
}

fun main() {
    val testCase = reader.readLine().toInt()

    for (i in 1..testCase) {
        println(getPsychologicalDistance())
    }
}