package interviewbit.DynamicProgramming;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int n = S.length(), m = T.length();
		int[][] dp = new int[n + 1][m + 1];

		for (int j = 0; j <= m; j++) dp[n][j] = 0;
		for (int i = 0; i <= n; i++) dp[i][m] = 1;

		/*
		f(i, j) = f(i + 1, j + 1) + f(i + 1, j) if S[i] == T[j]
				= f(i + 1, j) if S[i] != T[j]
		 */
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (S.charAt(i) == T.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
				} else {
					dp[i][j] = dp[i + 1][j];
				}
			}
		}

		return dp[0][0];
	}
}
