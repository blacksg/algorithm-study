package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * @문제 <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42578">의상</a>
 * @사이트 프로그래머스
 * @난이도 Lv.2
 * @알고리즘 해시
 */
class PG42578 {

    public int solution(String[][] clothes) {
        Map<String, Integer> categories = new HashMap<>();
        for (String[] clothe : clothes) {
            String categoryName = clothe[1];
            categories.put(categoryName, categories.getOrDefault(categoryName, 0) + 1);
        }
        int combinations = 1;
        for (Map.Entry<String, Integer> category : categories.entrySet()) {
            combinations *= category.getValue() + 1;
        }
        return combinations - 1;
    }

    private int streamSolution(String[][] clothes) {
        return Arrays.stream(clothes)
                   .collect(groupingBy(clothe -> clothe[1], counting()))
                   .values()
                   .stream()
                   .reduce(1L, (combinations, count) -> combinations * (count + 1))
                   .intValue() - 1;
    }
}
