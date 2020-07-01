package codeforces.Contest1374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			s = in.readLine().split(" ");
			long[] list = new long[n];
			for (int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(s[i]) % k;
				if (list[i] != 0) {
					list[i] = k - list[i];
				}
			}
			Arrays.sort(list);
			int start = 0, multiplier = 0;
			while (start < n && list[start] == 0) {
				start++;
			}
			for (int i = start; i < n; i++) {
				if (list[i] == list[start]) {
					list[i] += (long) multiplier++ * k;
				} else {
					start = i;
					multiplier = 1;
				}
			}
			Arrays.sort(list);
			System.out.println(list[n - 1] == 0 ? 0 : list[n - 1] + 1);
		}
	}
}
