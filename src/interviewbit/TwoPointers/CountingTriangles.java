package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class CountingTriangles {
	public int nTriang(ArrayList<Integer> A) {
		long result = 0;
		Collections.sort(A);
		int mod = (int) 1e9 + 7;
		int first, second;
		int n = A.size();
		for (int i = 0; i < n; i++) {
			first = A.get(i);
			if (first == 0) continue;
			for (int j = i + 1; j < n; j++) {
				second = A.get(j);
				int index = binarySearch(A, j + 1, first + second);
				if (index != -1) {
					result = (result + index - j) % mod;
				}
			}
		}

		return (int) result;
	}

	private int binarySearch(ArrayList<Integer> list, int low, int x) {
		int high = list.size() - 1;
		while (low < high) {
			int mid = (low + high + 1) / 2;
			if (list.get(mid) >= x) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}
		if (low >= list.size() || list.get(low) >= x) return -1;
		return low;
	}
}
