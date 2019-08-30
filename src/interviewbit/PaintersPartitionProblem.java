package interviewbit;

import java.util.ArrayList;

public class PaintersPartitionProblem {
    public int paint(int A, int B, ArrayList<Integer> C) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        if (C.isEmpty() || A == 0 || B == 0) return 0;

        for (int c : C) {
            low = Math.max(low, c);
            high += c;
        }

        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;
            int count = 1;
            long currentSum = 0;
            for (Integer c : C) {
                currentSum += c;
                if (currentSum > mid) {
                    currentSum = c;
                    count++;
                }
            }

            if (count <= A) {
                high = mid - 1;
                result = Math.min(result, mid);
            } else {
                low = mid + 1;
            }
        }

        return (int) ((result * (long) B) % 10000003);
    }
}


