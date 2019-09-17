package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B343 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] input = in.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();
		for (char c : input) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}

		System.out.println(stack.isEmpty() ? "Yes" : "No");
	}
}
