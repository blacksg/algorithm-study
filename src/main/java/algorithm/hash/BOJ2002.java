package algorithm.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2002">추월</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 구현, 자료구조, 문자열, 해시
 */
class BOJ2002 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        // key: 들어온 차량 번호, value: 차량이 들어온 순서
        Map<String, Integer> enteredOrderMap = new HashMap<>(n);
        for (int enteredOrder = 0; enteredOrder < n; enteredOrder++) {
            enteredOrderMap.put(reader.readLine(), enteredOrder);
        }
        
        // index: 차량이 나간 순서, element: 나간 차량 번호
        String[] exitedCarNumbers = new String[n];
        for (int exitedOrder = 0; exitedOrder < n; exitedOrder++) {
            exitedCarNumbers[exitedOrder] = reader.readLine();
        }
        
        int answer = 0;
        
        // 0 ~ (n - 2)번째로 나간 차량 C에 대하여 C보다 일찍 들어왔고 늦게 나간 차량이 존재하면 카운트 증가
        for (int i = 0; i < n - 1; i++) {
            int currentEnteredOrder = enteredOrderMap.get(exitedCarNumbers[i]);
            for (int j = i + 1; j < n; j++) {
                if (enteredOrderMap.get(exitedCarNumbers[j]) < currentEnteredOrder) {
                    answer++;
                    break;
                }
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
}
