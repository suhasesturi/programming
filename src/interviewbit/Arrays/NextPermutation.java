package interviewbit.Arrays;

import java.util.ArrayList;

public class NextPermutation {
	public ArrayList<Integer> nextPermutation(ArrayList<Integer> list) {
		int n = list.size();
		int index = -1;
		for (int i = n - 1; i > 0; i--) {
			if (list.get(i - 1) < list.get(i)) {
				index = i - 1;
				break;
			}
		}

		if (index != -1) {
			for (int i = n - 1; i > index; i--) {
				if (list.get(i) > list.get(index)) {
					swap(i, index, list);
					break;
				}
			}
		}

		for (int i = index + 1, j = n - 1; i < j; i++, j--) {
			swap(i, j, list);
		}

		return list;
	}

	private void swap(int i, int j, ArrayList<Integer> list) {
		int temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
	}
}
