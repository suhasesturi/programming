package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubSequence {
	public int longestSubsequenceLength(final List<Integer> A) {
		int[] left = increasingSubsequence(A);
		ArrayList<Integer> reverseList = new ArrayList<>();
		for (int i = A.size() - 1; i >= 0; i--) reverseList.add(A.get(i));
		int[] reverse = increasingSubsequence(reverseList);

		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			max = Math.max(max, left[i] + reverse[A.size() - i - 1] - 1);
		}
		return max;
	}

	private int[] increasingSubsequence(List<Integer> list) {
		int[] dp = new int[list.size()];
		Arrays.fill(dp, 1);

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(i) > list.get(j)) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}
		return dp;
	}
}
