package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class C797 {
	private static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = in.readLine().toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length; i++) map.put(chars[i], i);

		char current = 'a';
		StringBuilder u = new StringBuilder();
		int index = 0;
		while (current <= 'z' && index < chars.length) {
			while (!stack.isEmpty() && stack.peek() <= current) u.append(stack.pop());
			if (map.containsKey(current)) {
				while (index <= map.get(current)) {
					if (chars[index] == current) u.append(chars[index++]);
					else stack.push(chars[index++]);
				}
			}

			current = (char) (current + 1);
		}

		while (!stack.isEmpty()) u.append(stack.pop());
		System.out.println(u);
	}
}
