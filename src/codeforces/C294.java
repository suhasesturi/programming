package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class C294 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);

		s = in.readLine().split(" ");
		ArrayList<Integer> B = new ArrayList<>();
		for (String value : s) {
			B.add(Integer.parseInt(value));
		}

		solve(n, B);
	}

	private static final int MOD = (int) (1e9 + 7);
	public static void solve(int A, ArrayList<Integer> B) {
		initialize();
		Collections.sort(B);
		int count = B.get(0) - 1;
		long result = 1;

		for (int i = 1; i < B.size(); i++) {
			int t = B.get(i) - B.get(i - 1) - 1;
			if (t > 0) {
				result = (((result * exp[t - 1]) % MOD) * comb[count + t][t]) % MOD;
				count += t;
			}
		}
		int t = A - B.get(B.size() - 1);
		System.out.println((result * comb[count + t][t]) % MOD);
	}

	private static long[][] comb = new long[1001][1001];
	private static long[] exp = new long[1001];

	private static void initialize() {
		exp[0] = 1;
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) comb[i][j] = 1;
				else comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
			}
			if (i != 0) {
				exp[i] = (exp[i - 1] * 2) % MOD;
			}
		}
	}
}
