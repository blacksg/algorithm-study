package stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/17298">오큰수</a>
 * @사이트 백준
 * @난이도 GOLD IV
 * @알고리즘 스택
 */
class BOJ17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수열의 항의 개수
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        // 오큰수를 만나지 못한 항을 저장하는 스택
        Stack<Term> stack = new Stack<>();
        // 각 항에 대한 오큰수를 저장하는 배열
        int[] result = new int[n];
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            // 현재 항의 값
            int currentValue = Integer.parseInt(tokenizer.nextToken());
            // 오큰수를 만나지 못한 이전 항의 값보다 현재 값이 크면 이전 항의 결과값을 현재 항의 값으로 변경
            while (!stack.isEmpty() && stack.peek().getValue() < currentValue) {
                result[stack.pop().getIndex()] = currentValue;
            }
            // 현재 항의 오큰수를 이후에 찾아야 하므로 스택에 추가
            stack.push(new Term(currentIndex, currentValue));
        }
        // 오큰수를 만나지 못한 모든 항의 결과값은 -1
        while (!stack.isEmpty()) {
            result[stack.pop().getIndex()] = -1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(result[i]);
            if (i < n - 1) {
                builder.append(" ");
            }
        }
        writer.write(builder.append("\n").toString());
        reader.close();
        writer.close();
    }

    static final class Term {

        private final int index;

        private final int value;

        public Term(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
