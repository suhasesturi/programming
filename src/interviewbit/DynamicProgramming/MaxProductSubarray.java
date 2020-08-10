package interviewbit.DynamicProgramming;

import java.util.List;

public class MaxProductSubarray {
	public int maxProduct(final List<Integer> list) {
		if (list.isEmpty()) return 0;
		int maxSoFar = list.get(0);
		int minSoFar = list.get(0);
		int result = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Integer value = list.get(i);
			int tempMax = Math.max(Math.max(maxSoFar * value, minSoFar * value), value);
			minSoFar = Math.min(Math.min(maxSoFar * value, minSoFar * value), value);
			maxSoFar = tempMax;
			result = Math.max(result, maxSoFar);
		}
		return result;
	}
}
