package interviewbit.BitManipulation;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {
    public int cntBits(ArrayList<Integer> A) {
        long ans = 0;
        int mod = (int)1e9 + 7;
        for (int i = 0; i < 31; i++) {
            int zeroes = 0, ones = 0;
            for (Integer a : A) {
                if ((a & 1L << i) == 0) zeroes++;
                else ones++;
            }

            ans = (ans + (2 * (zeroes * (long) ones)) % mod) % mod;
        }
        return (int) ans % mod;
    }
}
