package dp.kotlin.dp

import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val wines = IntArray(n + 1) { i -> if (i == 0) 0 else reader.readLine().toInt() }
    val dp = IntArray(n + 1) { i ->
        when (i) {
            1 -> wines[1]
            2 -> wines[1] + wines[2]
            else -> 0
        }
    }

    for (i in 3..n) {
        dp[i] = maxOf(dp[i - 1], wines[i] + dp[i - 2], wines[i - 1] + wines[i] + dp[i - 3])
    }

    writer.write(dp[n].toString())
    reader.close()
    writer.close()
}
