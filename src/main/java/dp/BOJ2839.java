package dp;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2839">설탕 배달</a>
 * @사이트 백준
 * @난이도 SILVER IV
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = -1;
        dp[3] = 1;
        if (n > 3) {
            dp[4] = -1;
        }

        // dp[i] = i 킬로그램을 만들 수 있는 최소 봉지 수
        for (int weight = 5; weight <= n; weight++) {
            if (dp[weight - 3] == -1) {
                if (dp[weight - 5] == -1) {
                    dp[weight] = -1;
                } else {
                    dp[weight] = dp[weight - 5] + 1;
                }
            } else {
                if (dp[weight - 5] == -1) {
                    dp[weight] = dp[weight - 3] + 1;
                } else {
                    dp[weight] = Math.min(dp[weight - 5], dp[weight - 3]) + 1;
                }
            }
        }

        writer.write(Integer.toString(dp[n]));
        reader.close();
        writer.close();
    }

    public void anotherSolution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int answer = 0;
        while (n >= 3) {
            n -= n % 5 == 0 ? 5 : 3;
            answer++;
        }

        writer.write(Integer.toString(n == 0 ? answer : -1));
        reader.close();
        writer.close();
    }
}
