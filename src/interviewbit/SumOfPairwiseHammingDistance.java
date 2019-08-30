package interviewbit;

import java.util.List;

public class SumOfPairwiseHammingDistance {
    public int hammingDistance(final List<Integer> A) {
        long result = 0;
        long powerOf2 = 1;
        while (powerOf2 < Integer.MAX_VALUE) {
            int zeroes = 0, ones = 0;
            for (int i = 0; i < A.size(); i++) {
                if ((powerOf2 & A.get(i)) == 0) zeroes++;
                else ones++;
            }
            result = (result + (2 * ((long) zeroes * ones) % 1000000007)) % 1000000007;
            powerOf2 *= 2;
        }
        return (int) result;
    }
}


