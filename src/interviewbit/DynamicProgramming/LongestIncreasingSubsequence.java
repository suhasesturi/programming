package interviewbit.DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence().lis(Arrays.asList(84, 80, 27)));
	}

	public int lis(final List<Integer> A) {
		int[] lis = new int[A.size()];
		Arrays.fill(lis, 1);

		PriorityQueue<int[]> a = new PriorityQueue<>();
		a.add(new int[]{1, 2});
		boolean s = a != a;
		int result = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (A.get(i) > A.get(j))
					lis[i] = Math.max(lis[i], 1 + lis[j]);
			}
			result = Math.max(result, lis[i]);
		}

		return result;
	}
}
