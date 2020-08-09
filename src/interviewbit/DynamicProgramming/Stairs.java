package interviewbit.DynamicProgramming;

public class Stairs {
	public int climbStairs(int A) {
		int[] dp = new int[A + 1];
		dp[1] = 1;
		if (A > 1) dp[2] = 2;
		for (int i = 3; i <= A; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[A];
	}
}
