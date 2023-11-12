package dp

import java.io.*
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val costTable = Array(n) { IntArray(3) }
    for (house in 0..<n) {
        val tokenizer = StringTokenizer(reader.readLine())
        for (color in 0..2) {
            costTable[house][color] = tokenizer.nextToken().toInt()
        }
    }

    val dp = costTable.copyOf()
    for (house in 1..<n) {
        for (color in 0..2) {
            val previousMinCost = min(dp[house - 1][(color + 1) % 3], dp[house - 1][(color + 2) % 3])
            dp[house][color] += previousMinCost
        }
    }

    writer.write(dp[n - 1].min().toString())
    reader.close()
    writer.close()
}