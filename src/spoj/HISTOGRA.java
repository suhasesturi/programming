package spoj;

import util.CustomReader;

import java.io.IOException;
import java.util.Stack;

public class HISTOGRA {
	private static int[] heights = new int[100010];

	public static void main(String[] args) throws IOException {
		CustomReader in = new CustomReader(System.in);
		while (true) {
			int n = in.nextInt();
			if (n == 0) break;

			for (int i = 0; i < n; i++) {
				heights[i] = in.nextInt();
			}

			Stack<Integer> stack = new Stack<>();
			long result = 0;
			int i = 0;
			while (i < n) {
				if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
					stack.push(i++);
				} else {
					int top = stack.pop();
					long current = (long) heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
					result = Math.max(current, result);
				}
			}

			while (!stack.isEmpty()) {
				int top = stack.pop();
				long current = (long) heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				result = Math.max(current, result);
			}

			System.out.println(result);
		}
	}
}
