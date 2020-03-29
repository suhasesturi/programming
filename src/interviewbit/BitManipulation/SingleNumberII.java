package interviewbit.BitManipulation;

import java.util.List;

public class SingleNumberII {
    public int singleNumber(final List<Integer> list) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int powerOf2 = 1 << i;
            int count = 0;
            for (Integer integer : list) {
                if ((powerOf2 & integer) != 0) count++;
            }
            if (count % 3 != 0) {
                result ^= powerOf2;
            }
        }
        return result;
    }
}
