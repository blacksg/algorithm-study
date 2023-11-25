package recursion

import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val level = reader.readLine().toInt()
    if (level == 1) {
        writer.write("*")
    } else {
        val height = (level - 1) * 4 + 3
        val width = (level - 1) * 4 + 1
        val matrix = Array(height) { CharArray(width) { ' ' } }
        drawStars(level, matrix, 0, width - 1)
        val builder = StringBuilder()
        for (row in 0 until height) {
            if (row == 1) {
                builder.append(matrix[row][0])
            } else {
                for (col in 0 until width) {
                    builder.append(matrix[row][col])
                }
            }
            builder.append("\n")
        }
        writer.write(builder.toString())
    }

    reader.close()
    writer.close()
}

private fun drawStars(level: Int, matrix: Array<CharArray>, topRow: Int, rightCol: Int) {
    if (level == 1) {
        for (i in 0..2) {
            matrix[topRow + i][rightCol] = '*'
        }
    } else {
        val height = (level - 1) * 4 + 3
        val width = (level - 1) * 4 + 1
        // 윗쪽 가로줄
        for (i in 0 until width) {
            matrix[topRow][rightCol - i] = '*'
        }
        // 왼쪽 세로줄
        val leftCol = rightCol - width + 1
        for (i in 1 until height) {
            matrix[topRow + i][leftCol] = '*'
        }
        // 아래쪽 가로줄
        val bottomRow = topRow + height - 1;
        for (i in 0 until width - 1) {
            matrix[bottomRow][rightCol - i] = '*'
        }
        // 오른쪽 세로줄
        for (i in 2 until height - 1) {
            matrix[topRow + i][rightCol] = '*'
        }
        // 재귀 호출
        drawStars(level - 1, matrix, topRow + 2, rightCol - 2)
        // 재귀 호출로 그려지는 부분과 연결되는 위치
        matrix[topRow + 2][rightCol - 1] = '*'
    }
}