package interviewbit.DynamicProgramming;

public class IntersectingChordsInACircle {
	public int chordCnt(int A) {
		long[] dp = new long[A + 1];
		dp[0] = 1;
		dp[1] = 1;
		int mod = (int) 1e9 + 7;
		for (int i = 2; i <= A; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]) % mod) % mod;
			}
		}
		return (int) dp[A];
	}
}
