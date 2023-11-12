package queue;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/12873">기념품</a>
 * @사이트 백준
 * @난이도 SILVER VI
 * @알고리즘 큐
 */
class BOJ12873 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 각 참가자 번호를 순서대로 큐에 삽입
        Queue<Integer> participantQueue = new LinkedList<>();
        int numberOfParticipants = Integer.parseInt(reader.readLine());
        for (int participant = 1; participant <= numberOfParticipants; participant++) {
            participantQueue.offer(participant);
        }
        // 큐의 크기가 1이 될 때까지 단계를 증가시키며 반복
        int step = 1;
        while (participantQueue.size() > 1) {
            int numberOfSurvivors = participantQueue.size();
            // 현재 단계에서 제외시킬 참가자의 위치 결정 (modulo 연산)
            int moves = (int) (Math.pow(step, 3) % numberOfSurvivors);
            if (moves == 0) {
                moves = numberOfSurvivors;
            }
            // 제외시킬 참가자 이전까지는 큐에서 제거한 다음 다시 삽입하여 순서를 변경
            for (int i = 1; i < moves; i++) {
                participantQueue.offer(participantQueue.poll());
            }
            // 제외시킬 참가자는 큐에서 제거
            participantQueue.poll();
            step++;
        }
        // 큐의 크기가 1이므로 맨 앞에 있는 참가자의 번호가 정답
        writer.write(String.valueOf(participantQueue.peek()));
        reader.close();
        writer.close();
    }

    private static void anotherSolution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 모든 참가자 번호를 리스트에 삽입
        int numberOfParticipants = Integer.parseInt(reader.readLine());
        List<Integer> participants = new ArrayList<>(numberOfParticipants);
        for (int participant = 1; participant <= numberOfParticipants; participant++) {
            participants.add(participant);
        }
        // 리스트의 크기가 1이 될 때까지 단계를 증가시키며 반복
        int index = 0;
        for (int step = 1; step < numberOfParticipants; step++) {
            // 현재 단계에서 제외시킬 참가자의 인덱스를 계산하여 리스트에서 제거
            long moveCount = (long) Math.pow(step, 3);
            index = (int) ((index + moveCount - 1) % participants.size());
            participants.remove(index);
        }
        // 마지막으로 남은 참가자의 번호가 정답
        writer.write(String.valueOf(participants.get(0)));
        reader.close();
        writer.close();
    }
}
