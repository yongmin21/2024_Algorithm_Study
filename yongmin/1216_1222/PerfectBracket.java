import java.util.Stack;

class Solution {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자에 대해 반복
        for (char c : s.toCharArray()) {
            // 스택이 비어 있는 경우
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            // 스택의 마지막 값이 '('이고 현재 문자가 ')'인 경우
            if (stack.peek() == '(' && c == ')') {
                stack.pop(); // 짝이 맞으므로 스택에서 제거
            } else {
                stack.push(c); // 짝이 맞지 않으면 스택에 추가
            }
        }

        // 스택이 비어 있으면 모든 괄호의 짝이 맞음
        return stack.isEmpty();
    }
}