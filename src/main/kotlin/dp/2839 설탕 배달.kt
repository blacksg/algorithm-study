package dp.kotlin.dp

import java.io.*
import kotlin.math.min

fun main() {
    solution1()
//    solution2()
}

private fun solution1() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var n = reader.readLine().toInt()
    var answer = 0
    while (n >= 3) {
        n -= if (n % 5 == 0) 5 else 3
        answer++
    }

    writer.write((if (n == 0) answer else -1).toString())
    reader.close()
    writer.close()
}

private fun solution2() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val dp = IntArray(n + 1) { index ->
        when (index) {
            1, 2, 4 -> -1
            3 -> 1
            else -> 0
        }
    }

    for (weight in 5..n) {
        if (dp[weight - 3] == -1) {
            dp[weight] = if (dp[weight - 5] == -1) -1 else dp[weight - 5] + 1
        } else {
            dp[weight] = if (dp[weight - 5] == -1) dp[weight - 3] + 1 else min(dp[weight - 5], dp[weight - 3]) + 1
        }
    }

    writer.write(dp[n].toString())
    reader.close()
    writer.close()
}