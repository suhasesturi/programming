package interviewbit.BitManipulation;

public class DivideIntegers {
	public int divide(int A, int B) {
		if (A == 0) return 0;
		if (B == 0) return Integer.MAX_VALUE;

		long q = 0, temp = 0;
		int sign;
		if (A < 0 && B < 0) sign = 1;
		else if (A < 0) sign = -1;
		else if (B < 0) sign = -1;
		else sign = 1;

		long a = Math.abs((long) A);
		long b = Math.abs((long) B);

		for (int i = 31; i >= 0; i--) {
			if (temp + (b << i) <= a) {
				temp += b << i;
				q |= 1L << i;
			}
		}
		long ans = sign * q;
		return ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
	}

	public static void main(String[] args) {
		System.out.println(new DivideIntegers().divide(10, 4));
	}
}