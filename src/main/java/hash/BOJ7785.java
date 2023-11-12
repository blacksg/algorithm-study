package hash;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/7785">회사에 있는 사람</a>
 * @사이트 백준
 * @난이도 SILVER V
 * @알고리즘 해시
 */
class BOJ7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int records = Integer.parseInt(reader.readLine());
        Set<String> names = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < records; i++) {
            String[] details = reader.readLine().split(" ");
            String name = details[0];
            String recordType = details[1];
            if (recordType.equals("enter")) {
                names.add(name);
            } else {
                names.remove(name);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            builder.append(name).append("\n");
        }
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
