package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1191 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		long n = Long.parseLong(s[0]);
		int m = Integer.parseInt(s[1]);
		long k = Long.parseLong(s[2]);

		s = in.readLine().split(" ");
		long[] p = new long[s.length];
		for (int i = 0; i < s.length; i++) {
			p[i] = Long.parseLong(s[i]);
		}

		long max;
		int count = 0;
		long reduce = 0;
		for (int i = 0; i < m; ) {
			max = Math.min(k * ((p[i] - reduce - 1) / k) + k, n);

			long currentReduce = reduce;
			while (i < m && p[i] - currentReduce <= max) {
				reduce++;
				i++;
			}
			count++;
		}

		System.out.println(count);
	}
}
