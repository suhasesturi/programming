package interviewbit.Math;

public class PowerOfTwoIntegers {
	public int isPower(int A) {
		if (A == 1) return 1;
		for (int i = 2; i <= (int) Math.sqrt(A); i++) {
			long result = 1;
			while (result < A) {
				result *= i;
				if (result == A) return 1;
			}
		}
		return 0;
	}
}
