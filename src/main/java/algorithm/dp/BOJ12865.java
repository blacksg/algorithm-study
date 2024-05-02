package algorithm.dp;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/12865">평범한 배낭</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ12865 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] info = reader.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] itemInfo = reader.readLine().split(" ");
            weights[i] = Integer.parseInt(itemInfo[0]);
            values[i] = Integer.parseInt(itemInfo[1]);
        }
        
        // dp[i][w] = 1 ~ i번째 물건을 조합했을 때 무게 한도가 w인 배낭에 대한 최대 가치합
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int limit = 1; limit <= k; limit++) {
                // 현재 물건의 무게가 배낭의 무게 한도를 초과하면, 해당 물건을 담을 수 없으므로 이전 단계의 가치합을 그대로 사용
                // 그렇지 않으면, 해당 물건을 담지 않을 경우 / 담을 경우의 가치합 중 큰 값을 사용
                dp[i][limit] = (weights[i] > limit)
                               ? dp[i - 1][limit]
                               : Math.max(dp[i - 1][limit], dp[i - 1][limit - weights[i]] + values[i]);
            }
        }
        
        System.out.println(dp[n][k]);
        reader.close();
    }
}
