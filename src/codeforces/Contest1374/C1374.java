package codeforces.Contest1374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class C1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String s = in.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				char ch = s.charAt(i);
				if (ch == '(' || stack.isEmpty()) {
					stack.push(ch);
				} else if (ch == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(ch);
					}
				}
			}
			System.out.println(stack.size() / 2);
		}
	}
}
