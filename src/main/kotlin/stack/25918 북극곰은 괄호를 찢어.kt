package stack

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.max

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val length = reader.readLine().toInt()
    var answer = -1
    
    // 원하는 문자열의 길이가 홀수이면 만들 수 없음
    if (length % 2 == 0) {
        val parentheses = reader.readLine().toCharArray()
        val stack = Stack<Char>()
        
        // 원하는 문자열을 순회
        for (parenthesis in parentheses) {
            // 스택이 비었거나 꼭대기에 있는 괄호가 현재 괄호와 같으면 스택에 현재 괄호를 삽입
            if (stack.isEmpty() || stack.peek().equals(parenthesis)) {
                stack.push(parenthesis)
            }
            // 스택 꼭대기에 있는 괄호가 현재 괄호와 다르면 문자로 바꿀 수 있으므로 스택에서 제거
            else {
                stack.pop()
            }
            // 스택에서 제거되지 않고 중첩되어 있는 괄호들의 최대 개수가 정답
            answer = max(answer, stack.size)
        }
        
        // 순회를 마쳐도 스택이 비지 않았으면 원하는 문자열을 만들 수 없음
        if (stack.isNotEmpty()) {
            answer = -1
        }
    }
    
    println(answer)
    reader.close()
}