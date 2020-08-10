package interviewbit.DynamicProgramming;

import java.util.Arrays;

public class ArrangeII {
	public int arrange(String A, int B) {
		if (A.length() < B) return -1;
		int n = A.length();
		int[][] dp = new int[n + 1][B + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], (int) 1e9);
		}
		dp[0][0] = 0;
		for (int j = 1; j <= B; j++) {
			for (int i = 1; i <= n; i++) {
				int w = 0, b = 0;
				for (int k = i; k >= 1; k--) {
					if (A.charAt(k - 1) == 'W') {
						w++;
					} else {
						b++;
					}
					dp[i][j] = Math.min(dp[i][j], dp[k - 1][j - 1] + w * b);
				}
			}
		}
		return dp[n][B];
	}
}
