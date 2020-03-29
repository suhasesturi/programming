package interviewbit.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORValue {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < A.size(); i++) {
            result = Math.min(result, A.get(i) ^ A.get(i - 1));
        }
        return result;
    }
}
