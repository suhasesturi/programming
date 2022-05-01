package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeAnagrams {
	public static void main(String[] args) {
		int[] primes = new PrimeAnagrams().primes("39151687");
		System.out.println(primes[0]);
		System.out.println(primes[1]);
		System.out.println(primes[2]);
	}

	private boolean[] primesArr = new boolean[1000010];
	private ArrayList<Integer> primes = new ArrayList<>();
	private int[] result = new int[3];
	private int min = Integer.MAX_VALUE;

	public int[] primes(String anagram) {
		calculatePrimes();
		permute(anagram.toCharArray(), 0, anagram.length());
		Arrays.sort(result);
		return min < Integer.MAX_VALUE ? result : new int[0];
	}

	private void permute(char[] anagram, int l, int r) {
		if (l >= r) {
			String s = String.valueOf(anagram);
			for (int i = 1; i < r; i++) {
				for (int j = i + 1; j < r; j++) {
					findPrimes(s.substring(0, i), s.substring(i, j), s.substring(j));
				}
			}
		} else {
			for (int i = l; i < r; i++) {
				swap(anagram, l, i);
				permute(anagram, l + 1, r);
				swap(anagram, l, i);
			}
		}
	}

	private void swap(char[] anagram, int l, int i) {
		char temp = anagram[l];
		anagram[l] = anagram[i];
		anagram[i] = temp;
	}

	private void findPrimes(String x, String y, String z) {
		if (x.charAt(0) == '0') return;
		if (y.charAt(0) == '0') return;
		if (z.charAt(0) == '0') return;

		int X = Integer.parseInt(x);
		int Y = Integer.parseInt(y);
		int Z = Integer.parseInt(z);

		if (primesArr[X] && primesArr[Y] && primesArr[Z] && X * Y * Z < min) {
			min = X * Y * Z;
			result[0] = X;
			result[1] = Y;
			result[2] = Z;
		}
	}

	private void calculatePrimes() {
		for (int i = 2; i < 1000000; i++) {
			if (isPrime(i)) {
				primes.add(i);
				primesArr[i] = true;
			}
		}
	}

	private boolean isPrime(int n) {
		for (int i = 0; i < primes.size() && primes.get(i) * primes.get(i) <= n; i++) {
			if (n % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
}
