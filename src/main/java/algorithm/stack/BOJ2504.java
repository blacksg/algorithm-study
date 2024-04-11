package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2504">괄호의 값</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 구현, 자료구조, 스택
 */
class BOJ2504 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] parenthesis = reader.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int value = 1;
        
        // (() [[]]) ([])
        // 2*(2 + 3*3) + 2*3
        // 2*2 + 2*3*3 + 2*3
        loop:
        for (int i = 0; i < parenthesis.length; i++) {
            char parenthese = parenthesis[i];
            switch (parenthese) {
                case '(':
                    stack.push(parenthese);
                    value *= 2;
                    break;
                case '[':
                    stack.push(parenthese);
                    value *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break loop;
                    } else if (parenthesis[i - 1] == '(') {
                        answer += value;
                    }
                    stack.pop();
                    value /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break loop;
                    } else if (parenthesis[i - 1] == '[') {
                        answer += value;
                    }
                    stack.pop();
                    value /= 3;
                    break;
            }
        }
        
        System.out.println(!stack.isEmpty() ? 0 : answer);
        reader.close();
    }
}
