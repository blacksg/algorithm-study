package algorithm.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1912">연속합</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] seq = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // dp(i) = 0 ~ i번째 항 중 연속된 항을 선택하고 합한 값 중 최댓값
        int answer = seq[0];
        for (int i = 1; i < n; i++) {
            seq[i] = Math.max(seq[i], seq[i - 1] + seq[i]);
            answer = Math.max(seq[i], answer);
        }

        writer.write(Integer.toString(answer));
        reader.close();
        writer.close();
    }
}
