package interviewbit.DynamicProgramming;

public class RepeatingSubSequence {
	public int anytwo(String A) {
		int n = A.length();
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j && A.charAt(i - 1) == A.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][n] >= 2 ? 1 : 0;
	}
}
