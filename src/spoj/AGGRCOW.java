package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AGGRCOW {
	private static int[] stalls = new int[100010];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			String[] s = in .readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);

			long sum = 0;
			for (int i = 0; i < n; i++) {
				stalls[i] = Integer.parseInt(in.readLine());
				sum += stalls[i];
			}

			Arrays.sort(stalls, 0, n);

			long a = 0, b = sum;
			while (a < b) {
				long mid = (a + b + 1) / 2;
				if (solve(n, mid, c)) a = mid;
				else b = mid - 1;
			}
			System.out.println(a);
		}
	}

	private static boolean solve(int n, long distance, int cows) {
		long sum = 0;
		for (int i = 1; i < n; i++) {
			sum += (stalls[i] - stalls[i - 1]);
			if (sum >= distance) {
				sum = 0;
				cows--;
			}
		}
		return cows <= 1;
	}
}
