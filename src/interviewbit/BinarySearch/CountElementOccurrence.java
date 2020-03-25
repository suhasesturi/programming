package interviewbit.BinarySearch;

import java.util.List;

public class CountElementOccurrence {
	public int findCount(final List<Integer> A, int B) {
		int low = binarySearchFirst(A, B);
		if (low < 0 || low > A.size() || A.get(low) != B) return 0;

		int high = binarySearchLast(A, B);
		return high - low + 1;
	}

	private int binarySearchLast(List<Integer> list, int x) {
		int a = 0, b = list.size() - 1;
		while (a < b) {
			int mid = (a + b + 1) / 2;
			if (list.get(mid) > x) {
				b = mid - 1;
			} else if (list.get(mid) < x) {
				a = mid + 1;
			} else {
				a = mid;
			}
		}
		return a;
	}

	private int binarySearchFirst(List<Integer> list, int x) {
		int a = 0, b = list.size() - 1;
		while (a < b) {
			int mid = (a + b) / 2;
			if (list.get(mid) > x) {
				b = mid - 1;
			} else if (list.get(mid) < x) {
				a = mid + 1;
			} else {
				b = mid;
			}
		}
		return a;
	}
}
