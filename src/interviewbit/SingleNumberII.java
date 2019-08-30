package interviewbit;

import java.util.List;

public class SingleNumberII {
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int x = 1 << i;
            for (int a : A) {
                if ((a & x) == 0) {
                    sum++;
                }
            }
            if (sum % 3 == 0)
                result = result | x;
        }
        return result;
    }
}
