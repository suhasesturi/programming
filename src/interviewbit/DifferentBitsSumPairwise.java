package interviewbit;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {
    public int cntBits(ArrayList<Integer> A) {
        long result = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < 32; i++) {
            int zero = 0, one = 0;
            int x = 1 << i;
            for (int a : A) {
                if ((a & x) == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            result = (result + (2 * (zero * (long) one)) % mod) % mod;
        }
        return (int) result;
    }
}




