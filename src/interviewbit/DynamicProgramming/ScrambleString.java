package interviewbit.DynamicProgramming;

public class ScrambleString {
	public int isScramble(final String A, final String B) {
		if (A.length() != B.length()) return 0;
		int n = A.length();
		boolean[][][] dp = new boolean[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j][0] = true;
				}
			}
		}

		for (int len = 1; len < n; len++) {
			for (int i = 0; i + len < n; i++) {
				for (int j = 0; j + len < n; j++) {
					for (int k = 0; k < len; k++) {
						if ((dp[i][j][k] && dp[i + k + 1][j + k + 1][len - k - 1]) ||
								(dp[i][j + len - k][k] && dp[i + k + 1][j][len - k - 1])) {
							dp[i][j][len] = true;
							break;
						}
					}
				}
			}
		}

		return dp[0][0][n - 1] ? 1 : 0;
	}
}
