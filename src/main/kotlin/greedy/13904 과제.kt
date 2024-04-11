package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val homeworks = Array(n) { _ ->
        val line = reader.readLine().split(" ")
        Homework(line[0].toInt(), line[1].toInt())
    }
    var answer = 0
    println(answer)
    reader.close()
}

class Homework(val remainingDays: Int, val point: Int)