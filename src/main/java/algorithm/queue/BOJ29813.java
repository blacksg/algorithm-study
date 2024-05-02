package algorithm.queue;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/29813">최애의 팀원</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 큐
 */
class BOJ29813 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 데이터로 학생 인스턴스를 생성하여 큐에 추가
        Queue<Student> studentQueue = new LinkedList<>();
        int studentCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < studentCount; i++) {
            String[] studentInfos = reader.readLine().split(" ");
            Student student = new Student(Integer.parseInt(studentInfos[1]), studentInfos[0]);
            studentQueue.offer(student);
        }
        // 큐에 3명 이상의 학생이 남아 있는 동안 반복
        while (studentQueue.size() > 2) {
            // 팀원을 선택하는 학생의 학번
            int studentId = studentQueue.poll().getId();
            // 패스할 학생의 수를 계산하고 그만큼 큐에서 제거한 다음 다시 삽입
            int passCount = (studentId - 1) % studentQueue.size();
            for (int i = 0; i < passCount; i++) {
                studentQueue.offer(studentQueue.poll());
            }
            // 선택된 팀원은 큐에서 제거
            studentQueue.poll();
        }
        // 큐에 남아있는 학생의 이니셜이 정답
        assert !studentQueue.isEmpty();
        writer.write(studentQueue.peek().getName());
        reader.close();
        writer.close();
    }

    static final class Student {

        private final int id;

        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
