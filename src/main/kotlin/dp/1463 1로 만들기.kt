package dp.kotlin.dp

import java.io.*
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val dp = IntArray(n + 1)
    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1)
        }
    }

    writer.write(dp[n].toString())
    reader.close()
    writer.close()
}
