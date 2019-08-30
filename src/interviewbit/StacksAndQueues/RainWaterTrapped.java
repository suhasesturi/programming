package interviewbit.StacksAndQueues;

import java.util.List;

public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int result = 0;
        int n = A.size();
        int leftMax = 0;
        int rightMax = n - 1;
        for (int i = 0, j = n - 1; i <= j; ) {
            if (A.get(leftMax) <= A.get(rightMax)) {
                if (A.get(i) < A.get(leftMax))
                    result += A.get(leftMax) - A.get(i);
                else
                    leftMax = i;
                i++;
            } else {
                if (A.get(j) < A.get(rightMax))
                    result += A.get(rightMax) - A.get(j);
                else
                    rightMax = j;
                j--;
            }
        }
        return result;
    }
}