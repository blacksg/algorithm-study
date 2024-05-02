package algorithm.recursion;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/16505">별</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 재귀
 */
class BOJ16505 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        int level = Integer.parseInt(reader.readLine());
        char[][] matrix = initializeMatrix(level);
        int midpoint = (int) Math.pow(2, level - 1);
        fillStars(level, matrix, 0, 0);
        fillStars(level, matrix, 0, midpoint);
        fillStars(level, matrix, midpoint, 0);
        appendMatrixToBuilder(matrix, builder);

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static char[][] initializeMatrix(int level) {
        int rowCount = (int) Math.pow(2, level);
        char[][] matrix = new char[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            char[] row = new char[rowCount - i];
            Arrays.fill(row, ' ');
            matrix[i] = row;
        }
        return matrix;
    }

    private static void fillStars(int level, char[][] matrix, int row, int column) {
        if (level == 0) {
            matrix[row][column] = '*';
            return;
        }
        int midpoint = (int) Math.pow(2, level - 2);
        fillStars(level - 1, matrix, row, column);
        fillStars(level - 1, matrix, row, column + midpoint);
        fillStars(level - 1, matrix, row + midpoint, column);
    }

    private static void appendMatrixToBuilder(char[][] matrix, StringBuilder builder) {
        for (char[] row : matrix) {
            for (char entry : row) {
                builder.append(entry);
            }
            builder.append("\n");
        }
    }
}
