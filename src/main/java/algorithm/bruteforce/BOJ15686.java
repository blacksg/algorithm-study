package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/15686">치킨 배달</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 구현, 브루트포스
 */
class BOJ15686 {
    
    private static int m;
    
    private static List<int[]> houses;
    
    private static List<int[]> restaurants;
    
    private static boolean[] selected;
    
    private static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        m = Integer.parseInt(numbers[1]);
        houses = new ArrayList<>();
        restaurants = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int cell = Integer.parseInt(row[j]);
                if (cell == 1) {
                    houses.add(new int[] { i, j });
                } else if (cell == 2) {
                    restaurants.add(new int[] { i, j });
                }
            }
        }
        
        selected = new boolean[restaurants.size()];
        dfs(0, 0);
        System.out.println(answer);
        reader.close();
    }
    
    private static void dfs(int count, int current) {
        if (count == m) {
            int cityDistance = 0;
            for (int[] house : houses) {
                int minDistance = Integer.MAX_VALUE;
                for (int i = 0; i < restaurants.size(); i++) {
                    if (selected[i]) {
                        minDistance = Math.min(minDistance, distance(house, restaurants.get(i)));
                    }
                }
                cityDistance += minDistance;
            }
            answer = Math.min(answer, cityDistance);
            return;
        }

        for (int i = current; i <= selected.length - m + count; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(count + 1, i + 1);
                selected[i] = false;
            }
        }
    }
    
    private static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
