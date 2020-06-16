package interviewbit.StacksAndQueues;

import java.util.Stack;

public class GenerateAllParenthesis {
	public int isValid(String A) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) return 0;
				char top = stack.pop();
				if (!((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '['))) {
					return 0;
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
