package interviewbit.BinarySearch;

import java.util.List;

public class RotatedSortedArraySearch {
    public int search(final List<Integer> list, int x) {
        int a = 0, b = list.size() - 1;
        while (a <= b) {
            int mid = (a + b) / 2;
            if (list.get(mid) == x) return mid;
            if (list.get(mid) > list.get(a)) {
                if (x >= list.get(a) && x < list.get(mid)) {
                    b = mid - 1;
                } else {
                    a = mid + 1;
                }
            } else {
                if (x <= list.get(b) && list.get(mid) < x) {
                    a = mid + 1;
                } else {
                    b = mid - 1;
                }
            }
        }
        return -1;
    }

	private int findPivot(List<Integer> list) {
		int n = list.size();
		int a = 0, b = n - 1;
		while (a <= b) {
			if (list.get(a) <= list.get(b)) return a;

			int mid = (a + b) / 2;
			int i = list.get((mid - 1 + n) % n);
			int j = list.get(mid);
			int k = list.get((mid + 1) % n);

			if (i > j) return mid;
			if (j > k) return (mid + 1) % n;
			if (list.get(a) < j) a = mid + 1;
			else b = mid - 1;
		}
		return -1;
	}
}



