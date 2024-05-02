package algorithm.graph;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/4963">섬의 개수</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 그래프, DFS, BFS
 */
class BOJ4963 {

    private static int width;

    private static int height;

    private static int[][] map;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while (!(line = reader.readLine()).equals("0 0")) {
            String[] mapSizeInfo = line.split(" ");
            width = Integer.parseInt(mapSizeInfo[0]);
            height = Integer.parseInt(mapSizeInfo[1]);
            map = new int[height][width];
            visited = new boolean[height][width];

            for (int row = 0; row < height; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int column = 0; column < width; column++) {
                    map[row][column] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int landCount = 0;
            for (int row = 0; row < height; row++) {
                for (int column = 0; column < width; column++) {
                    if (!visited[row][column] && map[row][column] == 1) {
                        bfs(row, column);
                        landCount++;
                    }
                }
            }

            writer.write(Integer.toString(landCount));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void bfs(int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, column });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            visited[current[0]][current[1]] = true;

            for (int nextRow = current[0] - 1; nextRow <= current[0] + 1; nextRow++) {
                for (int nextColumn = current[1] - 1; nextColumn <= current[1] + 1; nextColumn++) {
                    if (isUnvisitedLand(row, column)) {
                        queue.add(new int[] { nextRow, nextColumn });
                        visited[nextRow][nextColumn] = true;
                    }
                }
            }
        }
    }

    private static boolean isUnvisitedLand(int row, int column) {
        return (0 <= row && row < height)
               && (0 <= column && column < width)
               && map[row][column] == 1
               && !visited[row][column];
    }
}
