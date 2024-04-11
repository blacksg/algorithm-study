package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/13904">과제</a>
 * @사이트 백준
 * @난이도 GOLD III
 * @알고리즘 자료구조, 그리디, 정렬, 우선순위 큐
 */
class BOJ13904 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        int[][] homeworks = new int[n][2];
        boolean[] inserted = new boolean[n];
        int lastDay = 0;
        for (int i = 0; i < n; i++) {
            String[] inputLine = reader.readLine().split(" ");
            int remainingDays = Integer.parseInt(inputLine[0]);
            int points = Integer.parseInt(inputLine[1]);
            homeworks[i] = new int[] { remainingDays, points };
            lastDay = Math.max(lastDay, remainingDays);
        }
        
        // 점수 기준 내림차순 + 남은 기간 기준 내림차순 정렬
        Comparator<int[]> comparator = (a, b) -> (b[1] == a[1]) ? (b[0] - a[0]) : (b[1] - a[1]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(n, comparator);
        int answer = 0;
        
        for (int today = lastDay; today > 0; today--) {
            // 마감일이 오늘 이후인 모든 과제를 힙에 삽입
            for (int i = 0; i < n; i++) {
                if (!inserted[i] && homeworks[i][0] >= today) {
                    heap.offer(homeworks[i]);
                    inserted[i] = true;
                }
            }
            // 오늘 할 수 있는 가장 점수가 높은 과제의 점수를 합산
            if (!heap.isEmpty()) {
                answer += heap.poll()[1];
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
}
