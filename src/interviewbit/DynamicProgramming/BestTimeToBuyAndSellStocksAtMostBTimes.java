package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class BestTimeToBuyAndSellStocksAtMostBTimes {
	public static void main(String[] args) {
		System.out.println(new BestTimeToBuyAndSellStocksAtMostBTimes().solve(new ArrayList<>(Arrays.asList(11, 7, 11, 17, 12, 12, 16, 10, 11)), 4));
	}

	public int solve(ArrayList<Integer> prices, int k) {
		int n = prices.size();
		k = Math.min(k, n);

		int[][] dp = new int[k + 1][n];
		for (int i = 1; i <= k; i++) {
			int diff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++) {
				diff = Math.max(diff, dp[i - 1][j - 1] - prices.get(j - 1));
				dp[i][j] = Math.max(dp[i][j - 1], prices.get(j) + diff);
			}
		}
		return dp[k][n - 1];
	}
}
