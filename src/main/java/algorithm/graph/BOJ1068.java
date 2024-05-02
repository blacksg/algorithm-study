package algorithm.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1068">트리</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 그래프, 트리, DFS
 */
class BOJ1068 {

    private static int n;

    private static int[] parents;

    private static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // parents 초기화
        n = Integer.parseInt(reader.readLine());
        parents = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            parents[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int removed = Integer.parseInt(reader.readLine());
        if (removed != 0) {
            parents[removed] = -1;
            findLeaves(0);
        }

        writer.write(Integer.toString(leafCount));
        reader.close();
        writer.close();
    }

    private static void findLeaves(int current) {
        int left = current * 2 + 1;
        int right = current * 2 + 2;
        boolean hasLeftChild = left < n && parents[left] != -1;
        boolean hasRightChild = right < n && parents[right] != -1;
        // 왼쪽 자식이 있으면 리프 노드인지 확인
        if (hasLeftChild) {
            findLeaves(left);
        }
        // 오른쪽 자식이 있으면 리프 노드인지 확인
        if (hasRightChild) {
            findLeaves(right);
        }
        // 양쪽 자식이 없으면 리프 노드 개수 증가
        if (!hasLeftChild && !hasRightChild) {
            leafCount++;
        }
    }
}
