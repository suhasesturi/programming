package leetcode.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length == 0) return result;

		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n];
		dp[n - 1] = 1;

		for (int i = n - 1; i >= 0; i--) {
			int max = 0;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] % nums[i] == 0) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = 1 + max;
		}

		int max = 0, index = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] > max) {
				max = dp[i];
				index = i;
			}
		}

		for (int i = index; i < n; i++) {
			if (dp[i] == max && nums[i] % nums[index] == 0) {
				max--;
				result.add(nums[i]);
				index = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 6};
		List<Integer> integers = new LargestDivisibleSubset().largestDivisibleSubset(a);
		for (int i = 0; i < integers.size(); i++) {
			System.out.println(integers.get(i));
		}
	}
}
