package greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    
    // 시작 시각 기준 오름차순으로 정렬된 강의 리스트
    val lectures = Array(n) { _ ->
        val line = reader.readLine().split(" ")
        Lecture(line[0].toInt(), line[1].toInt())
    }.sortedBy { l -> l.start }
    
    // 강의 종료 시각에 대한 최소 힙
    val heap = PriorityQueue<Int>()
    heap.offer(lectures[0].end)
    
    // 가장 빨리 끝나는 강의에 이어 다음 강의 시작
    for (i in 1..<n) {
        if (heap.isNotEmpty() && heap.peek() <= lectures[i].start) {
            heap.poll()
        }
        heap.offer(lectures[i].end)
    }
    
    println(heap.size)
    reader.close()
}

class Lecture(val start: Int, val end: Int)