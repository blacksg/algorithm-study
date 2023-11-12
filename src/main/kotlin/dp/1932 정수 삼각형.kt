package dp.kotlin.dp

import java.io.*
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val triangle = Array(n) { depth ->
        val tokenizer = StringTokenizer(reader.readLine())
        IntArray(depth + 1) { tokenizer.nextToken().toInt() }
    }

    for (depth in 1 until n) {
        triangle[depth][0] += triangle[depth - 1][0]
        triangle[depth][depth] += triangle[depth - 1][depth - 1]
        for (i in 1 until depth) {
            triangle[depth][i] += max(triangle[depth - 1][i - 1], triangle[depth - 1][i])
        }
    }

    writer.write(triangle[n - 1].max().toString())
    reader.close()
    writer.close()
}