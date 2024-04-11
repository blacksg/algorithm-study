package bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val n = numbers[0]
    val m = numbers[1]
    val houses = ArrayList<IntArray>()
    val restaurants = ArrayList<IntArray>()
    var answer = Int.MAX_VALUE
    
    for (i in 0..<n) {
        val cells = reader.readLine().split(" ").map { it.toInt() }
        for (j in 0..<n) {
            when (cells[j]) {
                1 -> houses.add(intArrayOf(i, j))
                2 -> restaurants.add(intArrayOf(i, j))
            }
        }
    }
    
    val selected = BooleanArray(restaurants.size)
    
    fun dfs(count: Int, current: Int) {
        if (count == m) {
            var sum = 0
            for (house in houses) {
                var minimalDistance = Int.MAX_VALUE
                for (i in restaurants.indices) {
                    if (selected[i]) {
                        val distance = abs(house[0] - restaurants[i][0]) + abs(house[1] - restaurants[i][1])
                        minimalDistance = min(minimalDistance, distance)
                    }
                }
                sum += minimalDistance
            }
            answer = min(answer, sum)
        } else {
            for (i in current..(selected.size - m + count)) {
                if (!selected[i]) {
                    selected[i] = true
                    dfs(count + 1, i + 1)
                    selected[i] = false
                }
            }
        }
    }
    
    dfs(0, 0)
    println(answer)
    reader.close()
}