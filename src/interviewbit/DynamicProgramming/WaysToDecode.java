package interviewbit.DynamicProgramming;

public class WaysToDecode {
	public int numDecodings(String A) {
		int MOD = (int) 1e9 + 7;
		int n = A.length();
		if (n == 0) return 0;

		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = A.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			if (A.charAt(i - 1) != '0') {
				dp[i] = dp[i - 1];
			}

			int twoDigit = Integer.parseInt(A.substring(i - 2, i));
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % MOD;
			}
		}
		return (int) dp[n];
	}
}
