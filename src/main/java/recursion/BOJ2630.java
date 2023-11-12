package recursion;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2630">색종이 만들기</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 분할 정복, 재귀
 */
class BOJ2630 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        int entireSize = Integer.parseInt(reader.readLine());
        int[][] entirePaper = new int[entireSize][entireSize];
        for (int[] row : entirePaper) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < entireSize; i++) {
                row[i] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[] result = cutPaper(entirePaper, entireSize, 0, 0, new int[2]);
        for (int paperCount : result) {
            builder.append(paperCount).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static int[] cutPaper(int[][] entirePaper, int cutSize, int startRow, int startColumn, int[] result) {
        if (cutSize == 1 || isSolidColor(entirePaper, cutSize, startRow, startColumn)) {
            int color = entirePaper[startRow][startColumn];
            result[color]++;
        } else {
            int midpoint = cutSize / 2;
            for (int row = startRow; row <= startRow + midpoint; row += midpoint) {
                for (int column = startColumn; column <= startColumn + midpoint; column += midpoint) {
                    cutPaper(entirePaper, midpoint, row, column, result);
                }
            }
        }
        return result;
    }

    private static boolean isSolidColor(int[][] entirePaper, int cutSize, int startRow, int startColumn) {
        int color = entirePaper[startRow][startColumn];
        for (int row = startRow; row < startRow + cutSize; row++) {
            for (int column = startColumn; column < startColumn + cutSize; column++) {
                if (entirePaper[row][column] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
