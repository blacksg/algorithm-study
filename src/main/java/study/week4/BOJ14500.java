package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/14500">테트로미노</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 구현, 브루트포스
 */
class BOJ14500 {
    
    private static final int[][] diffs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    
    private static int height;
    
    private static int width;
    
    private static int[][] grid;
    
    private static boolean[][] visited;
    
    private static int maxSum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);
        grid = new int[height][width];
        visited = new boolean[height][width];
        for (int row = 0; row < height; row++) {
            String[] line = reader.readLine().split(" ");
            for (int column = 0; column < width; column++) {
                grid[row][column] = Integer.parseInt(line[column]);
            }
        }
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                visited[row][column] = true;
                dfs(1, row, column, grid[row][column]);
                visited[row][column] = false;
            }
        }
        System.out.println(maxSum);
        reader.close();
    }
    
    private static void dfs(int cellCount, int row, int column, int sum) {
        if (cellCount == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int[] diff : diffs) {
            int nextRow = row + diff[0];
            int nextColumn = column + diff[1];
            if (0 <= nextRow && nextRow < height && 0 <= nextColumn && nextColumn < width && !visited[nextRow][nextColumn]) {
                if (cellCount == 2) {
                    visited[nextRow][nextColumn] = true;
                    dfs(cellCount + 1, row, column, sum + grid[nextRow][nextColumn]);
                    visited[nextRow][nextColumn] = false;
                }
                visited[nextRow][nextColumn] = true;
                dfs(cellCount + 1, nextRow, nextColumn, sum + grid[nextRow][nextColumn]);
                visited[nextRow][nextColumn] = false;
            }
        }
    }
    
    private static void search(int row, int column) {
        if (visitable(row - 1, column) && visitable(row + 1, column)) {
            int sum = grid[row][column] + grid[row - 1][column] + grid[row + 1][column];
            if (visitable(row, column - 1)) maxSum = Math.max(maxSum, sum + grid[row][column - 1]);
            if (visitable(row, column + 1)) maxSum = Math.max(maxSum, sum + grid[row][column + 1]);
        }
        if (visitable(row, column - 1) && visitable(row, column + 1)) {
            int sum = grid[row][column] + grid[row][column - 1] + grid[row][column + 1];
            if (visitable(row - 1, column)) maxSum = Math.max(maxSum, sum + grid[row - 1][column]);
            if (visitable(row + 1, column)) maxSum = Math.max(maxSum, sum + grid[row + 1][column]);
        }
    }
    
    private static boolean visitable(int row, int column) {
        return (0 <= row && row < height) && (0 <= column && column < width) && !visited[row][column];
    }
}
