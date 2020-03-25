package interviewbit.BinarySearch;

import java.util.List;

public class RotatedArray {
	public int findMin(final List<Integer> list) {
		int n = list.size();
		int a = 0, b = n - 1;
		while (a <= b) {
			if (list.get(a) <= list.get(b)) return list.get(a);

			int mid = (a + b) / 2;
			int i = list.get((mid - 1 + n) % n);
			int j = list.get(mid);
			int k = list.get((mid + 1) % n);

			if (i > j) return j;
			if (j > k) return k;
			if (list.get(a) < j) a = mid + 1;
			else b = mid - 1;
		}
		return -1;
	}
}
