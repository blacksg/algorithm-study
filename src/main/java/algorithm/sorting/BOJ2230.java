package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2230">수 고르기</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 정렬, 투 포인터
 */
class BOJ2230 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[] sequence = new int[n];
        
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(reader.readLine());
        }
        
        Arrays.sort(sequence);
        
        int left = 0;
        int right = 1;
        int answer = Integer.MAX_VALUE;
        
        while (left < n && right < n) {
            int diff = sequence[right] - sequence[left];
            if (diff < m) {
                right++;
            } else {
                answer = Math.min(answer, diff);
                left++;
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
}
