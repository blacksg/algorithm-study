package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/23559">밥</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 자료구조, 그리디, 정렬, 우선순위 큐
 */
class BOJ23559 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]), x = Integer.parseInt(firstLine[1]);
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n);
        int totalPrice = 1000 * n;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            int valueA = Integer.parseInt(line[0]), valueB = Integer.parseInt(line[1]);
            priorityQueue.offer(valueB - valueA);
            answer += valueB;
        }
        
        while (totalPrice + 4000 <= x && !priorityQueue.isEmpty() && priorityQueue.peek() < 0) {
            answer -= priorityQueue.poll();
            totalPrice += 4000;
        }
        
        System.out.println(answer);
        reader.close();
    }
}
