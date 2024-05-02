package algorithm.recursion;

import java.io.*;
import java.util.Arrays;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2448">별 찍기 - 11</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 재귀
 */
class BOJ2448 {

    private static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int height = Integer.parseInt(reader.readLine());
        int width = 2 * height - 1;
        initializeMatrix(height, width);
        drawStars(height, 0, width / 2);

        for (char[] row : matrix) {
            writer.write(row);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void initializeMatrix(int height, int width) {
        matrix = new char[height][width];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }
    }

    private static void drawStars(int height, int topRow, int midCol) {
        if (height == 3) {
            matrix[topRow][midCol] = '*';
            matrix[topRow + 1][midCol - 1] = '*';
            matrix[topRow + 1][midCol + 1] = '*';
            Arrays.fill(matrix[topRow + 2], midCol - 2, midCol + 3, '*');
        } else {
            drawStars(height / 2, topRow, midCol);
            drawStars(height / 2, topRow + height / 2, midCol - height / 2);
            drawStars(height / 2, topRow + height / 2, midCol + height / 2);
        }
    }
}
