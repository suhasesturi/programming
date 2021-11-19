package interviewbit.DynamicProgramming;

import java.util.Arrays;

public class NDigitNumbersWithDigitSumS {
	private int[][] dp;
	private final int mod = 1000000007;

	public int solve(int n, int sum) {
		dp = new int[n][sum + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		long ans = 0;
		for (int i = 1; i < 10; i++) {
			ans = (ans + recurse(n - 1, sum - i)) % mod;
		}
		return (int) ans;
	}

	private int recurse(int n, int sum) {
		if (n == 0 || sum < 0) {
			return sum == 0 ? 1 : 0;
		}
		if (dp[n][sum] != -1) return dp[n][sum];

		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = (ans + recurse(n - 1, sum - i)) % mod;
		}
		return dp[n][sum] = (int) ans;
	}
}
