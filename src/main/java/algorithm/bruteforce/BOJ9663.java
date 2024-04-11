package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/9663">N-Queen</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 브루트포스, 백트래킹
 */
class BOJ9663 {
    
    private static int n;
    
    // 인덱스: 열, 요소: 퀸이 놓여 있는 행
    private static int[] placedRows;
    
    private static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        placedRows = new int[n];
        dfs(0);
        System.out.println(answer);
        reader.close();
    }
    
    private static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        rowLoop:
        for (int row = 0; row < n; row++) {
            // 현재 위치에 퀸을 놓으면 이전에 놓은 퀸이 공격할 수 있는지 확인
            for (int col = 0; col < depth; col++) {
                if (placedRows[col] == row || Math.abs(col - depth) == Math.abs(placedRows[col] - row)) {
                    continue rowLoop;
                }
            }
            // 현재 위치에 퀸을 놓고 다음 단계로 진행
            placedRows[depth] = row;
            dfs(depth + 1);
        }
    }
    
    private boolean[] visitedCol;
    
    private boolean[] visitedDiagLeftToRight;
    
    private boolean[] visitedDiagRightToLeft;
    
    private void solution2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        visitedCol = new boolean[n];
        visitedDiagLeftToRight = new boolean[2 * n - 1];
        visitedDiagRightToLeft = new boolean[2 * n - 1];
        dfs2(0);
        System.out.println(answer);
        reader.close();
    }
    
    private void dfs2(int row) {
        if (row == n) {
            answer++;
        } else {
            for (int col = 0; col < n; col++) {
                if (!visitedCol[col] && !visitedDiagLeftToRight[row - col + n - 1] && !visitedDiagRightToLeft[row + col]) {
                    visitedCol[col] = true;
                    visitedDiagLeftToRight[row - col + n - 1] = true;
                    visitedDiagRightToLeft[row + col] = true;
                    dfs2(row + 1);
                    visitedCol[col] = false;
                    visitedDiagLeftToRight[row - col + n - 1] = false;
                    visitedDiagRightToLeft[row + col] = false;
                }
            }
        }
    }
}
