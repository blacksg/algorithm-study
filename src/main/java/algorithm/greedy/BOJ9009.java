package algorithm.greedy;

import java.io.*;
import java.util.Stack;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/9009">피보나치</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 그리디
 */
class BOJ9009 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        // 피보나치수 테이블을 생성한다.
        int[] fibonacciTable = generateFibonacciTable();

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());

            // n을 구성하는 피보나치수들을 담는 스택
            Stack<Integer> fibonacciFactorStack = new Stack<>();

            // 큰 피보나치수부터 찾기 위해서 역순으로 탐색한다.
            for (int j = fibonacciTable.length - 1; n > 0 && j >= 0; j--) {
                int fibonacci = fibonacciTable[j];
                // n 이하의 가장 큰 피보나치수를 발견하면 그만큼 n에서 빼고 스택에 추가한다.
                // 스택의 꼭대기에 가까울 수록 작은 피보나치수다.
                if (fibonacci <= n) {
                    n -= fibonacci;
                    fibonacciFactorStack.push(fibonacci);
                }
            }

            // 스택에서 피보나치수를 하나씩 빼서 정답 문자열에 추가한다.
            while (!fibonacciFactorStack.isEmpty()) {
                builder.append(fibonacciFactorStack.pop()).append(" ");
            }
            builder.append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static int[] generateFibonacciTable() {
        // f(44) < 10_0000_0000 < f(45)
        int[] table = new int[45];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i < table.length; i++) {
            table[i] = table[i - 2] + table[i - 1];
        }
        return table;
    }
}
