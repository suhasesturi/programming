package topcoder;

public class PrimePolynom {
	public int reveal(int a, int b, int c) {
		int m = 0;
		while (isPrime(a * m * m + b * m + c)) m++;
		return m;
	}

	private boolean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
