package algorithm.dp;

import java.io.*;
import java.util.*;

import static java.lang.Math.min;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1149">RGB거리</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] costTable = new int[n][3];
        for (int house = 0; house < n; house++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int color = 0; color < 3; color++) {
                costTable[house][color] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // dp[h][c] = h번째 집을 c색으로 칠할 때까지 드는 비용의 최솟값
        //          = (h-1)번째 집을 다른 색으로 칠할 때까지 드는 비용의 최솟값 + h번째 집을 c색으로 칠할 때 드는 비용
        //          = min(dp[h-1][c'], dp[h-1][c'']) + cost[h][c]
        int[][] accTable = new int[n][3];
        accTable[0] = Arrays.copyOf(costTable[0], 3);
        for (int house = 1; house < n; house++) {
            for (int color = 0; color < 3; color++) {
                int minAcc = min(accTable[house - 1][(color + 1) % 3], accTable[house - 1][(color + 2) % 3]);
                accTable[house][color] = costTable[house][color] + minAcc;
            }
        }

        int minimalTotalCost = min(accTable[n - 1][0], min(accTable[n - 1][1], accTable[n - 1][2]));
        writer.write(minimalTotalCost + "\n");
        reader.close();
        writer.close();
    }
}
