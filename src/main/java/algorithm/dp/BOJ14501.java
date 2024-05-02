package algorithm.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/14501">퇴사</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 다이나믹 프로그래밍, 브루트 포스
 */
class BOJ14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] periods = new int[n];
        int[] pays = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            periods[i] = Integer.parseInt(tokenizer.nextToken());
            pays[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // dp[i] = i번째 날부터 퇴사일 전까지 얻을 수 있는 최대 수입
        int[] dp = new int[n];
        if (periods[n - 1] == 1) {
            dp[n - 1] = pays[n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            int endDate = i + periods[i] - 1;
            // i번째 날 상담이 퇴사일 이전에 끝나는 경우 다음 중 큰 쪽이 최대 수입이 된다.
            // 상담을 하는 경우 상담 비용 + 상담이 끝난 다음날부터 얻을 수 있는 최대 수입
            // 상담을 하지 않는 경우 (i+1)번째 날부터 얻을 수 있는 최대 수입
            if (endDate < n) {
                int afterwardIncome = endDate + 1 < n ? dp[endDate + 1] : 0;
                dp[i] = Math.max(pays[i] + afterwardIncome, dp[i + 1]);
            }
            // i번째 날 상담이 퇴사일 이후에 끝나는 경우 상담을 할 수 없다.
            // 따라서 (i+1)번째 날부터 얻을 수 있는 최대 수입을 그대로 따르게 된다.
            else {
                dp[i] = dp[i + 1];
            }
        }

        writer.write(Integer.toString(dp[0]));
        reader.close();
        writer.close();
    }
}
