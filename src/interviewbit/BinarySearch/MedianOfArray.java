package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {
	public static void main(String[] args) {
        System.out.println(new MedianOfArray().findMedianSortedArrays(
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(20)))
        );
    }

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int m = a.size();
		int n = b.size();
		if (n < m) return findMedianSortedArrays(b, a);

		int low = 0, high = m;
		while (low <= high) {
			int i = (low + high) / 2;
			int j = (m + n + 1) / 2 - i;
			if (j > 0 && i < m && b.get(j - 1) > a.get(i)) low = i + 1;
			else if (i > 0 && j < n && a.get(i - 1) > b.get(j)) high = i - 1;
			else {
				int max;
				if (i == 0) max = b.get(j - 1);
				else if (j == 0) max = a.get(i - 1);
				else max = Math.max(a.get(i - 1), b.get(j - 1));
				if ((n + m) % 2 != 0) return max;

				int min;
				if (i == m) min = b.get(j);
				else if (j == n) min = a.get(i);
				else min = Math.min(a.get(i), b.get(j));
				return (min + max) / 2.0;
			}
		}
		return 0;
	}
}
