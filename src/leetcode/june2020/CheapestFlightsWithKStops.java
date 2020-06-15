package leetcode.june2020;

import java.util.Arrays;

public class CheapestFlightsWithKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		long[][] dp = new long[k + 2][n];
		for (int i = 0; i < k + 2; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		dp[0][src] = 0;
		for (int i = 1; i < k + 2; i++) {
			dp[i][src] = 0;
			for (int[] flight: flights) {
				dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
			}
		}

		return dp[k + 1][dst] == Integer.MAX_VALUE ? -1 : (int) dp[k + 1][dst];
	}
}
