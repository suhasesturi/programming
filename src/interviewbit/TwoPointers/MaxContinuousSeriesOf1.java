package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1 {
	public static void main(String[] args) {
		System.out.println(new MaxContinuousSeriesOf1().maxone(new ArrayList<>(
						Arrays.asList(0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1)),
				0
		));
	}

	public ArrayList<Integer> maxone(ArrayList<Integer> list, int m) {
		ArrayList<Integer> result = new ArrayList<>();
		int left = 0, right = 0, currentFlips = 0;
		int start = -1, length = 0, end = -1;
		while (right < list.size()) {
			if (list.get(right) == 0) {
				if (currentFlips < m) {
					currentFlips++;
				} else {
					for (int i = left; i < list.size(); i++) {
						if (list.get(i) == 0) {
							left = i + 1;
							break;
						}
					}
				}
			}
			right++;
			if ((right - left) > length) {
				length = right - left;
				start = left;
				end = right;
			}
		}

		for (int i = start; i < end; i++) {
			result.add(i);
		}
		return result;
	}
}
