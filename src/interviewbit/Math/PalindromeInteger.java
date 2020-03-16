package interviewbit.Math;

public class PalindromeInteger {
	public int isPalindrome(int A) {
		if (A < 0) return 0;
		int temp = A;

		int reverse = 0;
		while (temp > 0) {
			reverse = reverse * 10 + temp % 10;
			temp /= 10;
		}

		return (reverse == A) ? 1 : 0;
	}
}
