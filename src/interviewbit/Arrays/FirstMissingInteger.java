package interviewbit.Arrays;

import java.util.ArrayList;

public class FirstMissingInteger {
	public int firstMissingPositive(ArrayList<Integer> list) {
		int j = list.size() - 1;
		for (int i = 0; i <= j; ) {
			if (list.get(i) <= 0) {
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
				j--;
			} else {
				i++;
			}
		}

		for (int i = 0; i <= j; i++) {
			int current = Math.abs(list.get(i));
			if (current - 1 < list.size() && list.get(current - 1) > 0) {
				list.set(current - 1, -list.get(current - 1));
			}
		}

		int i;
		for (i = 0; i <= j; i++) {
			if (list.get(i) > 0) {
				return i + 1;
			}
		}

		return i + 1;
	}
}
