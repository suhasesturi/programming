package topcoder;

import java.util.Arrays;

public class DivisorInc {
	private static final int inf = 100010;

	public int countOperations(int n, int m) {
		int[] dp = new int[inf];
		Arrays.fill(dp, inf);
		dp[n] = 0;

		for (int i = n; i <= m; i++) {
			if (dp[i] != inf) {
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						int k = i + j;
						if (k <= m) {
							dp[k] = Math.min(dp[k], dp[i] + 1);
						}

						k = i + i / j;
						if (k <= m) {
							dp[k] = Math.min(dp[k], dp[i] + 1);
						}
					}
				}
			}
		}

		return dp[m] >= inf ? -1 : dp[m];
	}
}
