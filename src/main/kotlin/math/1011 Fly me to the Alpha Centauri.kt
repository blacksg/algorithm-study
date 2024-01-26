package math

import java.io.*
import kotlin.math.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val testCaseCount = reader.readLine().toInt()

    for (i in 0 until testCaseCount) {
        val distance = reader.readLine()
            .split(" ")
            .map { it.toDouble() }
            .run { this[1] - this[0] }
        val floor = floor(sqrt(distance)).toLong()
        val ceil = ceil(sqrt(distance)).toLong()
        var count = 2 * floor - 1
        if (floor < ceil) {
            val m = (floor * floor + ceil * ceil) / 2
            count += if (distance <= m) 1 else 2
        }
        writer.write(count.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}