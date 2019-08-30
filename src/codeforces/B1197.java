package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] s = in.readLine().split(" ");

		int[] list = new int[n];
		int left = -1, right = -1;
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(s[i]);
			if (list[i] == n) {
				left = i - 1;
				right = i + 1;
			}
		}

		int current = n - 1;
		boolean valid = true;
		while (left >= 0 || right < n) {
			if (left >= 0 && list[left] == current) {
				current--;
				left--;
			} else if (right < n && list[right] == current) {
				current--;
				right++;
			} else {
				valid = false;
				break;
			}
		}

		System.out.println(valid ? "YES" : "NO");
	}
}
