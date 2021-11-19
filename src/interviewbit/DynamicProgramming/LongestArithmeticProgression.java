package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestArithmeticProgression {
	public int solve(final List<Integer> A) {
		if (A == null || A.isEmpty()) return 0;
		int result = 1;
		ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			dp.add(new HashMap<>());
			for (int j = 0; j < i; j++) {
				int diff = A.get(i) - A.get(j);
				dp.get(i).put(diff, dp.get(j).getOrDefault(diff, 1) + 1);
				result = Math.max(result, dp.get(i).get(diff));
			}
		}
		return result;
	}
}
