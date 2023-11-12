package stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2493">탑</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 스택
 */
class BOJ2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        // 탑 인스턴스를 저장하는 스택
        Stack<Tower> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int currentOrder = 1; currentOrder <= n; currentOrder++) {
            int currentHeight = Integer.parseInt(tokenizer.nextToken());
            // 현재 탑보다 높은 탑을 만날 때까지 스택을 탐색
            int previousOrder = 0;
            while (!stack.isEmpty()) {
                Tower previousTower = stack.peek();
                if (previousTower.getHeight() > currentHeight) {
                    previousOrder = previousTower.getOrder();
                    break;
                } else {
                    stack.pop();
                }
            }
            // 현재 탑보다 높은 탑의 순서를
            builder.append(previousOrder);
            if (currentOrder < n) {
                builder.append(" ");
            }
            stack.push(new Tower(currentOrder, currentHeight));
        }
        writer.write(builder.append("\n").toString());
        reader.close();
        writer.flush();
        writer.close();
    }

    static final class Tower {

        private final int order;

        private final int height;

        public Tower(int order, int height) {
            this.order = order;
            this.height = height;
        }

        public int getOrder() {
            return order;
        }

        public int getHeight() {
            return height;
        }
    }
}
