package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {
	public static void main(String[] args) {
		System.out.println(new ThreeSum().threeSumClosest(new ArrayList<>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3)), -1));
	}

	public int threeSumClosest(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int result = Integer.MAX_VALUE;
		int first, second, third;
		for (int i = 0; i < A.size(); i++) {
			first = A.get(i);
			for (int j = i + 1, k = A.size() - 1; j < k; ) {
				second = A.get(j);
				third = A.get(k);

				int sum = first + second + third;
				if (Math.abs((long) B - sum) < Math.abs((long) B - result)) {
					result = sum;
				}
				if (sum < B) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
}
