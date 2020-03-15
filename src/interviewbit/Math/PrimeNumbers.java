package interviewbit.Math;

import java.util.ArrayList;

public class PrimeNumbers {
	static private ArrayList<Integer> primes = new ArrayList<>();

	private static boolean isPrime(int n) {
		boolean isPrime = true;

		for (int j = 0; j < primes.size() && primes.get(j) <= Math.sqrt(n); j++) {
			if (n % primes.get(j) == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	public ArrayList<Integer> sieve(int a) {
		for (int i = 2; i <= a; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		return primes;
	}
}
