package dp.kotlin.dp

import java.io.*
import java.util.*
import kotlin.math.max

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val periods = IntArray(n)
    val pays = IntArray(n)
    for (i in 0 until n) {
        val tokenizer = StringTokenizer(reader.readLine())
        periods[i] = tokenizer.nextToken().toInt()
        pays[i] = tokenizer.nextToken().toInt()
    }

    val dp = IntArray(n)
    if (periods[n - 1] == 1) {
        dp[n - 1] = pays[n - 1]
    }
    for (i in n - 2 downTo 0) {
        val endDate = i + periods[i] - 1;
        if (endDate < n) {
            val nextIncome = if (endDate + 1 < n) dp[endDate + 1] else 0
            dp[i] = max(pays[i] + nextIncome, dp[i + 1])
        } else {
            dp[i] = dp[i + 1]
        }
    }

    writer.write(dp[0].toString())
    reader.close()
    writer.close()
}