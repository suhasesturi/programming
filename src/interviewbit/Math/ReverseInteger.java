package interviewbit.Math;

public class ReverseInteger {
	public int reverse(int number) {
		boolean positive = number >= 0;
		number = Math.abs(number);
		long reverse = 0;

		while (number > 0) {
			reverse = reverse * 10 + number % 10;
			if (reverse > Integer.MAX_VALUE) return 0;
			number /= 10;
		}

		return (int) (positive ? reverse : -reverse);
	}
}
