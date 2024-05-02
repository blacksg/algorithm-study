package algorithm.recursion;

import java.io.*;
import java.util.Arrays;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/10997">별 찍기 - 22</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 재귀
 */
class BOJ10997 {

    private static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int level = Integer.parseInt(reader.readLine());
        if (level == 1) {
            writer.write("*");
        } else {
            int entireHeight = (level - 1) * 4 + 3;
            int entireWidth = (level - 1) * 4 + 1;
            initializeMatrix(entireHeight, entireWidth);
            drawStars(level, 0, entireWidth - 1);
            writer.write(matrixToString());
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

    private static void drawStars(int level, int topRow, int rightCol) {
        if (level == 1) {
            for (int i = 0; i < 3; i++) {
                matrix[topRow + i][rightCol] = '*';
            }
        } else {
            int height = (level - 1) * 4 + 3;
            int width = (level - 1) * 4 + 1;
            // 위쪽 가로줄
            for (int i = 0; i < width; i++) {
                matrix[topRow][rightCol - i] = '*';
            }
            // 왼쪽 세로줄
            int leftCol = rightCol - width + 1;
            for (int i = 1; i < height; i++) {
                matrix[topRow + i][leftCol] = '*';
            }
            // 아래쪽 가로줄
            int bottomRow = topRow + height - 1;
            for (int i = 0; i < width - 1; i++) {
                matrix[bottomRow][rightCol - i] = '*';
            }
            // 오른쪽 세로줄
            for (int i = 2; i < height - 1; i++) {
                matrix[topRow + i][rightCol] = '*';
            }
            // 안쪽으로 들어가는 별
            matrix[topRow + 2][rightCol - 1] = '*';
            // 재귀 호출
            drawStars(level - 1, topRow + 2, rightCol - 2);
        }
    }

    private static String matrixToString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            if (row == 1) {
                builder.append(matrix[row][0]);
            } else {
                for (int col = 0; col < matrix[row].length; col++) {
                    builder.append(matrix[row][col]);
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
