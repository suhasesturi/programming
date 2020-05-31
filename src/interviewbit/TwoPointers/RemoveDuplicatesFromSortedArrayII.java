package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3))));
	}

	public int removeDuplicates(ArrayList<Integer> a) {
		int position = 0, count = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(position).equals(a.get(i))) {
				if (position == 0 || a.get(position).equals(a.get(position - 1))) {
					count++;
					if (count <= 2) position++;
				} else {
					count = 1;
					position++;
				}
			} else {
				a.set(position, a.get(i));
				if (!a.get(position - 1).equals(a.get(i))) {
					count = 1;
					position++;
				} else {
					count++;
					if (count <= 2) position++;
				}
			}
		}
		return position;
	}
}
