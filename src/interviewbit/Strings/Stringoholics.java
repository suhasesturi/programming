package interviewbit.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Stringoholics {
	public static void main(String[] args) {
		new Stringoholics().longestPrefix("ababa");
		System.out.println(new Stringoholics().solve(new ArrayList<>(Arrays.asList("a", "ababa", "aba"))));
	}

	public int solve(ArrayList<String> A) {
		long[] time = new long[A.size()];
		for (int i = 0; i < A.size(); i++) {
			int n = A.get(i).length();
			int k = longestPrefix(A.get(i));
			if (n % (n - k) == 0) {
				n = n - k;
			}
			long t = 1;
			long current = 1;
			while (current % n != 0) {
				t++;
				current += t;
			}
			time[i] = t;
		}
		long result = 1;
		int mod = (int) 1e9 + 7;
		for (int i = 0; i < time.length; i++) {
			for (int j = i + 1; j < time.length; j++) {
				time[j] = time[j] / gcd(time[j], time[i]);
			}
			result = (result * time[i]) % mod;
		}
		return (int) result;
	}

	private long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	private int longestPrefix(String p) {
		int m = p.length();
		int[] pi = new int[m];
		int k = 0;
		for (int i = 1; i < m; i++) {
			while (k != 0 && p.charAt(k) != p.charAt(i)) {
				k = pi[k - 1];
			}
			if (p.charAt(k) == p.charAt(i)) {
				pi[i] = ++k;
			}
			if (k == 0) {
				pi[i] = 0;
			}
		}
		return pi[m - 1];
	}
}
