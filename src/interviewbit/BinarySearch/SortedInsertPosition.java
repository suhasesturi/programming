package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {
	public static void main(String[] args) {
		System.out.println(new SortedInsertPosition().searchInsert(new ArrayList<>(Arrays.asList(1, 3, 5, 6)), 2));
	}

	public int searchInsert(ArrayList<Integer> list, int x) {
		int a = 0, b = list.size() - 1;
		while (a <= b) {
			int mid = (a + b) / 2;
			if (list.get(mid) == x) return mid;
			if (list.get(mid) < x) a = mid + 1;
			else b = mid - 1;
		}
		return a;
	}
}
