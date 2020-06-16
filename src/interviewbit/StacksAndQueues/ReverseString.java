package interviewbit.StacksAndQueues;

import java.util.Stack;

public class ReverseString {
	public String reverseString(String A) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			stack.push(A.charAt(i));
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}
}
