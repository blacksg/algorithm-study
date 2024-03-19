package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/17503">맥주 축제</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 자료구조, 그리디, 정렬, 이분탐색, 우선순위 큐
 */
class BOJ17503 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);
        
        PriorityQueue<Beer> beers = new PriorityQueue<>(k, (b1, b2) -> (b1.alc == b2.alc) ? (b2.pref - b1.pref) : (b1.alc - b2.alc));
        for (int i = 0; i < k; i++) {
            String[] line = reader.readLine().split(" ");
            beers.offer(new Beer(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        
        PriorityQueue<Integer> prefQueue = new PriorityQueue<>();
        int prefSum = 0;
        int answer = -1;
        while (!beers.isEmpty()) {
            Beer current = beers.poll();
            prefQueue.offer(current.pref);
            prefSum += current.pref;
            if (prefQueue.size() > n) {
                prefSum -= prefQueue.poll();
            }
            if (prefQueue.size() == n && prefSum >= m) {
                answer = current.alc;
                break;
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
    
    private static class Beer {
        
        int pref;
        
        int alc;
        
        Beer(int pref, int alc) {
            this.pref = pref;
            this.alc = alc;
        }
    }
}
