package interviewbit.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestMultipleWith0And1 {
	public String multiple(int A) {
		if (A < 2) return String.valueOf(A);

		Queue<Pair> queue = new LinkedList<>();
		int[] dp = new int[A];
		dp[1] = 1;
		queue.add(new Pair(1, "1"));
		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			if (current.remainder == 0) return current.value;
			for (int digit : new int[]{0, 1}) {
				int remainder = (current.remainder * 10 + digit) % A;
				if (dp[remainder] == 0) {
					dp[remainder] = 1;
					queue.add(new Pair(remainder, current.value + digit));
				}
			}
		}
		return "";
	}

	static class Pair {
		int remainder;
		String value;

		Pair(int a, String b) {
			remainder = a;
			value = b;
		}
	}
}
