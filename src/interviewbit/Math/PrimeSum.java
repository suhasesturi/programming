package interviewbit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {
	private ArrayList<Integer> primes = new ArrayList<>();

	public ArrayList<Integer> primesum(int A) {
		computePrimes();
		for (Integer prime : primes) {
			if (isPrime(A - prime)) {
				return new ArrayList<>(Arrays.asList(prime, A - prime));
			}
		}
		return null;
	}

	private void computePrimes() {
		for (int i = 2; i <= 100000; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}

	private boolean isPrime(int a) {
		for (int i = 0; i < primes.size() && primes.get(i) <= Math.sqrt(a); i++) {
			if (a % primes.get(i) == 0) return false;
		}
		return true;
	}
}
