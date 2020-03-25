package interviewbit.Math;

public class GridUniquePaths {
	public int uniquePaths(int a, int b) {
		if (a == 0 || b == 0) return 0;

		long result = 1;
		for (int i = a + b - 2, j = 1; j < Math.min(a, b); j++, i--) {
			result *= i;
			result /= j;
		}
		return (int) result;
	}
}
