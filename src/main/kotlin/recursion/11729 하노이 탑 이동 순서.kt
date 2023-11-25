package recursion

import java.io.*

private val builder = StringBuilder()

private var moveCount = 0;

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    moveDisks(n, 1, 2, 3)

    builder.insert(0, '\n').insert(0, moveCount)
    writer.write(builder.toString())
    reader.close()
    writer.close()
}

private fun moveDisks(diskCount: Int, start: Int, temp: Int, destination: Int) {
    if (diskCount == 1) {
        builder.append(start).append(' ').append(destination).append('\n')
    } else {
        moveDisks(diskCount - 1, start, destination, temp)
        builder.append(start).append(' ').append(destination).append('\n')
        moveDisks(diskCount - 1, temp, start, destination)
    }
    moveCount++
}