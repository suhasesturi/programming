package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ANARC09A {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (true) {
			char[] chars = in.readLine().toCharArray();
			if (chars[0] == '-') break;

			Stack<Character> stack = new Stack<>();
			int result = 0;
			for (char ch : chars) {
				if (ch == '{') stack.push(ch);
				else {
					if (stack.isEmpty()) {
						result++;
						stack.push('{');
					} else {
						stack.pop();
					}
				}
			}
			result += stack.size() / 2;
			System.out.println(t + ". " + result);
			t++;
		}
	}
}
