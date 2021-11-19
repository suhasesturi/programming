package codeforces.Contest1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			if (n <= 1) {
				System.out.println(0);
				continue;
			}
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(a);

			int min = a[0] + a[1], max = a[n - 1] + a[n - 2];
			int result = 0;
			for (int sum = min; sum <= max; sum++) {
				int count = 0;
				for (int i = 0, j = n - 1; i < j; ) {
					if (a[i] + a[j] == sum) {
						count++;
						i++;
						j--;
					} else if (a[i] + a[j] < sum) {
						i++;
					} else {
						j--;
					}
				}
				result = Math.max(result, count);
			}
			System.out.println(result);
		}
	}
}
