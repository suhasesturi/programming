package interviewbit.DynamicProgramming;

import java.util.List;

public class BestTimeToBuyAndSellStocksIII {
	public int maxProfit(final List<Integer> prices) {
		if (prices == null || prices.isEmpty()) return 0;
		int n = prices.size();
		int[][] dp = new int[2 + 1][n];
		for (int i = 1; i <= 2; i++) {
			int diff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++) {
				diff = Math.max(diff, dp[i - 1][j - 1] - prices.get(j - 1));
				dp[i][j] = Math.max(dp[i][j - 1], prices.get(j) + diff);
			}
		}

		return dp[2][n - 1];
	}
}
