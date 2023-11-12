package sorting;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

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
        StringBuilder builder = new StringBuilder();

        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            int logCount = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            // 통나무들의 높이를 배열에 저장하고 오름차순 정렬한다.
            int[] logs = new int[logCount];
            for (int j = 0; j < logCount; j++) {
                logs[j] = Integer.parseInt(tokenizer.nextToken());
            }
            Arrays.sort(logs);

            // 1번재 통나무는 2번째 및 3번째 통나무와 연결한다.
            int difficulty = max(abs(logs[0] - logs[1]), abs(logs[0] - logs[2]));

            // 2번째부터 (n-2)번째 통나무까지는 두 차례 뒤의 통나무와 연결한다.
            for (int j = 1; j < logCount - 2; j++) {
                difficulty = max(difficulty, abs(logs[j] - logs[j + 2]));
            }

            // (n-1)번째 통나무와 n번째 통나무를 연결한다.
            difficulty = max(difficulty, abs(logs[logCount - 2] - logs[logCount - 1]));

            builder.append(difficulty).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
