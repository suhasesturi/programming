package codeforces.Contest1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			long result = 0;
			int[] a = new int[n];
			int[] b = new int[n];
			String[] s = in.readLine().split(" ");
			int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(s[i]);
				minA = Math.min(minA, a[i]);
			}
			s = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				b[i] = Integer.parseInt(s[i]);
				minB = Math.min(minB, b[i]);
			}

			for (int i = 0; i < n; i++) {
				int diff = Math.max(a[i] - minA, b[i] - minB);
				result += diff;
			}

			System.out.println(result);
		}
	}
}
