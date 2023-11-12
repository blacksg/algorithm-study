package queue;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/5464">주차장</a>
 * @사이트 백준
 * @난이도 SILVER II
 * @알고리즘 큐
 */
class BOJ5464 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        // 인덱스: 주차 공간 번호, 요소: 주차 공간의 단위 무게 당 요금
        int[] unitFees = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unitFees[i] = Integer.parseInt(reader.readLine());
        }

        // 인덱스: 차량 번호, 요소: 차량 무게
        int[] carWeights = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            carWeights[i] = Integer.parseInt(reader.readLine());
        }

        // 인덱스: 차량 번호, 요소: 주차 중인 주차 공간의 번호 (주차 중이지 않으면 0)
        int[] usingParkingLotNumbers = new int[m + 1];

        // 비어있는 주차 공간 번호를 담은 우선순위 큐
        PriorityQueue<Integer> availableParkingLotNumbers = new PriorityQueue<>(m);
        for (int parkingLotNumber = 1; parkingLotNumber <= n; parkingLotNumber++) {
            availableParkingLotNumbers.offer(parkingLotNumber);
        }

        // 차량 번호 대기열
        Queue<Integer> carNumberQueue = new LinkedList<>();

        // 총 수입
        int totalIncome = 0;

        // 출입 기록을 처리한다.
        for (int i = 0; i < 2 * m; i++) {
            int record = Integer.parseInt(reader.readLine());
            int currentCarNumber = Math.abs(record);
            if (record > 0) {
                // 입차 기록이고 비어있는 주차 공간이 없으면 현재 차량 번호를 대기열에 추가한다.
                // 비어있는 주차 공간이 있으면 이의 번호를 현재 차량 번호에게 할당한다.
                if (availableParkingLotNumbers.isEmpty()) {
                    carNumberQueue.offer(currentCarNumber);
                } else {
                    usingParkingLotNumbers[currentCarNumber] = availableParkingLotNumbers.poll();
                }
            } else {
                // 출차 기록이면 요금을 합산한다.
                // 대기 중인 차량이 없으면 사용 중이던 주차 공간의 번호를 우선순위 큐에 다시 추가한다.
                // 대기 중인 차량이 있으면 해당 차량 번호에게 사용 중이던 주차 공간의 번호를 할당한다.
                int usingParkingLotNumber = usingParkingLotNumbers[currentCarNumber];
                totalIncome += unitFees[usingParkingLotNumber] * carWeights[currentCarNumber];
                if (carNumberQueue.isEmpty()) {
                    availableParkingLotNumbers.offer(usingParkingLotNumber);
                } else {
                    usingParkingLotNumbers[carNumberQueue.poll()] = usingParkingLotNumber;
                }
            }
        }

        // 총 수입을 출력한다.
        writer.write(totalIncome + "\n");
        reader.close();
        writer.close();
    }
}
