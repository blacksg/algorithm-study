package sorting;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1946">신입 사원</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 정렬, 그리디
 */
class BOJ1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int applicantCount = Integer.parseInt(reader.readLine());

            // 서류심사 순위 기준 오름차순으로 정렬된 지원자 리스트
            List<Applicant> applicants = new ArrayList<>();
            for (int applicantIndex = 0; applicantIndex < applicantCount; applicantIndex++) {
                String[] ranks = reader.readLine().split(" ");
                Applicant applicant = new Applicant(Integer.parseInt(ranks[0]), Integer.parseInt(ranks[1]));
                applicants.add(applicant);
            }
            Collections.sort(applicants);

            // 서류심사 1위 지원자는 무조건 합격하므로 1부터 카운트한다.
            int candidateCount = 1;

            // 단계를 거듭하면서 업데이트되는 면접시험 순위의 최솟값
            int minimumOfSecond = applicants.get(0).second;

            for (int j = 1; j < applicantCount; j++) {
                // 현재 지원자는 이전 지원자보다 서류심사 순위가 낮으므로 탈락하지 않으려면 면접시험 순위가 제일 높아야 한다.
                // 현재 지원자의 면접시험 순위가 면접시험 순위의 최솟값보다 높으면 합격자 수를 증가시키고 최솟값을 업데이트한다.
                int currentSecond = applicants.get(j).second;
                if (currentSecond < minimumOfSecond) {
                    candidateCount++;
                    minimumOfSecond = currentSecond;
                }
            }

            builder.append(candidateCount).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    static class Applicant implements Comparable<Applicant> {

        final int first;

        final int second;

        public Applicant(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Applicant another) {
            return this.first - another.first;
        }
    }

    public void anotherSolution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            int applicantCount = Integer.parseInt(reader.readLine());

            // 인덱스: 서류심사 순위, 요소: 면접시험 순위
            int[] interviewRanks = new int[applicantCount + 1];
            for (int j = 0; j < applicantCount; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int index = Integer.parseInt(tokenizer.nextToken());
                int rank = Integer.parseInt(tokenizer.nextToken());
                interviewRanks[index] = rank;
            }

            int candidateCount = 1;
            int minimumInterviewRank = interviewRanks[1];
            for (int j = 2; j <= applicantCount; j++) {
                if (interviewRanks[j] < minimumInterviewRank) {
                    candidateCount++;
                    minimumInterviewRank = interviewRanks[j];
                }
            }
            builder.append(candidateCount).append("\n");
        }

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
