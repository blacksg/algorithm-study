package algorithm.sorting;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2910">빈도 정렬</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 해시, 정렬
 */
class BOJ2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        StringTokenizer infoTokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(infoTokenizer.nextToken());
        int c = Integer.parseInt(infoTokenizer.nextToken());

        StringTokenizer sequenceTokenizer = new StringTokenizer(reader.readLine());

        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int term = Integer.parseInt(sequenceTokenizer.nextToken());
            frequencyMap.put(term, frequencyMap.getOrDefault(term, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey()).append(" ");
            }
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}

