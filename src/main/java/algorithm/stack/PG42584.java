package algorithm.stack;

import java.util.Stack;

/**
 * @문제 <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42584">주식가격</a>
 * @사이트 프로그래머스
 * @난이도 Lv.2
 * @알고리즘 스택
 */
class PG42584 {

    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for (int currentIndex = 0; currentIndex < prices.length; currentIndex++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[currentIndex]) {
                answer[stack.peek()] = currentIndex - stack.pop();
            }
            stack.push(currentIndex);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        return answer;
    }
}
