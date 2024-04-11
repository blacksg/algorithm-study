package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1062">가르침</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 브루트포스, 비트마스킹, 백트래킹
 */
class BOJ1062 {
    
    private static int n;
    
    private static int k;
    
    private static int[] words;
    
    private static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        k = Integer.parseInt(strings[1]);
        
        // 모든 글자를 가르칠 수 있으면 모든 단어를 읽을 수 있다.
        if (k == 26) {
            answer = n;
        }
        // 모든 단어는 anta와 tica를 포함하므로 k가 5보다 작으면 아무 단어도 읽을 수 없다.
        else if (k >= 5) {
            words = new int[n];
            for (int i = 0; i < n; i++) {
                char[] chars = reader.readLine().toCharArray();
                for (char letter : chars) {
                    words[i] |= 1 << (letter - 'a');
                }
            }
            dfs(0, 0, 0);
        }
        
        System.out.println(answer);
        reader.close();
    }
    
    private static void dfs(int letterCount, int currentIndex, int selectedLetters) {
        if (letterCount == k) {
            // 선택한 글자로 가르칠 수 있는 단어의 개수를 카운트
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((words[i] & selectedLetters) == words[i]) count++;
            }
            // 글자 조합에 따라 가르칠 수 있는 단어의 개수의 최댓값 갱신
            answer = Math.max(answer, count);
            return;
        }
        for (int i = currentIndex; i < 26; i++) {
            dfs(letterCount + 1, i + 1, selectedLetters | (1 << i));
        }
    }
}
