package hash;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/9375">패션왕 신해빈</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 해시
 */
class BOJ9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());
        Map<String, Integer> categories = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            int clothes = Integer.parseInt(reader.readLine());
            for (int j = 0; j < clothes; j++) {
                String categoryName = reader.readLine().split(" ")[1];
                categories.put(categoryName, categories.getOrDefault(categoryName, 0) + 1);
            }
            int combinations = 1;
            for (Map.Entry<String, Integer> category : categories.entrySet()) {
                combinations *= category.getValue() + 1;
            }
            builder.append(combinations - 1).append("\n");
            categories.clear();
        }
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
