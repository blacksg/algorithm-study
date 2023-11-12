package dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2293">동전 1</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }

        // dp[i] = 동전을 조합하여 i원을 만들 수 있는 경우의 수
        int[] dp = new int[k + 1];
        dp[0] = 1;

        // 조합할 수 있는 동전의 종류를 늘려가면서 경우의 수를 축적한다.
        for (int i = 1; i <= n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }

        writer.write(Integer.toString(dp[k]));
        reader.close();
        writer.close();
    }
}
