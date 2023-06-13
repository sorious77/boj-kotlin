fun calcCoin() : Int {
    val N = readln().toInt()

    val coins = readln().split(" ").map { it.toInt() }

    val M = readln().toInt()

    val dp = Array(10001) { 0 }

    for (coin in coins) {
        dp[coin] += 1
        for (i in coin..M) {
            dp[i] += dp[i - coin]
        }
    }

    return dp[M]
}

fun main() {
    val testCase = readln().toInt()

    val stringBuilder = StringBuilder()
    for (i in 0 until testCase) {
        stringBuilder.append("${calcCoin()}\n")
    }

    println(stringBuilder)
}