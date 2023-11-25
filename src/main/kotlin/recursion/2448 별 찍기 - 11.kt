package recursion

import java.io.*
import java.util.Arrays

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val height = reader.readLine().toInt()
    val width = 2 * height - 1
    val matrix = Array(height) { CharArray(width) { ' ' } }

    fun drawStars(height: Int, topRow: Int, midCol: Int) {
        if (height == 3) {
            matrix[topRow][midCol] = '*'
            matrix[topRow + 1][midCol - 1] = '*'
            matrix[topRow + 1][midCol + 1] = '*'
            Arrays.fill(matrix[topRow + 2], midCol - 2, midCol + 3, '*')
        } else {
            drawStars(height / 2, topRow, midCol);
            drawStars(height / 2, topRow + height / 2, midCol - height / 2)
            drawStars(height / 2, topRow + height / 2, midCol + height / 2)
        }
    }

    drawStars(height, 0, width / 2)

    for (row in matrix) {
        writer.write(row)
        writer.newLine()
    }

    reader.close()
    writer.close()
}