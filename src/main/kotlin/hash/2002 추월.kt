package hash

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    
    val enteredOrderMap = hashMapOf<String, Int>()
    for (enteredOrder in 0 until n) {
        enteredOrderMap[reader.readLine()] = enteredOrder
    }
    
    val exitedCarNumbers = Array<String>(n) { reader.readLine() }
    var answer = 0
    
    for (i in 0 until n - 1) {
        val currentCarEnteredOrder = enteredOrderMap[exitedCarNumbers[i]]!!
        for (j in i + 1 until n) {
            if (enteredOrderMap[exitedCarNumbers[j]]!! < currentCarEnteredOrder) {
                answer++
                break
            }
        }
    }
    
    println(answer)
    reader.close()
}