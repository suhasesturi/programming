package interviewbit.TwoPointers;

import java.util.List;

public class Array3Pointers {
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		int result = Integer.MAX_VALUE;
		for (int i = 0, j = 0, k = 0; i < a.size() && j < b.size() && k < c.size(); ) {
			int first = Math.abs(a.get(i) - b.get(j));
			int second = Math.abs(b.get(j) - c.get(k));
			int third = Math.abs(c.get(k) - a.get(i));

			if (first >= second && first >= third) {
				result = Math.min(result, first);
				if (a.get(i) < b.get(j)) i++;
				else j++;
			} else if (second >= first && second >= third) {
				result = Math.min(result, second);
				if (b.get(j) < c.get(k)) j++;
				else k++;
			} else {
				result = Math.min(result, third);
				if (c.get(k) < a.get(i)) k++;
				else i++;
			}
		}
		return result;
	}
}
