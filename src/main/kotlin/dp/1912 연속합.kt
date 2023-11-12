package dp.kotlin.dp

import java.io.*
import java.util.*
import kotlin.math.max

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val tokenizer = StringTokenizer(reader.readLine())
    val sequence = IntArray(n) { tokenizer.nextToken().toInt() }

    val dp = IntArray(n) { i -> if (i == 0) sequence[0] else 0 }
    var answer = dp[0]
    for (i in 1 until n) {
        dp[i] = max(sequence[i], dp[i - 1] + sequence[i])
        answer = max(answer, dp[i])
    }

    writer.write(answer.toString())
    reader.close()
    writer.close()
}