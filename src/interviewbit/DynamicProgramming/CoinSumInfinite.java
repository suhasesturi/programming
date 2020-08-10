package interviewbit.DynamicProgramming;

import java.util.ArrayList;

public class CoinSumInfinite {
	public int coinchange2(ArrayList<Integer> coins, int sum) {
		int mod = 1000007;
		int[] dp = new int[sum + 1];
		dp[0] = 1;

		for (Integer coin : coins) {
			for (int j = coin; j <= sum; j++) {
				dp[j] = (dp[j] + dp[j - coin]) % mod;
			}
		}
		return dp[sum];
	}
}
