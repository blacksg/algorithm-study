package stack;

import java.io.*;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1874">스택 수열</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 스택
 */
class BOJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int current = 1;
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int term = Integer.parseInt(reader.readLine());
            // 현재 항까지 push
            while (current <= term) {
                stack.push(current++);
                builder.append('+').append('\n');
            }
            // 스택의 top과 현재 항이 같으면 pop, 그렇지 않으면 반복문 탈출
            if (stack.peek() == term) {
                stack.pop();
                builder.append('-').append('\n');
            } else {
                builder.delete(0, builder.length());
                builder.append("NO");
                break;
            }
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
