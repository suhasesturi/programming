package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PALIN {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder result = new StringBuilder();
		while (t-- > 0) {
			char[] digits = in.readLine().toCharArray();
			int n = digits.length;
			int middle = digits.length / 2;

			int i = n % 2 == 0 ? middle - 1 : middle;
			int j = middle;
			boolean flag = false;
			for (; i >= 0 && j < n; i--, j++) {
				if (digits[i] > digits[j]) {
					flag = true;
					digits[j] = digits[i];
				} else if (digits[i] < digits[j]) {
					if (flag) {
						digits[j] = digits[i];
					} else {
						break;
					}
				}
			}

			if (flag) {
				for (char digit : digits) result.append(digit);
				result.append("\n");
				continue;
			}

			i = n % 2 == 0 ? middle - 1 : middle;
			for (; i >= 0; i--) {
				if (digits[i] == '9') {
					digits[i] = '0';
				} else {
					digits[i] = (char) (digits[i] + 1);
					break;
				}
			}

			if (i == -1) {
				result.append('1');
				for (int k = 0; k < n - 1; k++) result.append('0');
				result.append('1');
			} else {
				i = n % 2 == 0 ? middle - 1 : middle;
				j = middle;
				for (; i >= 0; i--, j++) digits[j] = digits[i];
				for (char digit : digits) result.append(digit);
			}
			result.append('\n');
		}
		System.out.println(result);
	}
}
