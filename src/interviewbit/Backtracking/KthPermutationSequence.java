package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class KthPermutationSequence {
	private final ArrayList<Integer> factorial = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(new KthPermutationSequence().getPermutation(4, 3));
	}

	public String getPermutation(int n, int k) {
		StringBuilder builder = new StringBuilder();
		boolean[] used = new boolean[n + 1];
		Arrays.fill(used, false);
		int start = 1;

		long f = 1;
		int i = 2;
		factorial.add(1);
		while (f <= k) {
			factorial.add((int) f);
			f *= i;
			i++;
		}

		while (n-- > 0) {
			int current = firstNumber(n, k), count = 0;
			for (i = start; i < used.length && count < current; i++) if (!used[i]) count++;
			builder.append(i - 1);
			used[i - 1] = true;

			while (start < used.length && used[start]) start++;
			if (n < factorial.size()) {
				k -= factorial.get(n) * (current - 1);
			}
		}

		return builder.toString();
	}

	private int firstNumber(int n, int k) {
		if (factorial.size() > n) {
			return (int) Math.ceil(k * 1.0 / factorial.get(n));
		} else {
			return 1;
		}
	}
}
