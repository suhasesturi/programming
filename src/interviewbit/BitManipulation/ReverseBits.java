package interviewbit.BitManipulation;

public class ReverseBits {
	public long reverse(long a) {
		long result = 0;
		for (int i = 0; i < 32; i++) {
			if ((a & (1L << i)) != 0) {
				result ^= 1L << (32 - i - 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverse(3L));
	}
}