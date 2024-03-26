package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/17140">이차원 배열과 연산</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 구현, 정렬, 시뮬레이션
 */
class BOJ17140 {
    
    private static final int[][] arr = new int[100][100];
    
    private static int columnCount = 3;
    
    private static int rowCount = 3;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int targetRow = Integer.parseInt(firstLine[0]) - 1;
        int targetColumn = Integer.parseInt(firstLine[1]) - 1;
        int targetValue = Integer.parseInt(firstLine[2]);
        // 이차원 배열 초기화
        for (int i = 0; i < 3; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        // 최대 100초까지 연산 (원하는 위치에 원하는 숫자가 들어오면 100초 이내 탈출)
        int time = 0;
        while (time <= 100) {
            if (arr[targetRow][targetColumn] == targetValue) break;
            if (rowCount >= columnCount) sortRows();
            else sortColumns();
            time++;
        }
        // 100초를 초과했으면 -1 출력
        System.out.println((time > 100) ? -1 : time);
        reader.close();
    }
    
    private static void sortRows() {
        int maxColumn = 0;
        // 모든 행에 대해서 반복
        for (int[] row : arr) {
            // 각 숫자의 등장 횟수를 HashMap에 저장
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int column = 0; column < columnCount; column++) {
                if (row[column] != 0) {
                    int frequency = frequencyMap.getOrDefault(row[column], 0);
                    frequencyMap.put(row[column], frequency + 1);
                }
            }
            // PriorityQueue를 사용하여 숫자 정렬
            Queue<Number> priorityQueue = new PriorityQueue<>();
            frequencyMap.forEach((value, frequency) -> priorityQueue.offer(new Number(value, frequency)));
            int column = 0;
            while (!priorityQueue.isEmpty() && column < 100) {
                Number number = priorityQueue.poll();
                row[column++] = number.value;
                row[column++] = number.frequency;
            }
            // 열의 개수의 최댓값 갱신
            maxColumn = Math.max(maxColumn, column);
            // 빈 부분 0으로 변경
            while (column < columnCount) {
                row[column++] = 0;
            }
        }
        // 열의 개수 갱신
        columnCount = maxColumn;
    }
    
    private static void sortColumns() {
        int maxRow = 0;
        for (int column = 0; column < columnCount; column++) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int row = 0; row < rowCount; row++) {
                if (arr[row][column] != 0) {
                    int frequency = frequencyMap.getOrDefault(arr[row][column], 0);
                    frequencyMap.put(arr[row][column], frequency + 1);
                }
            }
            Queue<Number> priorityQueue = new PriorityQueue<>();
            frequencyMap.forEach((value, frequency) -> priorityQueue.offer(new Number(value, frequency)));
            int row = 0;
            while (!priorityQueue.isEmpty() && row < 100) {
                Number number = priorityQueue.poll();
                arr[row++][column] = number.value;
                arr[row++][column] = number.frequency;
            }
            maxRow = Math.max(maxRow, row);
            while (row < rowCount) {
                arr[row++][column] = 0;
            }
        }
        rowCount = maxRow;
    }
    
    private static class Number implements Comparable<Number> {
        
        private final int value;
        
        private final int frequency;
        
        public Number(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
        
        @Override
        public int compareTo(Number another) {
            if (this.frequency == another.frequency) {
                return this.value - another.value;
            }
            return this.frequency - another.frequency;
        }
    }
}
