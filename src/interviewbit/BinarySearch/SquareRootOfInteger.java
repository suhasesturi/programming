package interviewbit.BinarySearch;

public class SquareRootOfInteger {
	public static void main(String[] args) {
		System.out.println(new SquareRootOfInteger().sqrt(2147483647));
	}

	public int sqrt(int A) {
		long a = 0, b = A;
		while (a < b) {
			long mid = (a + b + 1) / 2;
			long square = mid * mid;
			if (square == A) return (int) mid;
			if (square < A) a = mid;
			else b = mid - 1;
		}
		return (int) a;
	}
}
