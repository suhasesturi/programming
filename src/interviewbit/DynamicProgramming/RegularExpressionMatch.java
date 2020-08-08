package interviewbit.DynamicProgramming;

public class RegularExpressionMatch {
	public int isMatch(final String text, final String pattern) {
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= text.length(); i++) dp[i][0] = false;
		for (int j = 1; j <= pattern.length(); j++) {
			if (pattern.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
			else dp[0][j] = false;
		}

		for (int i = 1; i <= text.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {
				if (pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else if (pattern.charAt(j - 1) == '?' || (pattern.charAt(j - 1) == text.charAt(i - 1))) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[text.length()][pattern.length()] ? 1 : 0;
	}
}
