fun getSixthNumber(): IntArray {
    var sixthNumber = 1
    var additional = 5
    var sixthNumberArray = intArrayOf()

    while (true) {
        if (sixthNumber > 1_000_000) break

        sixthNumberArray += sixthNumber
        sixthNumber += additional
        additional += 4
    }

    return sixthNumberArray
}

fun main() {
    val sixthNumbers = getSixthNumber()

    val N = readln().toInt()

    val dp = Array(N + 1) { Int.MAX_VALUE }

    for (i in 1..N) {
        if (sixthNumbers.contains(i)) {
            dp[i] = 1
            continue
        }

        for (sixthNumber in sixthNumbers) {
            if (sixthNumber > i) break

            dp[i] = minOf(dp[i], dp[i - sixthNumber] + dp[sixthNumber])
        }
    }

    println(dp[N])
}