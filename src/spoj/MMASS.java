package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MMASS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		for (char ch : in.readLine().toCharArray()) {
			if (ch == '(') {
				stack.push(-1);
			} else if (ch == ')') {
				int sum = 0;
				while (stack.peek() != -1) {
					sum += stack.pop();
				}
				stack.pop();
				stack.push(sum);
			} else if (ch == 'H' || ch == 'C' || ch == 'O') {
				stack.push(getMass(ch));
			} else {
				int temp = stack.pop();
				stack.push(temp * (ch - '0'));
			}
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

	private static int getMass(char ch) {
		if (ch == 'H') return 1;
		if (ch == 'C') return 12;
		if (ch == 'O') return 16;
		return 0;
	}
}
