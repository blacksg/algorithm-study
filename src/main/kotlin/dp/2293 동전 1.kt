package dp

import java.io.*
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val tokenizer = StringTokenizer(reader.readLine())
    val n = tokenizer.nextToken().toInt()
    val k = tokenizer.nextToken().toInt()

    val coins = IntArray(n + 1) { i -> if (i == 0) 0 else reader.readLine().toInt() }
    val dp = IntArray(k + 1) { i -> if (i == 0) 1 else 0 }

    for (i in 1..n) {
        for (j in coins[i]..k) {
            dp[j] += dp[j - coins[i]]
        }
    }

    writer.write(dp[k].toString())
    reader.close()
    writer.close()
}