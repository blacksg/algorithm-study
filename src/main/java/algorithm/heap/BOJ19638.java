package algorithm.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/19638">센티와 마법의 뿅망치</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 구현, 자료구조, 우선순위 큐
 */
class BOJ19638 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int giantCount = Integer.parseInt(firstLine[0]);
        int centiHeight = Integer.parseInt(firstLine[1]);
        int hammerLimit = Integer.parseInt(firstLine[2]);
        
        PriorityQueue<Integer> giantHeightQueue = new PriorityQueue<>(giantCount, Comparator.reverseOrder());
        for (int i = 0; i < giantCount; i++) {
            giantHeightQueue.offer(Integer.parseInt(reader.readLine()));
        }
        
        int hammerCount = 0;
        while (!giantHeightQueue.isEmpty()) {
            int tallest = giantHeightQueue.poll();
            if (tallest >= centiHeight) {
                if (hammerCount < hammerLimit) {
                    giantHeightQueue.offer((tallest == 1) ? 1 : (tallest / 2));
                    hammerCount++;
                } else {
                    System.out.println("NO");
                    System.out.println(tallest);
                    break;
                }
            } else {
                System.out.println("YES");
                System.out.println(hammerCount);
                break;
            }
        }
        
        reader.close();
    }
}
