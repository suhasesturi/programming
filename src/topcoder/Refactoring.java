package topcoder;

import java.util.ArrayList;

public class Refactoring {
	private ArrayList<Integer> primes = new ArrayList<>();

	private boolean isPrime(int n) {
		for (int i = 0; i < primes.size() && primes.get(i) * primes.get(i) <= n; i++) {
			if (n % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}

	public int refactor(int n) {
		return 0;
	}
}
