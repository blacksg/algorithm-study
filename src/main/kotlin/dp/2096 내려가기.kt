package dp

import java.io.*
import java.util.*
import kotlin.math.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val matrix = Array(n) {
        val tokenizer = StringTokenizer(reader.readLine())
        IntArray(3) { tokenizer.nextToken().toInt() }
    }

    val maxDp = Array(n) { row -> matrix[row].copyOf() }
    val minDp = Array(n) { row -> matrix[row].copyOf() }
    for (row in n - 2 downTo 0) {
        // 0열
        maxDp[row][0] += max(maxDp[row + 1][0], maxDp[row + 1][1])
        minDp[row][0] += min(minDp[row + 1][0], minDp[row + 1][1])
        // 1열
        maxDp[row][1] += maxDp[row + 1].max()
        minDp[row][1] += minDp[row + 1].min()
        // 2열
        maxDp[row][2] += max(maxDp[row + 1][1], maxDp[row + 1][2])
        minDp[row][2] += min(minDp[row + 1][1], minDp[row + 1][2])
    }

    writer.write("${maxDp[0].max()} ${minDp[0].min()}")
    reader.close()
    writer.close()
}