package interviewbit.Arrays;

import java.util.List;

public class LargestNumber {
	public String largestNumber(final List<Integer> list) {
		list.sort((a, b) -> (b + String.valueOf(a)).compareTo(a + String.valueOf(b)));
		StringBuilder builder = new StringBuilder();
		for (Integer integer : list) {
			builder.append(integer);
		}

		return builder.charAt(0) == '0' ? "0" : builder.toString();
	}
}
