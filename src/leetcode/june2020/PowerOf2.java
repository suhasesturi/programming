package leetcode.june2020;

public class PowerOf2 {
	public static void main(String[] args) {
		System.out.println(new PowerOf2().isPowerOfTwo(128));
	}
	public boolean isPowerOfTwo(int n) {
		if (n == 0) return false;
		while (n != 1) {
			if (n % 2 != 0) return false;
			n = n / 2;
		}
		return true;
	}
}
