package algorithm.dp;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2156">포도주 시식</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(reader.readLine());
        }

        // i번째 단계에서 (i는 3 이상)
        // (i-2)번째를 선택한다면 (i-1)번째는 선택할 수 없음 -> dp(i) = w(i) + dp(i-2)
        // (i-1)번째를 선택한다면 (i-2)번째는 선택할 수 없음 -> dp(i) = w(i) + w(i-1) + dp(i-3)
        int[] dp = new int[n + 1];
        dp[1] = wines[1];
        if (n > 1) {
            dp[2] = wines[1] + wines[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(wines[i] + dp[i - 2], wines[i - 1] + wines[i] + dp[i - 3]));
        }

        writer.write(Integer.toString(dp[n]));
        reader.close();
        writer.close();
    }
}
