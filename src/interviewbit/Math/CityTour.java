package interviewbit.Math;

import java.util.ArrayList;
import java.util.Collections;

public class CityTour {
	/*
	This question uses the concept of combinatorics. We can see vector B as ranges to be arranged, but we also have to select the order in which the elements of a single group are chosen within themselves.

Suppose we have a single group G1 consisting N numbers, so this group can be permuted in 2N-1 ways(as we can take from either side of the group and keep choosing until there is only one number left). Obviously the left most and right most group can be arranged among themselves in only one possible way.

Now consider another group G2 of M numbers. Now we have N + M places to place numbers of G2 or G1. So we can choose M places for G2 in N+MCM ways(or we can choose N places for G1 in N+MCN ways, both will be the same). And we can arrange numbers of G2 in 2M-1 ways. Thus we have N places left for numbers of G1, so we can place them in 2N-1 x NCN ways.

So we have 2N-1 x NCN x 2M-1 x N+MCM ways for numbers of G1 and G2 combined.

Can we see a pattern???
	 */
	private static final int MOD = (int) (1e9 + 7);
	public int solve(int A, ArrayList<Integer> B) {
		initialize();
		Collections.sort(B);
		int count = B.get(0) - 1;
		long result = 1;

		for (int i = 1; i < B.size(); i++) {
			int t = B.get(i) - B.get(i - 1) - 1;
			if (t > 0) {
				result = (((result * exp[t - 1]) % MOD) * comb[count + t][t]) % MOD;
				count += t;
			}
		}
		int t = A - B.get(B.size() - 1);
		result = (result * comb[count + t][t]) % MOD;
		return (int) result;
	}

	private long[][] comb = new long[1001][1001];
	private long[] exp = new long[1001];

	private void initialize() {
		exp[0] = 1;
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) comb[i][j] = 1;
				else comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
			}
			if (i != 0) {
				exp[i] = (exp[i - 1] * 2) % MOD;
			}
		}
	}
}
