package interviewbit.DynamicProgramming;

import java.util.ArrayList;

public class JumpGameArray {
	public int canJump(ArrayList<Integer> A) {
		boolean[] dp = new boolean[A.size()];
		dp[A.size() - 1] = true;
		for (int i = A.size() - 2; i >= 0; i--) {
			for (int j = A.get(i); j >= 1; j--) {
				if (i + j >= A.size() || dp[i + j]) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[0] ? 1 : 0;
	}
}
