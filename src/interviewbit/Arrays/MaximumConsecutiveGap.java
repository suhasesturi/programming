package interviewbit.Arrays;

import java.util.Collections;
import java.util.List;

public class MaximumConsecutiveGap {
	public int maximumGap(final List<Integer> list) {
		Collections.sort(list);
		int difference = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			difference = Math.max(difference, list.get(i + 1) - list.get(i));
		}

		return difference;
	}
}
