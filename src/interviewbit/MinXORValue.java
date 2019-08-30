package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORValue {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            result = Math.min(result, A.get(i) ^ A.get(i + 1));
        }
        return result;
    }
}
