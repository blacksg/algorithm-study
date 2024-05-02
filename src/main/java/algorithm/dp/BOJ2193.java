package algorithm.dp;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2193">이친수</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        long[][] dp = new long[n + 1][2];
        dp[1][1] = 1;

        // dp[i][1] = i자리 이친수의 개수
        // dp[1][0] = 0, dp[1][1] = 1
        for (int digit = 2; digit <= n; digit++) {
            dp[digit][0] = dp[digit-1][0] + dp[digit-1][1];
            dp[digit][1] = dp[digit-1][0];
        }

        writer.write(Long.toString(dp[n][0] + dp[n][1]));
        reader.close();
        writer.close();
    }
}
