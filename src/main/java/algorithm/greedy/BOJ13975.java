package algorithm.greedy;

import java.io.*;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/13975">파일 합치기 3</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 자료구조, 그리디, 우선순위 큐
 */
class BOJ13975 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < testCaseCount; i++) {
            int fileCount = Integer.parseInt(reader.readLine());
            String[] line = reader.readLine().split(" ");
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>(fileCount);
            for (int j = 0; j < fileCount; j++) {
                priorityQueue.offer(Long.parseLong(line[j]));
            }
            
            long totalCost = 0;
            while (priorityQueue.size() > 1) {
                long cost = priorityQueue.poll() + priorityQueue.poll();
                totalCost += cost;
                priorityQueue.offer(cost);
            }
            
            stringBuilder.append(totalCost).append('\n');
        }
        
        writer.write(stringBuilder.toString());
        reader.close();
        writer.close();
    }
}
