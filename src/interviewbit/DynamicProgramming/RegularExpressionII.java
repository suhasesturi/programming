package interviewbit.DynamicProgramming;

public class RegularExpressionII {
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[n][m] = true;

        for (int i = n; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                boolean flag = i < n && (A.charAt(i) == B.charAt(j) || B.charAt(j) == '.');
                if (j + 1 < m && B.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (flag && dp[i + 1][j]);
                } else {
                    dp[i][j] = flag && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0] ? 1 : 0;
    }
}
