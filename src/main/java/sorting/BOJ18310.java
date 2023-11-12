package sorting;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/18310">안테나</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 정렬, 그리디
 */
class BOJ18310 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(houses);

        writer.write(Integer.toString(houses[(n - 1) / 2]));
        writer.newLine();
        reader.close();
        writer.close();
    }
}
