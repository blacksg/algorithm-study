package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2212">센서</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 그리디, 정렬
 */
class BOJ2212 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sensorCount = Integer.parseInt(reader.readLine());
        int centerCount = Integer.parseInt(reader.readLine());
        
        int answer = 0;
        
        if (sensorCount > centerCount) {
            PriorityQueue<Integer> sensorQueue = new PriorityQueue<>(sensorCount);
            String[] line = reader.readLine().split(" ");
            for (int i = 0; i < sensorCount; i++) {
                sensorQueue.offer(Integer.parseInt(line[i]));
            }
            
            PriorityQueue<Integer> distanceQueue = new PriorityQueue<>(sensorCount - 1);
            for (int i = 0; i < sensorCount - 1; i++) {
                int first = sensorQueue.poll();
                int second = sensorQueue.peek();
                distanceQueue.offer(second - first);
            }
            
            for (int i = 0; i < sensorCount - centerCount; i++) {
                answer += distanceQueue.poll();
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
    
    private void solution2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        
        int answer = 0;
        
        if (n > k) {
            String[] line = reader.readLine().split(" ");
            int[] sensors = new int[n];
            for (int i = 0; i < n; i++) {
                sensors[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(sensors);
            
            int[] distances = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                distances[i] = sensors[i + 1] - sensors[i];
            }
            Arrays.sort(distances);
            
            for (int i = 0; i < n - k; i++) {
                answer += distances[i];
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
}
