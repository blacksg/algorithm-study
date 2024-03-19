package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2470">두 용액</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 정렬, 이분탐색, 투 포인터
 */
class BOJ2470 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        String[] line = reader.readLine().split(" ");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(Integer.parseInt(line[i]));
        }
        
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = priorityQueue.poll();
        }
        
        int left = 0, right = n - 1;
        int first = 0, second = 0;
        int minAbs = Integer.MAX_VALUE;
        
        while (left < right) {
            int mixed = values[left] + values[right];
            int abs = Math.abs(mixed);
            if (abs < minAbs) {
                minAbs = abs;
                first = values[left];
                second = values[right];
                if (mixed == 0) break;
            }
            if (mixed < 0) left++;
            else right--;
        }
        
        System.out.println(first + " " + second);
        reader.close();
    }
}
