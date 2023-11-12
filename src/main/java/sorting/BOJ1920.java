package sorting;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1920">수 찾기</a>
 * @사이트 백준
 * @난이도 SILVER IV
 * @알고리즘 정렬, 이분 탐색
 */
class BOJ1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        StringTokenizer numberTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberTokenizer.nextToken());
        }

        Arrays.sort(numbers);

        int m = Integer.parseInt(reader.readLine());
        int[] targets = new int[m];
        StringTokenizer targetTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(targetTokenizer.nextToken());
        }

        for (int target : targets) {
            int binarySearchResult = Arrays.binarySearch(numbers, target);
            builder.append(binarySearchResult < 0 ? 0 : 1).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
