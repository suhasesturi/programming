package spoj;

import util.CustomReader;

import java.io.IOException;
import java.util.Stack;

public class STPAR {
	public static void main(String[] args) throws IOException {
		CustomReader in = new CustomReader(System.in);
		while (true) {
			int n = in.nextInt();
			if (n == 0) break;
			int current = 1;
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				int temp = in.nextInt();
				if (temp == current) {
					current++;
				} else if (!stack.isEmpty()) {
					while (!stack.isEmpty() && stack.peek() == current) {
						stack.pop();
						current++;
					}
					stack.push(temp);
				} else {
					stack.push(temp);
				}
			}
			while (!stack.isEmpty() && stack.peek() == current) {
				stack.pop();
				current++;
			}

			System.out.println(stack.isEmpty() ? "yes" : "no");
		}
	}
}