package interviewbit.DynamicProgramming;

public class RegularExpressionII {
	public int isMatch(final String text, final String pattern) {
		int n = text.length(), m = pattern.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;
		for (int j = 1; j <= m; j++) {
			if (pattern.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
						dp[i][j] |= dp[i - 1][j];
					}
				} else if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m] ? 1 : 0;
	}
}
