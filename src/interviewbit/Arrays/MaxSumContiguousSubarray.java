package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {
	public static void main(String[] args) {
		System.out.println(new MaxSumContiguousSubarray().maxSubArray(new ArrayList<>(Arrays.asList(10, -4, 2, 3))));
	}

	public int maxSubArray(final List<Integer> A) {
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for (Integer integer : A) {
			sum += integer;
			result = Math.max(result, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return result;
	}
}
