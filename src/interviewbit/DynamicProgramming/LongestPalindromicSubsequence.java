package interviewbit.DynamicProgramming;

public class LongestPalindromicSubsequence {
	public int solve(String a) {
		int n = a.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int gap = 2; gap < n; gap++) {
			for (int i = 0, j = i + gap - 1; j < n; i++, j++) {
				if (a.charAt(i) == a.charAt(j)) {
					dp[i][j] = 2;
					if (gap != 2) {
						dp[i][j] += dp[i + 1][j - 1];
					}
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n - 1][n - 1];
	}
}
