package interviewbit.DynamicProgramming;

import java.util.ArrayList;

public class MinJumpsArray {
    public int jump(ArrayList<Integer> A) {
        if (A.size() == 1) return 0;
        int maxReach = A.get(0);
        int lastReach = A.get(0);

        int jumps = 1;
        for (int i = 0; i < A.size(); i++) {
            if (maxReach < i) {
                return -1;
            }

            if (lastReach < i) {
                jumps++;
                lastReach = maxReach;
            }

            maxReach = Math.max(maxReach, i + A.get(i));
        }
        return jumps;
    }
}
