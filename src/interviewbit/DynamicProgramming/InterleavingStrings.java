package interviewbit.DynamicProgramming;

public class InterleavingStrings {
	public int isInterleave(String A, String B, String C) {
		int n = A.length(), m = B.length();
		if (n + m != C.length()) return 0;

		boolean[][] dp = new boolean[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1);
				} else {
					dp[i][j] = (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1)) ||
							(dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1));
				}
			}
		}

		return dp[n][m] ? 1 : 0;
	}
}
