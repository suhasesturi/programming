package interviewbit.Math;

import java.util.List;

public class SumOfPairwiseHammingDistance {
	private final int MOD = 1000000007;

	public int hammingDistance(final List<Integer> list) {
		long result = 0;
		int current = 1;

		for (int i = 0; i < 32; i++) {
			int zeros = 0, ones = 0;
			for (Integer integer : list) {
				if ((current & integer) != 0) {
					ones++;
				} else {
					zeros++;
				}
			}
			current <<= 1;
			result = (result + ((long) zeros * ones) % MOD) % MOD;
		}
		return (int) ((result * 2) % MOD);
	}
}


