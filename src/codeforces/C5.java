package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class C5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = in.readLine().toCharArray();

		Stack<Pair> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int max = 0;

		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (stack.isEmpty()) {
				stack.push(new Pair(i, ch));
			} else {
				if (ch == ')' && stack.peek().ch == '(') {
					stack.pop();
					int previous = stack.isEmpty() ? -1 : stack.peek().index;
					int length = i - previous;
					max = Math.max(max, length);
					if (map.containsKey(length)) {
						map.put(length, map.get(length) + 1);
					} else {
						map.put(length, 1);
					}
				} else {
					stack.push(new Pair(i, ch));
				}
			}
		}

		System.out.println(max + " " + map.get(max));
	}

	private static class Pair {
		int index;
		char ch;

		Pair(int i, char c) {
			index = i;
			ch = c;
		}
	}
}
