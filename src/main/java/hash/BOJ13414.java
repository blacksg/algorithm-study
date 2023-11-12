package hash;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/13414">수강신청</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 해시
 */
class BOJ13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] classInfos = reader.readLine().split(" ");
        int capacity = Integer.parseInt(classInfos[0]);
        int queueLength = Integer.parseInt(classInfos[1]);
        Set<String> registrations = new LinkedHashSet<>();
        for (int order = 0; order < queueLength; order++) {
            String studentId = reader.readLine();
            registrations.remove(studentId);
            registrations.add(studentId);
            System.out.println(registrations);
        }
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = registrations.iterator();
        for (int i = 0; iterator.hasNext() && i < capacity; i++) {
            builder.append(iterator.next()).append("\n");
        }
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
