package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {
	public ArrayList<Integer> flip(String s) {
		int maxSum = 0;
		int currentSum = 0;
		int left = 0, right = 0;
		int currentLeft = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '0') {
				currentSum++;
			} else {
				currentSum--;
			}

			if (maxSum < currentSum) {
				maxSum = currentSum;
				left = currentLeft;
				right = i;
			}

			if (currentSum < 0) {
				currentLeft = i + 1;
				currentSum = 0;
			}
		}

		if (maxSum > 0) {
			return new ArrayList<>(Arrays.asList(left, right));
		}

		return new ArrayList<>();
	}
}
