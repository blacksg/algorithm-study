package recursion;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/11729">하노이 탑 이동 순서</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 재귀
 */
class BOJ11729 {

    private static final StringBuilder builder = new StringBuilder();

    private static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        moveDisks(n, 1, 2, 3);

        builder.insert(0, '\n').insert(0, moveCount);
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static void moveDisks(int diskCount, int start, int temp, int destination) {
        if (diskCount == 1) {
            builder.append(start).append(' ').append(destination).append('\n');
        } else {
            moveDisks(diskCount - 1, start, destination, temp);
            builder.append(start).append(' ').append(destination).append('\n');
            moveDisks(diskCount - 1, temp, start, destination);
        }
        moveCount++;
    }
}
