package interviewbit.DynamicProgramming;

public class EditDistance {
	public int minDistance(String source, String target) {
		int n = source.length(), m = target.length();
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) dp[0][j] = j;
				else if (j == 0) dp[i][0] = i;
				else if (source.charAt(i - 1) == target.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
							Math.min(dp[i][j - 1], dp[i - 1][j]));
			}
		}

		return dp[n][m];
	}
}
