package interviewbit.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRanksWithDuplicates {
	final int MOD = 1000003;
	private int[] fact;
	private int[] inverse;

	public static void main(String[] args) {
		System.out.println(new SortedPermutationRanksWithDuplicates().findRank("settLe"));
		System.out.println(new SortedPermutationRanksWithDuplicates().findRank("sadasdsasassasas"));
	}

	private int inverse(int a) {
		return power(a, MOD - 2, MOD);
	}

	private int power(int x, int y, int m) {
		if (y == 0) {
			return 1;
		}

		long p = power(x, y / 2, m);
		p = (p * p) % m;
		return (y % 2 == 0 ? (int) p : (int) ((x * p) % m));
	}

	public int findRank(String str) {
		long rank = 1;
		fact = new int[str.length() + 1];
		inverse = new int[str.length() + 1];
		fact[0] = 1;
		for (int i = 1; i <= str.length(); i++) {
			fact[i] = (int) (((long) fact[i - 1] * i) % MOD);
			inverse[i] = inverse(fact[i]);
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			ArrayList<Integer> integers = lowerCount(str, i, ch);
			rank = (rank + (((((long) fact[str.length() - i - 1] * integers.get(0)) % MOD) * integers.get(1)) % MOD)) % MOD;
		}
		return (int) (rank % MOD);
	}

	private ArrayList<Integer> lowerCount(String str, int index, char ch) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put(ch, 1);
		for (int i = index + 1; i < str.length(); i++) {
			char key = str.charAt(i);
			if (key < ch) {
				count++;
			}
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		long mul = 1;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			mul = (mul * inverse[entry.getValue()]) % MOD;
		}
		return new ArrayList<>(Arrays.asList(count, (int) mul));
	}
}
