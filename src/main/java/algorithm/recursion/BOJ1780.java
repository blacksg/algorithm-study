package algorithm.recursion;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1780">종이의 개수</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘
 */
class BOJ1780 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][size];
        for (int[] row : matrix) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < size; i++) {
                row[i] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[] result = cutMatrix(matrix, size, 0, 0, new int[3]);
        for (int paperCount : result) {
            builder.append(paperCount).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static int[] cutMatrix(int[][] matrix, int size, int startRow, int startColumn, int[] result) {
        if (size == 1 || isUsable(matrix, size, startRow, startColumn)) {
            int paperType = matrix[startRow][startColumn];
            result[paperType + 1]++;
        } else {
            int trisection = size / 3;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    cutMatrix(matrix, trisection, startRow + trisection * i, startColumn + trisection * j, result);
                }
            }
        }
        return result;
    }

    private static boolean isUsable(int[][] matrix, int size, int startRow, int startColumn) {
        int paperType = matrix[startRow][startColumn];
        for (int row = startRow; row < startRow + size; row++) {
            for (int column = startColumn; column < startColumn + size; column++) {
                if (matrix[row][column] != paperType) {
                    return false;
                }
            }
        }
        return true;
    }
}
