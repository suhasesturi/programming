package interviewbit.TwoPointers;

import java.util.List;

public class MinimizeTheAbsoluteDifference {
	public int solve(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		int result = Integer.MAX_VALUE;
		for (int i = 0, j = 0, k = 0; i < a.size() && j < b.size() && k < c.size(); ) {
			int first = a.get(i);
			int second = b.get(j);
			int third = c.get(k);

			int min = Math.min(Math.min(first, second), third);
			int max = Math.max(Math.max(first, second), third);

			result = Math.min(Math.abs(max - min), result);
			if (min == first) {
				i++;
			} else if (min == second) {
				j++;
			} else {
				k++;
			}
		}
		return result;
	}
}
