package hash

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    
    val heap = PriorityQueue<Int>(n)
    for (i in 0 until n) {
        heap.offer(reader.readLine().toInt())
    }
    
    val elements = IntArray(n)
    for (i in 0 until n) {
        elements[i] = heap.poll()
    }
    
    val sumSet = HashSet<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            sumSet.add(elements[i] + elements[j])
        }
    }
    
    outer@ for (i in n - 1 downTo 1) {
        for (j in 0 until i) {
            if (sumSet.contains(elements[i] - elements[j])) {
                println(elements[i])
                break@outer
            }
        }
    }
    
    reader.close()
}