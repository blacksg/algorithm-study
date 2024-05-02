package algorithm.recursion;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/5639">이진 검색 트리</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 재귀, 그래프
 */
class BOJ5639 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        Node root = new Node(Integer.parseInt(reader.readLine()));
        String line;
        while ((line = reader.readLine()) != null && line.length() > 0) {
            root.insert(Integer.parseInt(line));
        }
        postOrder(root, builder);

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    private static void postOrder(Node node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        postOrder(node.leftChild, builder);
        postOrder(node.rightChild, builder);
        builder.append(node.value).append("\n");
    }

    static class Node {

        private final int value;

        private Node leftChild;

        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                } else {
                    leftChild.insert(value);
                }
            } else if (value > this.value) {
                if (rightChild == null) {
                    rightChild = new Node(value);
                } else {
                    rightChild.insert(value);
                }
            }
        }
    }
}
