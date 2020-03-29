package interviewbit;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public int maxArea(ArrayList<Integer> A) {
        int result = 0;
        for (int i = 0, j = A.size() - 1; i < j; ) {
            result = Math.max(result, (j - i) * Math.min(A.get(i), A.get(j)));
            if (A.get(i) < A.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}