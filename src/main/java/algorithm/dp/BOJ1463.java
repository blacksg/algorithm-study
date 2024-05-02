package algorithm.dp;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1463">1로 만들기</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // dp(i) = i를 1로 만들기 위한 최소 연산 횟수
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        writer.write(Integer.toString(dp[n]));
        reader.close();
        writer.close();
    }
}
