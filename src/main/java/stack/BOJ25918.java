package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/25918">북극곰은 괄호를 찢어</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 스택
 */
class BOJ25918 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        int length = Integer.parseInt(reader.readLine());
        int answer = 0;

        if (length % 2 != 0) {
            //
            answer = -1;
        } else {
            char[] characters = reader.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < characters.length; i++) {
                char current = characters[i];
                if (stack.isEmpty() || stack.peek().equals(current)) {
                    stack.push(current);
                } else {
                    stack.pop();
                }
                answer = Math.max(answer, stack.size());
            }
            if (!stack.isEmpty()) {
                answer = -1;
            }
        }
        System.out.println(answer);
        reader.close();
    }
}
