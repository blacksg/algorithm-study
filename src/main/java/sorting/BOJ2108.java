package sorting;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/2108">통계학</a>
 * @사이트 백준
 * @난이도 SILVER III
 * @알고리즘 정렬
 */
class BOJ2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());

        // 산술 평균을 구하기 위한 숫자의 총합
        int sum = 0;

        // 중앙값 및 범위를 구하기 위한 숫자 리스트
        List<Integer> numbers = new ArrayList<>(n);

        // key: 숫자, value: 빈도
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            sum += number;
            numbers.add(number);
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        // 중앙값 및 범위를 구하기 위해 숫자 기준 오름차순으로 정렬
        numbers.sort(Comparator.comparingInt(num -> num));

        long mean = Math.round((double) sum / n);
        int median = numbers.get(numbers.size() / 2);
        int range = numbers.get(numbers.size() - 1) - numbers.get(0);

        // 최빈수를 구하기 위해 빈도 기준 오름차순으로 정렬 (빈도가 같은 경우 숫자 기준 오름차순으로 정렬)
        entries.sort((entry1, entry2) -> {
            int frequencyDiff = entry2.getValue() - entry1.getValue();
            return frequencyDiff == 0 ? entry1.getKey() - entry2.getKey() : frequencyDiff;
        });

        // 최빈수는 기본적으로 1번째 엔트리의 숫자로 정한다.
        Map.Entry<Integer, Integer> mostFrequentEntry = entries.get(0);
        int mode = mostFrequentEntry.getKey();

        // 1번째와 2번째 엔트리의 빈도가 같으면 최빈수를 2번째 엔트리의 숫자로 정한다.
        if (entries.size() > 1) {
            Map.Entry<Integer, Integer> secondFrequentEntry = entries.get(1);
            if (mostFrequentEntry.getValue().equals(secondFrequentEntry.getValue())) {
                mode = secondFrequentEntry.getKey();
            }
        }

        builder.append(mean).append("\n")
            .append(median).append("\n")
            .append(mode).append("\n")
            .append(range).append("\n");
        writer.write(builder.toString());
        reader.close();
        writer.close();
    }

    public void anotherSolution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int[] frequencies = new int[8001];
        int min = 4000;
        int max = -4000;
        int n = Integer.parseInt(reader.readLine());

        // 입력된 숫자들을 가지고 총합, 빈도 배열, 최솟값, 최댓값을 업데이트한다.
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            sum += number;
            frequencies[number + 4000]++;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        int mean = (int) Math.round((double) sum / n);
        int range = max - min;
        int median = min;
        int mode = min;

        int numberCount = 0;
        int midpoint = (n / 2) + 1;
        int maxFrequency = 0;
        boolean foundLeastMode = false;

        for (int number = min; number <= max; number++) {
            int index = number + 4000;
            int frequency = frequencies[index];

            // 빈도가 0인 숫자는 건너뛴다.
            if (frequency == 0) {
                continue;
            }

            // 이전까지의 숫자 개수 카운트가 전체 숫자 개수의 절반 미만이면 현재 숫자의 빈도를 숫자 카운트에 합산한다.
            if (numberCount < midpoint) {
                numberCount += frequency;
                // 현재 숫자의 빈도까지 카운트에 누적했을 때 절반을 넘는다면 현재 숫자가 중앙값인 것이다.
                if (numberCount >= midpoint) {
                    median = number;
                }
            }

            // 현재 숫자의 빈도가 이전까지의 최대 빈도보다 크면 최빈값 중 가장 작은 값이다.
            // 가장 작은 최빈값을 찾았다는 플래그를 true로 바꾼다.
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = number;
                foundLeastMode = true;
            }
            // 이전까지의 최빈값과 빈도가 같고 플래그가 true이면 현재 숫자가 2번째로 작은 최빈값이라는 것이다.
            // 최빈값을 현재 숫자로 업데이트하고 플래그를 false로 바꾼다.
            else if (frequency == maxFrequency && foundLeastMode) {
                mode = number;
                foundLeastMode = false;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(mean).append("\n");
        builder.append(median).append("\n");
        builder.append(mode).append("\n");
        builder.append(range).append("\n");

        writer.write(builder.toString());
        reader.close();
        writer.close();
    }
}
