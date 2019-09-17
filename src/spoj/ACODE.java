package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACODE {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = in.readLine();
			if (s.length() == 1 && s.charAt(0) == '0') break;
			long current = 1, previous = 1;

			if (s.charAt(0) == '0') {
				System.out.println(0);
				continue;
			}

			for (int i = 1; i < s.length(); i++) {
				char ch = s.charAt(i);

				if (ch == '0') {
					if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
						current = 0;
						break;
					} else {
						current = previous;
					}
				} else if (ch >= '7' && ch <= '9') {
					if (s.charAt(i - 1) == '1') {
						long temp = current;
						current += previous;
						previous = temp;
					} else {
						previous = current;
					}
				} else {
					if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
						long temp = current;
						current += previous;
						previous = temp;
					} else {
						previous = current;
					}
				}
			}
			System.out.println(current);
		}
	}
}
