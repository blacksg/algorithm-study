package dp.kotlin.dp

import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val dp = Array(n + 1) { i -> if (i == 1) longArrayOf(0, 1) else LongArray(2) }
    for (digit in 2..n) {
        dp[digit][0] = dp[digit - 1][0] + dp[digit - 1][0]
        dp[digit][1] = dp[digit - 1][0]
    }

    writer.write(dp[n].sum().toString())
    reader.close()
    writer.close()
}