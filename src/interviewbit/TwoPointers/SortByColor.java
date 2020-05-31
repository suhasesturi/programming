package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {
	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2));
		new SortByColor().sortColors(integers);
		System.out.println();
	}

	public void sortColors(ArrayList<Integer> a) {
		int begin = 0, end = a.size() - 1;
		for (int i = 0; i <= end; ) {
			switch (a.get(i)) {
				case 0:
					swap(a, i, begin);
					begin++;
					i++;
					break;
				case 1:
					i++;
					break;
				case 2:
					swap(a, i, end);
					end--;
					break;
			}
		}
	}

	private void swap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}
