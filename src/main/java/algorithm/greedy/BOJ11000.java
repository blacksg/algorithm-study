package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/11000">강의실 배정</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 자료구조, 그리디, 정렬, 우선순위 큐
 */
class BOJ11000 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        // 강의 배열 (시작 시각, 종료 시각 기준 오름차순 정렬)
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            String[] inputLine = reader.readLine().split(" ");
            lectures[i] = new Lecture(Integer.parseInt(inputLine[0]), Integer.parseInt(inputLine[1]));
        }
        Arrays.sort(lectures, (l1, l2) -> (l1.start - l2.start));
        
        // 종료 시각에 대한 최소 힙
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);
        heap.offer(lectures[0].end);
        
        // 가장 빨리 끝나는 강의에 이어서 다음 강의 시작
        // 강의 시간이 겹치면 다른 강의실에 배정
        for (int i = 1; i < n; i++) {
            if (!heap.isEmpty() && heap.peek() <= lectures[i].start) {
                heap.poll();
            }
            heap.offer(lectures[i].end);
        }
        
        System.out.println(heap.size());
        reader.close();
    }
    
    private static class Lecture {
        
        int start;
        
        int end;
        
        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
