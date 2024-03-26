package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1744">수 묶기</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 그리디, 정렬, 많은 조건 분기
 */
class BOJ1744 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> positiveQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> nonPositiveQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            ((number > 0) ? positiveQueue : nonPositiveQueue).offer(number);
        }
        int answer = 0;
        while (!positiveQueue.isEmpty()) {
            int a = positiveQueue.poll();
            if (a == 1 || positiveQueue.isEmpty() || positiveQueue.peek() == 1) answer += a;
            else answer += a * positiveQueue.poll();
        }
        while (!nonPositiveQueue.isEmpty()) {
            int number = nonPositiveQueue.poll();
            answer += number * (nonPositiveQueue.isEmpty() ? 1 : nonPositiveQueue.poll());
        }
        System.out.println(answer);
        reader.close();
    }
}
