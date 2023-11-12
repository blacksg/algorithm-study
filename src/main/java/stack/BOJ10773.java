package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/10773">제로</a>
 * @사이트 백준
 * @난이도 SILVER IV
 * @알고리즘 스택
 */
class BOJ10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int digits = Integer.parseInt(reader.readLine());
        for (int i = 0; i < digits; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }
        int sum = 0;
        for (int digit : stack) {
            sum += digit;
        }
        System.out.println(sum);
        reader.close();
    }
}
