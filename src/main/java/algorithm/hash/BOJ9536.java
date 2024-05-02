package algorithm.hash;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/9536">여우는 어떻게 울지?</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 해시
 */
class BOJ9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            String[] sounds = reader.readLine().split(" ");
            Set<String> others = new HashSet<>();
            while (true) {
                String sentence = reader.readLine();
                if (sentence.equals("what does the fox say?")) {
                    break;
                }
                others.add(sentence.split(" goes ")[1]);
            }
            for (String sound : sounds) {
                if (!others.contains(sound)) {
                    writer.write(sound);
                    writer.write(" ");
                }
            }
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
