package queue;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/26043">식당 메뉴</a>
 * @사이트 백준
 * @난이도 SILVER IV
 * @알고리즘 큐
 */
class BOJ26043 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 처리해야 하는 정보의 개수
        int numberOfInfos = Integer.parseInt(reader.readLine());
        // 대기 중인 학생 큐
        Queue<Student> studentQueue = new LinkedList<>();
        // 각 학생의 식사 결과 유형을 담은 배열 (학생 번호는 정보의 개수와 같거나 작음)
        Result[] results = new Result[numberOfInfos + 1];
        // 각 줄의 정보를 유형에 따라 처리
        for (int i = 0; i < numberOfInfos; i++) {
            String[] details = reader.readLine().split(" ");
            // 정보 유형 1인 경우 학생 인스턴스를 생성하여 큐에 삽입
            if (details[0].equals("1")) {
                int id = Integer.parseInt(details[1]);
                int menu = Integer.parseInt(details[2]);
                Student student = new Student(id, menu);
                studentQueue.offer(student);
            }
            // 정보 유형 2인 경우 결과 유형(FAVORITE 또는 ALTERNATIVE)을 판별하여 배열에 저장
            else {
                int menu = Integer.parseInt(details[1]);
                assert !studentQueue.isEmpty();
                Student student = studentQueue.poll();
                results[student.getId()] = (menu == student.getMenu()) ? Result.FAVORITE : Result.ALTERNATIVE;
            }
        }
        // 정보를 모두 처리하고 나서도 큐에 남아있는 학생은 아무것도 먹지 못하므로 결과 유형을 NOTHING으로 처리
        while (!studentQueue.isEmpty()) {
            results[studentQueue.poll().getId()] = Result.NOTHING;
        }
        // 각 학생의 결과 유형에 따른 StringBuilder를 담은 배열
        StringBuilder[] builders = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            builders[i] = new StringBuilder();
        }
        // 학생 번호를 순서대로 결과 유형에 해당하는 StringBuilder에 추가
        for (int studentId = 1; studentId < results.length; studentId++) {
            Result result = results[studentId];
            if (result != null) {
                int index = result.ordinal();
                builders[index].append(studentId).append(" ");
            }
        }
        // 각 결과 유형의 StringBuilder를 출력
        for (StringBuilder builder : builders) {
            if (builder.length() == 0) {
                builder.append("None");
            } else {
                builder.deleteCharAt(builder.length() - 1);
            }
            writer.write(builder.append("\n").toString());
        }
        reader.close();
        writer.close();
    }

    static final class Student {

        // 학생 번호
        private final int id;

        // 학생이 종아하는 메뉴
        private final int menu;

        public Student(int id, int menu) {
            this.id = id;
            this.menu = menu;
        }

        public int getId() {
            return id;
        }

        public int getMenu() {
            return menu;
        }
    }

    enum Result {

        // 선택한 메뉴를 먹음
        FAVORITE,
        // 다른 메뉴를 먹음
        ALTERNATIVE,
        // 아무것도 먹지 못함
        NOTHING
    }
}
