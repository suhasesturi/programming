package interviewbit.DynamicProgramming;

import java.util.ArrayList;

public class MinJumpsArray {
	public int jump(ArrayList<Integer> A) {
		int jumps = 0, currentRange = 0, nextRange = 0;
		for (int i = 0; i <= currentRange; i++) {
			if (i == A.size() - 1) {
				return jumps;
			}

			nextRange = Math.max(nextRange, i + A.get(i));
			if (i == currentRange) {
				jumps++;
				currentRange = nextRange;
			}
		}
		return -1;
	}
}
