package algorithm.recursion;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/6603">로또</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 재귀
 */
class BOJ6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        String line;
        while (!(line = reader.readLine()).equals("0")) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int n = Integer.parseInt(tokenizer.nextToken());
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) {
                candidates[i] = Integer.parseInt(tokenizer.nextToken());
            }
            search(candidates, 0, 6, new int[6], builder);
            builder.append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static void search(
        int[] numbers,
        int currentIndex,
        int remainingSteps,
        int[] combination,
        StringBuilder builder
    ) {
        if (remainingSteps == 0) {
            for (int number : combination) {
                builder.append(number).append(" ");
            }
            builder.append("\n");
        } else {
            for (int index = currentIndex; index <= numbers.length - remainingSteps; index++) {
                combination[6 - remainingSteps] = numbers[index];
                search(numbers, index + 1, remainingSteps - 1, combination, builder);
            }
        }
    }
}
