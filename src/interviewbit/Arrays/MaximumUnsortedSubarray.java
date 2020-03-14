package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumUnsortedSubarray {
	public ArrayList<Integer> subUnsort(ArrayList<Integer> list) {
		ArrayList<Integer> result = new ArrayList<>();
		int start = -1, end = list.size();
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				start = i;
				break;
			}
		}

		if (start == -1) return new ArrayList<>(Collections.singletonList(-1));

		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) < list.get(i - 1)) {
				end = i;
				break;
			}
		}

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			max = Math.max(max, list.get(i));
			min = Math.min(min, list.get(i));
		}

		for (int i = 0; i < start; i++) {
			if (list.get(i) > min) {
				start = i;
				break;
			}
		}

		for (int i = list.size() - 1; i > end; i--) {
			if (list.get(i) < max) {
				end = i;
				break;
			}
		}

		return new ArrayList<>(Arrays.asList(start, end));
	}
}
