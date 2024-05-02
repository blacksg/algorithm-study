package algorithm.hash;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/16165">걸그룹 마스터 준석이</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 해시
 */
class BOJ16165 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] infos = reader.readLine().split(" ");
        int numberOfGroups = Integer.parseInt(infos[0]);
        int numberOfQuizzes = Integer.parseInt(infos[1]);
        Map<String, Set<String>> members = new HashMap<>(numberOfGroups);
        Map<String, String> groups = new HashMap<>();
        for (int i = 0; i < numberOfGroups; i++) {
            String groupName = reader.readLine();
            if (!members.containsKey(groupName)) {
                members.put(groupName, new TreeSet<>());
            }
            int numberOfMembers = Integer.parseInt(reader.readLine());
            for (int j = 0; j < numberOfMembers; j++) {
                String memberName = reader.readLine();
                members.get(groupName).add(memberName);
                groups.put(memberName, groupName);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numberOfQuizzes; i++) {
            String name = reader.readLine();
            String quizType = reader.readLine();
            if (quizType.equals("0")) {
                for (String memberName : members.get(name)) {
                    builder.append(memberName).append("\n");
                }
            } else {
                String groupName = groups.get(name);
                builder.append(groupName).append("\n");
            }
        }
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
