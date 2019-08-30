package interviewbit;

import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        int high = 0, low = Integer.MIN_VALUE;
        for (int a : A) {
            low = Math.max(low, a);
            high += a;
        }

        if (B > A.size()) return -1;

        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int count = 1;
            int optimum = (low + high) / 2;
            int currentSum = 0;
            for (Integer a : A) {
                currentSum += a;

                if (currentSum > optimum) {
                    currentSum = a;
                    count++;
                }
            }

            if (count <= B) {
                high = optimum - 1;
                result = Math.min(result, optimum);
            } else {
                low = optimum + 1;
            }
        }

        return result;
    }
}
