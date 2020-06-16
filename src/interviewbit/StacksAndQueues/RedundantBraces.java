package interviewbit.StacksAndQueues;

import java.util.Stack;

public class RedundantBraces {
	public static void main(String[] args) {
		System.out.println(new RedundantBraces().braces("(a + (a + b))"));
	}

	public int braces(String A) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch == ')') {
				boolean flag = false;
				while (!stack.isEmpty()) {
					char top = stack.pop();
					if (top == '(') {
						if (!flag) return 1;
						break;
					}
					if (isOperation(top)) flag = true;
				}
				stack.push('1');
			} else {
				stack.push(ch);
			}
		}
		return 0;
	}

	private boolean isOperation(char ch) {
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
	}
}
