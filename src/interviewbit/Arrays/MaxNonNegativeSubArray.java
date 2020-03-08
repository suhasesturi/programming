package interviewbit.Arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
	public ArrayList<Integer> maxset(ArrayList<Integer> list) {
		long currentSum = 0;
		long maxSum = -1;
		int left = 0, right = -1, currentLeft = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 0) {
				currentSum = 0;
				currentLeft = i + 1;
			} else {
				currentSum += list.get(i);
				if (maxSum < currentSum) {
					maxSum = currentSum;
					left = currentLeft;
					right = i;
				} else if (currentSum == maxSum) {
					if ((i - currentLeft) > (right - left)) {
						left = currentLeft;
						right = i;
					}
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			result.add(list.get(i));
		}
		return result;
	}
}
