package codeforces.SuffixArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SuffixArray1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next() + "$";
		int n = s.length();
		Pair<Character, Integer>[] a = new Pair[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Pair<>(s.charAt(i), i);
		}

		Arrays.sort(a, Comparator.comparing(x -> x.first));
		int[] positions = new int[n];
		int[] eq = new int[n];
		for (int i = 0; i < n; i++) {
			positions[i] = a[i].second;
		}
		eq[positions[0]] = 0;
		for (int i = 1; i < n; i++) {
//			if (a[i].first == a[i - 1].first)
//			eq[positions[i]]
		}

		int k = 0;
		while ((1 << k) < n) {
			k++;
		}
	}

	static class Pair<K, V> {
		K first;
		V second;

		Pair(K first, V second) {
			this.first = first;
			this.second = second;
		}
	}
}
