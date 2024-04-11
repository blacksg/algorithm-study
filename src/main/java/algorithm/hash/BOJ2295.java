package algorithm.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2295">세 수의 합</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 자료구조, 이분탐색, 해시
 */
class BOJ2295 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            heap.offer(Integer.parseInt(reader.readLine()));
        }
        
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = heap.poll();
        }
        
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumSet.add(elements[i] + elements[j]);
            }
        }
        
        outer:
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sumSet.contains(elements[i] - elements[j])) {
                    System.out.println(elements[i]);
                    break outer;
                }
            }
        }
        
        reader.close();
    }
}
