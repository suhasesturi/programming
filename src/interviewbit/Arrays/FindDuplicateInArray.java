package interviewbit.Arrays;

import java.util.List;

public class FindDuplicateInArray {
	public int repeatedNumber(final List<Integer> list) {
		int actual = 0;
		int expected = 0;
		for (int i = 0; i < list.size(); i++) {
			actual ^= list.get(i);
			expected ^= i;
		}

		return actual ^ expected;
	}
}
