package algorithm.graph;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/7576">토마토</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 그래프, BFS
 */
class BOJ7576 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = reader.readLine().split(" ");
        int width = Integer.parseInt(size[0]);
        int height = Integer.parseInt(size[1]);
        
        // 상자
        int[][] box = new int[height][width];
        // 방문해야 하는 칸의 위치를 담는 큐
        Queue<int[]> ripedTomatoPositionQueue = new LinkedList<>();
        // 상자의 칸수 카운트
        int cellCount = 0;
        
        for (int row = 0; row < height; row++) {
            String[] input = reader.readLine().split(" ");
            for (int col = 0; col < width; col++) {
                box[row][col] = Integer.parseInt(input[col]);
                // 익지 않은 토마토가 들어 있는 칸을 제외하고 카운트
                if (box[row][col] != 0) {
                    cellCount++;
                }
                // 익은 토마토가 들어 있는 칸의 위치를 큐에 삽입
                if (box[row][col] == 1) {
                    ripedTomatoPositionQueue.offer(new int[] { row, col });
                }
            }
        }
        
        // 익지 않은 토마토가 없으면 곧바로 0 출력
        if (cellCount == width * height) {
            System.out.println(0);
        } else {
            // 상자 안에 들어 있는 각 토마토가 익기까지 걸리는 일수를 저장하는 이차원 배열
            int[][] dayTable = new int[height][width];
            // 상자 안의 모든 토마토가 익기까지 걸리는 일수 = dayTable 안 요소의 최댓값
            int requiredDays = 0;
            int[][] positionDiff = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            while (!ripedTomatoPositionQueue.isEmpty()) {
                int[] current = ripedTomatoPositionQueue.poll();
                for (int[] diff : positionDiff) {
                    int nextRow = current[0] + diff[0];
                    int nextCol = current[1] + diff[1];
                    // 주변 칸에 들어 있는 토마토가 익지 않은 경우
                    if ((0 <= nextRow && nextRow < height) && (0 <= nextCol && nextCol < width) && box[nextRow][nextCol] == 0) {
                        box[nextRow][nextCol] = 1;
                        ripedTomatoPositionQueue.offer(new int[] { nextRow, nextCol });
                        dayTable[nextRow][nextCol] = dayTable[current[0]][current[1]] + 1;
                        requiredDays = Math.max(requiredDays, dayTable[nextRow][nextCol]);
                        cellCount++;
                    }
                }
            }
            // 익지 않은 토마토가 존재하면 -1 출력
            System.out.println((cellCount == width * height) ? requiredDays : -1);
        }
        
        reader.close();
    }
}
