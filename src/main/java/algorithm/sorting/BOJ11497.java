package algorithm.sorting;

import java.io.*;
import java.util.Arrays;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/11497">통나무 건너뛰기</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 정렬, 그리디
 */
class BOJ11497 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < testCaseCount; i++) {
            int logCount = Integer.parseInt(reader.readLine());
            String[] strings = reader.readLine().split(" ");
            int[] logs = new int[logCount];
            for (int j = 0; j < logCount; j++) {
                logs[j] = Integer.parseInt(strings[j]);
            }
            // 통나무의 높이를 오름차순 정렬
            Arrays.sort(logs);
            // 1번째와 2번째, 1번째와 3번째 연결
            int answer = Math.max(logs[1] - logs[0], logs[2] - logs[0]);
            // 마지막과 그 이전 통나무 연결
            answer = Math.max(answer, logs[logCount - 1] - logs[logCount - 2]);
            // 중간의 통나무들은 2개 간격으로 연결
            for (int j = 1; j < logCount - 2; j++) {
                answer = Math.max(answer, logs[j + 2] - logs[j]);
            }
            builder.append(answer).append('\n');
        }
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
