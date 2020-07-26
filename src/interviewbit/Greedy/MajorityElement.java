package interviewbit.Greedy;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {
	public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(Arrays.asList(2, 1, 2)));
	}

	public int majorityElement(final List<Integer> A) {
		int count = 0, element = -1;
		for (int i = 0; i < A.size(); i++) {
			if (count == 0 || A.get(i) == element) {
				count++;
				element = A.get(i);
			} else {
				count--;
			}
		}
		return element;
	}
}
