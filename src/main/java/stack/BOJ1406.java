package stack;

import java.io.*;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1406">에디터</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 스택
 */
class BOJ1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] characters = reader.readLine().toCharArray();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (char character : characters) {
            leftStack.push(character);
        }

        int commandCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < commandCount; i++) {
            String command = reader.readLine();
            switch (command) {
                case "L":
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                default:
                    leftStack.push(command.charAt(2));
                    break;
            }
        }

        StringBuilder builder = new StringBuilder();
        
        while (!leftStack.isEmpty()) {
            builder.append(leftStack.pop());
        }
        
        builder.reverse();
        
        while (!rightStack.isEmpty()) {
            builder.append(rightStack.pop());
        }
        
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
