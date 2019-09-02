package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class COMPILER {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			Stack<Character> s = new Stack<>();
			int count = 0;
			char[] chars = in.readLine().toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char ch = chars[i];
				if (ch == '<') {
					s.push(ch);
				} else if (s.isEmpty()) {
					break;
				} else {
					s.pop();
					if (s.isEmpty()) {
						count = i + 1;
					}
				}
			}
			System.out.println(count);
		}
	}
}
