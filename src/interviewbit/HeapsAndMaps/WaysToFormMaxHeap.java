package interviewbit.HeapsAndMaps;

import java.util.HashMap;
import java.util.Objects;

public class WaysToFormMaxHeap {
	private final HashMap<Pair, Integer> map = new HashMap<>();
	private final HashMap<Integer, Integer> dp = new HashMap<>();
	private final Integer MOD = (int) 1e9 + 7;

	public static void main(String[] args) {
		System.out.println(new WaysToFormMaxHeap().solve(4));
	}

	public int solve(int n) {
		if (n <= 1) return 1;
		if (dp.containsKey(n)) {
			return dp.get(n);
		}
		int left = leftCount(n);
		long result = ((long) choose(n - 1, left) * solve(left)) % MOD;
		result = (result * solve(n - 1 - left)) % MOD;
		dp.put(n, (int) result);
		return (int) result;
	}

	private Integer leftCount(int n) {
		int height = (int) (Math.log10(n) / Math.log10(2));
		int maxLastRow = (1 << height);
		int lastRow = n - ((1 << height) - 1);
		if (lastRow >= (maxLastRow / 2)) {
			return (1 << height) - 1;
		} else {
			return (1 << height) - 1 - (maxLastRow / 2 - lastRow);
		}
	}

	private Integer choose(int n, int k) {
		if (k > n) return 0;
		if (n <= 1 || k == 0) return 1;
		Pair pair = new Pair(n, k);
		if (map.containsKey(pair)) {
			return map.get(pair);
		}
		int answer = (int) ((long) choose(n - 1, k - 1) + choose(n - 1, k)) % MOD;
		map.put(pair, answer);
		return answer;
	}

	private static class Pair {
		int n, k;

		Pair(int a, int b) {
			n = a;
			k = b;
		}

		@Override
		public int hashCode() {
			return Objects.hash(n, k);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair) {
				Pair pair = (Pair) obj;
				return this.n == pair.n && this.k == pair.k;
			}
			return false;
		}
	}
}
