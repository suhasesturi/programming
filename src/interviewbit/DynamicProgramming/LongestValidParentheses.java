package interviewbit.DynamicProgramming;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else result = Math.max(result, i - stack.peek());
            }
        }

        return result;
    }
}
