package interviewbit.Arrays;

import java.util.ArrayList;

public class FindPermutation {
	public ArrayList<Integer> findPerm(final String str, int n) {
		ArrayList<Integer> result = new ArrayList<>();
		int top = n, bottom = 1;
		if (str.charAt(0) == 'D') {
			result.add(top);
			top--;
		} else {
			result.add(bottom);
			bottom++;
		}

		for (int i = 0; i < str.length(); ) {
			char lead = str.charAt(i);
			int count = 0;
			while (i < str.length() && str.charAt(i) == lead) {
				count++;
				i++;
			}

			if (lead == 'D') {
				for (int j = bottom + count - 1; j >= bottom; j--) {
					result.add(j);
				}
				bottom += count;
			} else {
				for (int j = top - count + 1; j <= top; j++) {
					result.add(j);
				}
				top -= count;
			}
		}
		return result;
	}
}
