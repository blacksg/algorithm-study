package dp;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1932">정수 삼각형</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 다이나믹 프로그래밍
 */
class BOJ1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] triangle = new int[n][];
        for (int depth = 0; depth < n; depth++) {
            triangle[depth] = new int[depth + 1];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i <= depth; i++) {
                triangle[depth][i] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // acc[d][i] = d번째 층의 i번재 숫자를 선택했을 때 합의 최댓값
        //           = max(acc[d-1][i-1], acc[d-1][i]) + triangle[d][i]
        for (int depth = 1; depth < n; depth++) {
            triangle[depth][0] += triangle[depth - 1][0];
            triangle[depth][depth] += triangle[depth - 1][depth - 1];
            for (int i = 1; i < depth; i++) {
                triangle[depth][i] += max(triangle[depth - 1][i - 1], triangle[depth - 1][i]);
            }
        }

        int answer = triangle[n - 1][0];
        for (int i = 1; i < n; i++) {
            answer = max(answer, triangle[n - 1][i]);
        }

        writer.write(answer);
        reader.close();
        writer.close();
    }
}
