package bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val visitedColumn = BooleanArray(n)
    val visitedDiagonal1 = BooleanArray(2 * n - 1)
    val visitedDiagonal2 = BooleanArray(2 * n - 1)
    var answer = 0
    
    fun dfs(row: Int) {
        if (row == n) {
            answer++
            return
        }
        for (col in 0..<n) {
            if (!visitedColumn[col] && !visitedDiagonal1[row - col + n - 1] && !visitedDiagonal2[row + col]) {
                visitedColumn[col] = true
                visitedDiagonal1[row - col + n - 1] = true
                visitedDiagonal2[row + col] = true
                dfs(row + 1)
                visitedColumn[col] = false
                visitedDiagonal1[row - col + n - 1] = false
                visitedDiagonal2[row + col] = false
            }
        }
    }
    
    dfs(0)
    println(answer)
    reader.close()
}