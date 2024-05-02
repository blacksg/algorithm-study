package algorithm.greedy;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1213">팰린드롬 만들기</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘
 */
class BOJ1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        char[] characters = reader.readLine().toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < characters.length; i++) {
            counts[characters[i] - 'A']++;
        }

        int oddCharacterCount = 0;
        for (int count : counts) {
            if (count % 2 == 1) {
                oddCharacterCount++;
            }
        }

        if (oddCharacterCount <= 1) {
            for (int i = 0; i < 26; i++) {
                int count = counts[i];
                char character = (char) (i + 'A');
                for (int j = 0; j < count / 2; j++) {
                    builder.append(character);
                }
            }
            StringBuilder rightHalfBuilder = new StringBuilder(builder).reverse();
            if (oddCharacterCount == 1) {
                for (int i = 0; i < 26; i++) {
                    if (counts[i] % 2 == 1) {
                        builder.append((char) (i + 'A'));
                    }
                }
            }
            builder.append(rightHalfBuilder);
        } else {
            builder.append("I'm Sorry Hansoo");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
