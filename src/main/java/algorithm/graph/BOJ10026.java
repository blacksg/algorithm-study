package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/10026">적록색약</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 그래프, BFS, DFS
 */
class BOJ10026 {
    
    private static int n;
    
    private static char[][] grid;
    
    private static boolean[][] visited;
    
    private static int[][] diffs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = reader.readLine().toCharArray();
        }
        
        int normalAreaCount = 0;
        int colorBlindAreaCount = 0;
        
        // 일반인 시점 구역 수 카운트
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (!visited[row][column]) {
                    bfs(row, column, grid[row][column]);
                    normalAreaCount++;
                }
                // 이후 색약인 시점으로 탐색하기 위해 적색 및 녹색 구역 통일
                if (grid[row][column] == 'G') {
                    grid[row][column] = 'R';
                }
            }
        }
        
        // 각 칸의 방문기록 초기화
        visited = new boolean[n][n];
        
        // 색약인 시점 구역 수 카운트
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (!visited[row][column]) {
                    bfs(row, column, grid[row][column]);
                    colorBlindAreaCount++;
                }
            }
        }
        
        System.out.println(normalAreaCount + " " + colorBlindAreaCount);
        reader.close();
    }
    
    private static void bfs(int row, int column, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { row, column });
        visited[row][column] = true;
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int[] diff : diffs) {
                int nextRow = position[0] + diff[0], nextColumn = position[1] + diff[1];
                if (isUnvisitedCell(nextRow, nextColumn, color)) {
                    queue.offer(new int[] { nextRow, nextColumn });
                    visited[nextRow][nextColumn] = true;
                }
            }
        }
    }
    
    private static boolean isUnvisitedCell(int row, int column, char color) {
        return (0 <= row && row < n)
               && (0 <= column && column < n)
               && !visited[row][column]
               && (grid[row][column] == color);
    }
}
