package algorithm.greedy;

import java.io.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1946">신입 사원</a>
 * @사이트 백준
 * @난이도 SILVER I
 * @알고리즘 그리디, 정렬
 */
class BOJ1946 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < testCaseCount; i++) {
            int applicantCount = Integer.parseInt(reader.readLine());
            int[] secondTestGrades = new int[applicantCount + 1];
            for (int j = 0; j < applicantCount; j++) {
                String[] line = reader.readLine().split(" ");
                int firstTestGrade = Integer.parseInt(line[0]);
                int secondTestGrade = Integer.parseInt(line[1]);
                secondTestGrades[firstTestGrade] = secondTestGrade;
            }
            
            int candidateCount = 1;
            int lowestSecondTestGrade = secondTestGrades[1];
            for (int j = 2; j <= applicantCount; j++) {
                if (secondTestGrades[j] < lowestSecondTestGrade) {
                    lowestSecondTestGrade = secondTestGrades[j];
                    candidateCount++;
                }
            }
            
            stringBuilder.append(candidateCount).append('\n');
        }
        
        writer.write(stringBuilder.toString());
        reader.close();
        writer.close();
    }
}
