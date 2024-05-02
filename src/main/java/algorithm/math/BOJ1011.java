package algorithm.math;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1011">Fly me to the Alpha Centauri</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 수학
 */
class BOJ1011 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            String[] positions = reader.readLine().split(" ");
            long distance = Long.parseLong(positions[1]) - Long.parseLong(positions[0]);
            long floor = (long) Math.floor(Math.sqrt(distance));
            long ceil = (long) Math.ceil(Math.sqrt(distance));
            long count = 2 * floor - 1;
            if (floor < ceil) {
                count += distance <= (floor * floor + ceil * ceil) / 2 ? 1 : 2;
            }
            writer.write(Long.toString(count));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
