package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ONP {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			Stack<Character> stack = new Stack<>();
			for (Character c : in.readLine().toCharArray()) {
				if (c == ')') System.out.print(stack.pop());
				else if (c >= 'a' && c <= 'z') System.out.print(c);
				else if (c == '(') System.out.print("");
				else stack.push(c);
			}
			System.out.println();
		}
	}
}
