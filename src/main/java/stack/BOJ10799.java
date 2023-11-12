package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/10799">쇠막대기</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 스택
 */
class BOJ10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] arrangement = reader.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int sticks = 0;
        for (int i = 0; i < arrangement.length; i++) {
            if (arrangement[i] == '(') {
                stack.push(arrangement[i]);
            } else {
                stack.pop();
                sticks += (arrangement[i - 1] == '(') ? stack.size() : 1;
            }
        }
        System.out.println(sticks);
        reader.close();
    }
}
