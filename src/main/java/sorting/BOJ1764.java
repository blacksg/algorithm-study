package sorting;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1764">듣보잡</a>
 * @사이트 백준
 * @난이도 SILVER IV
 * @알고리즘 해시, 정렬
 */
class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        // n: 듣도 못한 사람 수
        // m: 보도 못한 사람 수
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        // 듣도 못한 사람의 명단
        Set<String> neverHeardNames = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            neverHeardNames.add(reader.readLine());
        }

        // 듣도 보도 못한 사람의 명단
        List<String> namesOnBothLists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String neverSeenName = reader.readLine();
            if (neverHeardNames.contains(neverSeenName)) {
                namesOnBothLists.add(neverSeenName);
            }
        }

        // 듣도 보도 못한 사람의 명단을 사전 기준 오름차순 정렬
        Collections.sort(namesOnBothLists);

        builder.append(namesOnBothLists.size()).append("\n");
        for (String name : namesOnBothLists) {
            builder.append(name).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
